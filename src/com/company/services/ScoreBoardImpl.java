package com.company.services;

import com.company.Constants.Constants;
import com.company.dto.MatchDto;
import com.company.dto.TeamDto;
import com.company.repo.DatabaseService;

public class ScoreBoardImpl implements ScoreBoardService {

    DatabaseService connection;

    ScoreBoardImpl( DatabaseService connection){
        this.connection = connection;
    }

    public void showLiveScore(MatchDto thisMatchScoreBoard){
        TeamDto liveTeam;
        if(thisMatchScoreBoard.getTeam1().getNumberOfBallsPlayed()==0){
            liveTeam = thisMatchScoreBoard.getTeam2().getTeamDto();
        }
        else if(thisMatchScoreBoard.getTeam2().getNumberOfBallsPlayed()==0){
            liveTeam = thisMatchScoreBoard.getTeam1().getTeamDto();
        }
        else if(thisMatchScoreBoard.getTeam1().getNumberOfWicketsDown()==10){
            liveTeam = thisMatchScoreBoard.getTeam2().getTeamDto();
        }
        else{
            liveTeam = thisMatchScoreBoard.getTeam1().getTeamDto();
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
        connection.updateBeans(thisMatchScoreBoard);
    }

    public void showTeam1ScoreCard(MatchDto thisMatchScoreBoard){
        System.out.println("Team "+ thisMatchScoreBoard.getTeam1().getTeamName()+" Total Score is : "+ thisMatchScoreBoard.getTeam1().getTotalScore());
        System.out.println("Number of over Played "+ thisMatchScoreBoard.getTeam1().getNumberOfBallsPlayed()/6+"."+ thisMatchScoreBoard.getTeam1().getNumberOfBallsPlayed()%6);
        System.out.println("Number of wickets fallen "+ thisMatchScoreBoard.getTeam1().getNumberOfWicketsDown());
        //printing the score card for each player
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate");
        for(int i = 0; i< Constants.NO_OF_PLAYER; i++){
            if(thisMatchScoreBoard.getTeam1().getIthPlayerBalls(i)!=0) {
                System.out.println(thisMatchScoreBoard.getTeam1().getIthPlayerName(i) + "      " + thisMatchScoreBoard.getTeam1().getIthPlayerScore(i) + "         " +
                        thisMatchScoreBoard.getTeam1().getIthPlayerScore(i) / thisMatchScoreBoard.getTeam1().getIthPlayerBalls(i));
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
        //todo printing the score card for each player
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate");
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            if(thisMatchScoreBoard.getTeam2().getIthPlayerBalls(i)!=0) {
                System.out.println(thisMatchScoreBoard.getTeam2().getIthPlayerName(i) + "      " + thisMatchScoreBoard.getTeam2().getIthPlayerScore(i) + "         " +
                        thisMatchScoreBoard.getTeam2().getIthPlayerScore(i) / thisMatchScoreBoard.getTeam2().getIthPlayerBalls(i));
            }
            else{
                System.out.println(thisMatchScoreBoard.getTeam2().getIthPlayerName(i) + "    -----------------------------  " );
            }
        }
    }

    MatchDto getLatestScoreBoardData(MatchDto thisMatchScoreBoard){
        return thisMatchScoreBoard;
    }
}
