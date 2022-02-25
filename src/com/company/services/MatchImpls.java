package com.company.services;

import com.company.dto.MatchDto;
import com.company.dto.PerBallDto;
import com.company.enums.BattingOrBowlingType;
import com.company.enums.MatchType;
import com.company.repo.DbConnectionImpls;
import com.company.repo.DbConnectionService;
import com.company.util.MatchUtils;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.validator.InputValidator.validateBattingOrBowlingType;
import static com.company.validator.InputValidator.validateMatchType;

public class MatchImpls implements MatchService {
    MatchDto matchData = new MatchDto();
    ScoreBoardService scoreBoard;
    DbConnectionService connection = new DbConnectionImpls();

    public MatchImpls(String teamName1, String teamName2){
        matchData.setTeam1Name(teamName1);
        matchData.setTeam2Name(teamName2);
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting A New Match");
        System.out.println("Which Format Match you want : FIVE_OVER / T20 / FIFTY_OVER");
        MatchType applyingMatchType;
        String matchTypeByUser = sc.next();
        String defaultMatchType = "FIVE_OVER";
        boolean validateInput = validateMatchType(matchTypeByUser);
        if(!validateInput){
            System.out.println("\n" + "You Provide inappropriate input, So by default making match of 5 Overs" + "\n");
            applyingMatchType = MatchType.valueOf(defaultMatchType);
        }
        else{
            // convert String to enum
            applyingMatchType = MatchType.valueOf(matchTypeByUser);
        }
        matchData.setNumberOfOvers(applyingMatchType.getOverInThisType()) ;

        startMatch();
    }

    //todo age chase krte time ek team ka score jada ho jae to whi break
    public void startMatch(){
        int winnerOfToss = performToss();
        if(winnerOfToss==1){
            matchData.setTossWinner(matchData.getTeam1().getTeamName());
        }
        else{
            matchData.setTossWinner(matchData.getTeam2().getTeamName());
        }
        //Scoreboard With different Functionalities
        scoreBoard = new ScoreBoardImpls(matchData, connection);
        performInningSchedule(winnerOfToss);
        scoreBoard.showTeam1ScoreCard();
        scoreBoard.showTeam2ScoreCard();
        scoreBoard.showFinalResult();
    }

    public void performInningSchedule(int winnerOfToss){
        BattingOrBowlingType winnerChoice;
        if(winnerOfToss==1){
            System.out.println("\n" + "You won the toss, what you choose to elect BATTING or BOWLING");
            Scanner sc = new Scanner(System.in);
            String battingOrBowlingChoice = sc.nextLine();
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
            playInning(matchData.getTeam1(), 1);
            System.out.println("\n" + " Second Inning " + "\n" +matchData.getTeam1().getTeamName() + "'s Bowling Start");
            playInning(matchData.getTeam2(), 2);
        }
        else{
            System.out.println("\n" + " First Inning" + "\n" +matchData.getTeam1().getTeamName() + "'s Bowling Start");
            playInning(matchData.getTeam2(),2 );
            System.out.println("\n" + " Second Inning" + "\n" +matchData.getTeam1().getTeamName() + "'s Batting Start");
            playInning(matchData.getTeam1(), 1);
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

    void playInning(TeamService battingTeamService, int teamId){
        ArrayList <PerBallDto> perBallStatus = new ArrayList<>();
        while (battingTeamService.getNumberOfWicketsDown()<10 && battingTeamService.getNumberOfBallsPlayed()<6*matchData.getNumberOfOvers()){
            int randomProbability=MatchUtils.randomNumberBetweenLtoR(1,10);
            int currentBallStatus;

            if(randomProbability <= battingTeamService.getIthPlayerProbOfOut(battingTeamService.getNumberOfWicketsDown())){
                currentBallStatus=-1;
            }
            else{
                currentBallStatus = currentBallStatus();
            }
            if(battingTeamService.getNumberOfBallsPlayed()%6==0 ){
                System.out.println();
                scoreBoard.showLiveScore();
            }
            if(battingTeamService.getNumberOfBallsPlayed()==0 || battingTeamService.getNumberOfBallsPlayed()%6==0 )
                System.out.println((battingTeamService.getNumberOfBallsPlayed()/6+1) + " Over");
            showCurrentBallStatus(currentBallStatus);
            PerBallDto currentStatus = new PerBallDto(currentBallStatus, battingTeamService.getNumberOfWicketsDown());
            perBallStatus.add(currentStatus);
            battingTeamService.playCurrentBall(currentBallStatus);

            if(battingTeamService.getNumberOfWicketsDown()==10){
                System.out.println();
                scoreBoard.showLiveScore();
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
}

