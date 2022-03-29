package com.company.CricketGame.services;

import com.company.CricketGame.bean.MatchBean;
import com.company.CricketGame.dto.MatchCreationResponseDto;
import com.company.CricketGame.dto.MatchDto;
import com.company.CricketGame.dto.PerBallDto;
import com.company.CricketGame.dto.TeamDto;
import com.company.CricketGame.enums.BattingOrBowlingType;
import com.company.CricketGame.enums.MatchType;
import com.company.CricketGame.repo.DatabaseRepo;
import com.company.CricketGame.repo.DatabaseRepoImpl;
import com.company.CricketGame.repo.MatchRepo;
import com.company.CricketGame.util.MatchUtils;
import jdk.jpackage.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

import static com.company.CricketGame.validator.InputValidator.validateBattingOrBowlingType;


@Component
@CacheConfig(cacheNames = {"matchId"})

public class MatchServiceImpl implements MatchService {

    @Autowired
    private final ScoreBoardService scoreBoardData;
    @Autowired
    private final MatchRepo matchRepo;
    @Autowired
    TeamService teamService;

    public MatchServiceImpl(ScoreBoardService scoreBoardData, MatchRepo matchRepo, TeamService teamService){
        this.scoreBoardData = scoreBoardData;
        this.matchRepo = matchRepo;
        this.teamService = teamService;
    }

    @CachePut(cacheNames = "matchCache")
    public MatchBean startMatch(MatchCreationResponseDto matchCreationResponse){
        MatchDto matchData = new MatchDto();
        matchData.setTeam1Name(matchCreationResponse.getTeam1Name());
        matchData.setTeam2Name(matchCreationResponse.getTeam2Name());
        MatchType applyingMatchType;
        applyingMatchType = MatchType.valueOf(matchCreationResponse.getMatchType());
        matchData.setNumberOfOvers(applyingMatchType.getOverInThisType()) ;

        int winnerOfToss = performToss();
        if(winnerOfToss==1){
            matchData.setTossWinner(matchData.getTeam1().getTeamName());
        }
        else{
            matchData.setTossWinner(matchData.getTeam2().getTeamName());
        }
        matchData.setMatchId(getNewMatchId());

        performInningSchedule(winnerOfToss, matchData);
        scoreBoardData.showTeam1ScoreCard(matchData);
        scoreBoardData.showTeam2ScoreCard(matchData);
        scoreBoardData.showFinalResult(matchData);

        MatchBean matchBean = new MatchBean();
        matchBean.setMatchId(matchData.getMatchId());
        matchBean.setTossWinner(matchData.getTossWinner());
        matchBean.setNumberOfOvers(matchData.getNumberOfOvers());
        matchBean.setMatchWinner(matchData.getMatchWinner());
        matchBean.setCreatedTime(System.currentTimeMillis());
        matchBean.setModifiedTime(System.currentTimeMillis());
        matchBean.setDeleted(false);
        return matchBean;
    }

    public void performInningSchedule(int winnerOfToss, MatchDto matchData){
        BattingOrBowlingType winnerChoice;
        if(winnerOfToss==1){
            System.out.println("\n" + "You won the toss, what you choose to elect BATTING or BOWLING");
            Scanner sc = new Scanner(System.in);
            String battingOrBowlingChoice = "BATTING";
            String defaultChoice = "BATTING";
            boolean validateInput = validateBattingOrBowlingType(battingOrBowlingChoice);
            if(!validateInput){
                System.out.println("You Provide inappropriate choice, So by default setting you to BAT first");
                winnerChoice = BattingOrBowlingType.valueOf(defaultChoice);
            }
            else{
                winnerChoice = BattingOrBowlingType.valueOf(battingOrBowlingChoice);
            }
        }
        else {
            int randomChoice = MatchUtils.randomNumberBetweenLtoR(1,2);
            if(randomChoice==1)
                winnerChoice = BattingOrBowlingType.BOWLING;
            else
                winnerChoice = BattingOrBowlingType.BATTING;
            System.out.println("You losses the toss, " + matchData.getTeam2().getTeamName() +
                    " chooses to " + winnerChoice.getWinnerChoice() + " first");
        }

        if( (winnerOfToss==1 && winnerChoice.getWinnerChoice()=="Batting") || (winnerOfToss==0 && winnerChoice.getWinnerChoice()=="Bowling") ) {
            System.out.println("\n" + " First Inning " + "\n" +matchData.getTeam1().getTeamName() + "'s Batting Start");
            playInning(matchData.getTeam1(), 1, matchData);
            System.out.println("\n" + " Second Inning " + "\n" +matchData.getTeam1().getTeamName() + "'s Bowling Start");
            playInning(matchData.getTeam2(), 2, matchData);
        }
        else{
            System.out.println("\n" + " First Inning" + "\n" +matchData.getTeam1().getTeamName() + "'s Bowling Start");
            playInning(matchData.getTeam2(),2 , matchData);
            System.out.println("\n" + " Second Inning" + "\n" +matchData.getTeam1().getTeamName() + "'s Batting Start");
            playInning(matchData.getTeam1(), 1, matchData);
        }
    }

    public int performToss(){
        int winnerOfToss = MatchUtils.randomNumberBetweenLtoR(1,2);
        return winnerOfToss;
    }

    int currentBallStatus(){
        int ballStatus = MatchUtils.randomNumberBetweenLtoR(0,6);
        return ballStatus;
    }

    void playInning(TeamDto battingTeam, int teamId, MatchDto matchData){
        ArrayList <PerBallDto> perBallStatus = new ArrayList<>();
        while (battingTeam.getNumberOfWicketsDown()<11 && battingTeam.getNumberOfBallsPlayed()<6*matchData.getNumberOfOvers()){
            int randomProbability=MatchUtils.randomNumberBetweenLtoR(1,1000);
            int currentBallStatus;

            if(randomProbability <= battingTeam.getIthPlayerProbOfOut(battingTeam.getNumberOfWicketsDown())){
                currentBallStatus=-1;
            }
            else{
                currentBallStatus = currentBallStatus();
            }
            if(battingTeam.getNumberOfBallsPlayed()%6==0 ){
                System.out.println();
                scoreBoardData.showLiveScore(matchData, teamId);
            }
            if(battingTeam.getNumberOfBallsPlayed()==0 || battingTeam.getNumberOfBallsPlayed()%6==0 )
                System.out.println((battingTeam.getNumberOfBallsPlayed()/6+1) + " Over");
            showCurrentBallStatus(currentBallStatus);
            PerBallDto currentStatus = new PerBallDto(currentBallStatus, battingTeam.getNumberOfWicketsDown());
            perBallStatus.add(currentStatus);
            battingTeam = teamService.playCurrentBall(battingTeam, currentBallStatus);

            if(battingTeam.getNumberOfWicketsDown()==11){
                System.out.println();
                scoreBoardData.showLiveScore(matchData, teamId);
            }
        }
        if(teamId==1)
            matchData.getTeam1().setPerBallStatus(perBallStatus);
        else
            matchData.getTeam2().setPerBallStatus(perBallStatus);
    }

    public void showCurrentBallStatus(int currentBallStatus){
        if(currentBallStatus==-1){
            System.out.print("W ");
        }
        else{
            System.out.print(currentBallStatus+ " ");
        }
    }

    @Cacheable(cacheNames = "matchCache")
    public MatchBean getMatchInfo(int matchId){
        System.out.println("Contacting Database");
        return matchRepo.getMatchIdInfo(matchId);
    }

    public boolean validateMatchCreationResponse(MatchCreationResponseDto matchCreationResponse){
        if(matchCreationResponse.getTeam1Name().isEmpty()){
            return false;
        }
        if(matchCreationResponse.getTeam2Name().isEmpty()){
            return false;
        }
        if(matchCreationResponse.getMatchType().isEmpty()){
            return false;
        }
        if(matchCreationResponse.getTossWinnerPreference().isEmpty()){
            return false;
        }
        return true;
    }

    public boolean validateMatchId(int matchId){
        return matchRepo.checkMatchId(matchId);
    }

    public int getNewMatchId(){
        return matchRepo.getNewMatchId();
    }

}

