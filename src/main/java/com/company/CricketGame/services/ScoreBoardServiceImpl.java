package com.company.CricketGame.services;

import com.company.CricketGame.constants.Constants;
import com.company.CricketGame.repo.DatabaseRepo;
import com.company.CricketGame.bean.*;
import com.company.CricketGame.dto.MatchDto;
import com.company.CricketGame.dto.TeamDto;
import com.company.CricketGame.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class ScoreBoardServiceImpl implements ScoreBoardService {

    @Autowired
    MatchRepo matchDetails ;
    @Autowired
    PlayerDetailsRepo playerDetails;
    @Autowired
    TeamDetailsRepo teamDetails;
    @Autowired
    PerBallDetailsRepo perBallDetails;

    public ScoreBoardServiceImpl(MatchRepo matchDetails, PlayerDetailsRepo playerDetails) {
        this.matchDetails = matchDetails;
        this.playerDetails = playerDetails;
    }

    public void showLiveScore(MatchDto thisMatchScoreBoard, int teamId){
        TeamDto liveTeam;
        if(teamId == 1){
            liveTeam = thisMatchScoreBoard.getTeam1();
        }
        else {
            liveTeam = thisMatchScoreBoard.getTeam2();
        }
        System.out.println(liveTeam.getTeamName() + "   " + liveTeam.getTotalScore() + "-" + liveTeam.getNumberOfWicketsDown() +
                "(" + liveTeam.getNumberOfBallsPlayed()/6 + "." + liveTeam.getNumberOfBallsPlayed()%6 + ")" + "\n");
    }

    public void showFinalResult(MatchDto thisMatchScoreBoard){
        System.out.println(thisMatchScoreBoard.getTeam1().getTeamName() + "     "+thisMatchScoreBoard.getTeam1().getTotalScore() + "-" +
                thisMatchScoreBoard.getTeam1().getNumberOfWicketsDown() + "(" + thisMatchScoreBoard.getTeam1().getNumberOfBallsPlayed()/6 + "." +
                thisMatchScoreBoard.getTeam1().getNumberOfBallsPlayed()%6 + ")");
        System.out.println(thisMatchScoreBoard.getTeam2().getTeamName() + "     "+thisMatchScoreBoard.getTeam2().getTotalScore() + "-" +
                thisMatchScoreBoard.getTeam2().getNumberOfWicketsDown() + "(" + thisMatchScoreBoard.getTeam2().getNumberOfBallsPlayed()/6 + "." +
                thisMatchScoreBoard.getTeam2().getNumberOfBallsPlayed()%6 + ")");

        if(thisMatchScoreBoard.getTeam1().getTotalScore() > thisMatchScoreBoard.getTeam2().getTotalScore()){
            thisMatchScoreBoard.setMatchWinner(thisMatchScoreBoard.getTeam1().getTeamName());
            System.out.println(thisMatchScoreBoard.getTeam1().getTeamName() + " beats " + thisMatchScoreBoard.getTeam2().getTeamName() +  " by "
                    + (thisMatchScoreBoard.getTeam1().getTotalScore()- thisMatchScoreBoard.getTeam2().getTotalScore())
            + " runs.");
        }
        else if(thisMatchScoreBoard.getTeam2().getTotalScore() > thisMatchScoreBoard.getTeam1().getTotalScore()){
            thisMatchScoreBoard.setMatchWinner(thisMatchScoreBoard.getTeam2().getTeamName());
            System.out.println(thisMatchScoreBoard.getTeam2().getTeamName() + " beats " + thisMatchScoreBoard.getTeam1().getTeamName()
                    +  " by " + (thisMatchScoreBoard.getTeam2().getTotalScore()- thisMatchScoreBoard.getTeam1().getTotalScore()) + " runs.");
        }
        else {
            System.out.println("Match Draws as both team scores "+ thisMatchScoreBoard.getTeam1().getTotalScore());
        }
        updateBeans(thisMatchScoreBoard);
    }

    public void showTeam1ScoreCard(MatchDto thisMatchScoreBoard){
        System.out.println("Team "+ thisMatchScoreBoard.getTeam1().getTeamName()+" Total Score is : "+ thisMatchScoreBoard.getTeam1().getTotalScore());
        System.out.println("Number of over Played "+ thisMatchScoreBoard.getTeam1().getNumberOfBallsPlayed()/6+"."+ thisMatchScoreBoard.getTeam1().getNumberOfBallsPlayed()%6);
        System.out.println("Number of wickets fallen "+ thisMatchScoreBoard.getTeam1().getNumberOfWicketsDown());
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate");
        for(int i = 0; i< Constants.NO_OF_PLAYER; i++){
            if(thisMatchScoreBoard.getTeam1().getIthPlayerBalls(i)!=0) {
                System.out.println(thisMatchScoreBoard.getTeam1().getIthPlayerName(i) + "       " + thisMatchScoreBoard.getTeam1().getIthPlayerScore(i) + "               " +
                        (double)Math.round( 100.0*thisMatchScoreBoard.getTeam1().getIthPlayerScore(i) / thisMatchScoreBoard.getTeam1().getIthPlayerBalls(i) * 1000d) / 1000d);
            }
            else{
                System.out.println(thisMatchScoreBoard.getTeam1().getIthPlayerName(i) + "    -----------------------------  " );
            }
        }
    }

    public void showTeam2ScoreCard(MatchDto thisMatchScoreBoard){
        System.out.println("Team "+thisMatchScoreBoard.getTeam2().getTeamName()+" Total Score is : "+thisMatchScoreBoard.getTeam2().getTotalScore());
        System.out.println("Number of over Played "+thisMatchScoreBoard.getTeam2().getNumberOfBallsPlayed()/6+"."+thisMatchScoreBoard.getTeam2().getNumberOfBallsPlayed()%6);
        System.out.println("Number of wickets fallen "+thisMatchScoreBoard.getTeam2().getNumberOfWicketsDown());
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate");
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            if(thisMatchScoreBoard.getTeam2().getIthPlayerBalls(i)!=0) {
                System.out.println(thisMatchScoreBoard.getTeam2().getIthPlayerName(i) + "      " + thisMatchScoreBoard.getTeam2().getIthPlayerScore(i) + "                " +
                        (double)Math.round( (100.0*thisMatchScoreBoard.getTeam2().getIthPlayerScore(i) ) / (1.0*thisMatchScoreBoard.getTeam2().getIthPlayerBalls(i) ) * 1000d ) / 1000d);
            }
            else{
                System.out.println(thisMatchScoreBoard.getTeam2().getIthPlayerName(i) + "    -----------------------------  " );
            }
        }
    }

    public void updateBeans(MatchDto matchInfo){
        prepareMatchBean(matchInfo);
        prepareTeamDetailsBean(matchInfo);
        preparePlayerDetailsBean(matchInfo);
        preparePerBallDetailsBean(matchInfo);
        prepareTeamInfoBean(matchInfo);
    }

    public void prepareMatchBean(MatchDto matchInfo){
        MatchBean matchBean = new MatchBean();
            matchBean.setMatchId(matchInfo.getMatchId());
            matchBean.setNumberOfOvers(matchInfo.getNumberOfOvers());
            matchBean.setTossWinner(matchInfo.getTossWinner());
            matchBean.setMatchWinner(matchInfo.getMatchWinner());
        matchDetails.matchDetailUpdation(matchBean);
    }

    public void prepareTeamDetailsBean(MatchDto matchInfo){
        TeamBean teamBean1 = new TeamBean();
        int matchId = matchInfo.getMatchId();
        teamBean1.setMatchId(matchId);
        teamBean1.setTeamName(matchInfo.getTeam1().getTeamName());
        teamBean1.setNumberOfPlayer(matchInfo.getTeam1().getNumberOfPlayer());
        teamBean1.setTotalScore(matchInfo.getTeam1().getTotalScore());
        teamBean1.setNumberOfWicketsDown(matchInfo.getTeam1().getNumberOfWicketsDown());
        teamBean1.setNumberOfBallsPlayed(matchInfo.getTeam1().getNumberOfBallsPlayed());
        teamBean1.setTeamId(1);

        TeamBean teamBean2 = new TeamBean();
        teamBean2.setMatchId(matchId);
        teamBean2.setTeamName(matchInfo.getTeam2().getTeamName());
        teamBean2.setNumberOfPlayer(matchInfo.getTeam2().getNumberOfPlayer());
        teamBean2.setTotalScore(matchInfo.getTeam2().getTotalScore());
        teamBean2.setNumberOfWicketsDown(matchInfo.getTeam2().getNumberOfWicketsDown());
        teamBean2.setNumberOfBallsPlayed(matchInfo.getTeam2().getNumberOfBallsPlayed());
        teamBean2.setTeamId(2);

        teamDetails.teamDetailUpdation(teamBean1);
        teamDetails.teamDetailUpdation(teamBean2);
    }

    public void preparePlayerDetailsBean(MatchDto matchInfo){
        ArrayList<PlayerMatchBean> playerList = new ArrayList<>(2*Constants.NO_OF_PLAYER);
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            PlayerMatchBean newPlayer = new PlayerMatchBean(i, 1, matchInfo.getTeam1().getIthPlayerScore(i), matchInfo.getTeam1().getIthPlayerBalls(i));
            playerList.add(newPlayer);
        }
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            PlayerMatchBean newPlayer = new PlayerMatchBean(i, 2, matchInfo.getTeam2().getIthPlayerScore(i), matchInfo.getTeam2().getIthPlayerBalls(i));
            playerList.add(newPlayer);
        }

        playerDetails.playerDetailUpdation(playerList, matchInfo);
    }


    public void preparePerBallDetailsBean(MatchDto matchInfo){
        ArrayList<PerBallBean> perBallStatus = new ArrayList<>();
        for(int i=0; i < matchInfo.getTeam1().getPerBallStatus().size() ; i++){
            PerBallBean currentBallStatus = new PerBallBean(matchInfo.getMatchId(), 1, matchInfo.getTeam1().getIthBallStatus(i),
                    matchInfo.getTeam1().getIthBallPlayerId(i));
            perBallStatus.add(currentBallStatus);
        }
        for(int i=0; i < matchInfo.getTeam2().getPerBallStatus().size() ; i++){
            PerBallBean currentBallStatus = new PerBallBean(matchInfo.getMatchId(), 2, matchInfo.getTeam2().getIthBallStatus(i),
                    matchInfo.getTeam2().getIthBallPlayerId(i));
            perBallStatus.add(currentBallStatus);
        }
        perBallDetails.perBallDetailUpdation(perBallStatus);
    }

    public void prepareTeamInfoBean(MatchDto matchInfo){

        ArrayList<PlayerInfoBean> playerInfoList = new ArrayList<>(2*Constants.NO_OF_PLAYER);
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            PlayerInfoBean newPlayer = new PlayerInfoBean(matchInfo.getMatchId(), 1, i, matchInfo.getTeam1().getIthPlayerName(i), matchInfo.getTeam1().getIthPlayerAge(i),
                    matchInfo.getTeam1().getIthPlayerType(i));
            playerInfoList.add(newPlayer);
        }
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            PlayerInfoBean newPlayer = new PlayerInfoBean(matchInfo.getMatchId(), 2, i, matchInfo.getTeam2().getIthPlayerName(i), matchInfo.getTeam2().getIthPlayerAge(i),
                    matchInfo.getTeam2().getIthPlayerType(i));
            playerInfoList.add(newPlayer);
        }

        playerDetails.playerInfoUpdation(playerInfoList, matchInfo);

    }

    MatchDto getLatestScoreBoardData(MatchDto thisMatchScoreBoard){
        return thisMatchScoreBoard;
    }
}
