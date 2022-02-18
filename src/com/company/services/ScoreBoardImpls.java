package com.company.services;

import com.company.Constants.Constants;
import com.company.dto.MatchDto;

public class ScoreBoardImpls implements ScoreBoardService {

    MatchDto scoreBoardData;
    ScoreBoardImpls(MatchDto matchDto){
        this.scoreBoardData=matchDto;
    }

    public void updateScoreBoard(MatchDto matchDto){
        this.scoreBoardData=matchDto;
    }

    public void showLiveScore(){
        //todo first get the current playing team
        System.out.println(scoreBoardData.getTeam1().getTeamName() + "     "+scoreBoardData.getTeam1().getTotalScore() + "-" +
                scoreBoardData.getTeam1().getNumberOfWicketsDown() + "(" + scoreBoardData.getTeam1().getNumberOfBallsPlayed()/6 + "." +
                scoreBoardData.getTeam1().getNumberOfBallsPlayed()%6 + ")");
        System.out.println(scoreBoardData.getTeam2().getTeamName() + "     "+scoreBoardData.getTeam2().getTotalScore() + "-" +
                scoreBoardData.getTeam2().getNumberOfWicketsDown() + "(" + scoreBoardData.getTeam2().getNumberOfBallsPlayed()/6 + "." +
                scoreBoardData.getTeam2().getNumberOfBallsPlayed()%6 + ")");

    }

    public void showFinalResult(){
        System.out.println(scoreBoardData.getTeam1().getTeamName() + "     "+scoreBoardData.getTeam1().getTotalScore() + "-" +
                scoreBoardData.getTeam1().getNumberOfWicketsDown() + "(" + scoreBoardData.getTeam1().getNumberOfBallsPlayed()/6 + "." +
                scoreBoardData.getTeam1().getNumberOfBallsPlayed()%6 + ")");
        System.out.println(scoreBoardData.getTeam2().getTeamName() + "     "+scoreBoardData.getTeam2().getTotalScore() + "-" +
                scoreBoardData.getTeam2().getNumberOfWicketsDown() + "(" + scoreBoardData.getTeam2().getNumberOfBallsPlayed()/6 + "." +
                scoreBoardData.getTeam2().getNumberOfBallsPlayed()%6 + ")");

        if(scoreBoardData.getTeam1().getTotalScore() > scoreBoardData.getTeam2().getTotalScore()){
            System.out.println(scoreBoardData.getTeam1().getTeamName() + " beats " + scoreBoardData.getTeam2().getTeamName() +  " by "
                    + (scoreBoardData.getTeam1().getTotalScore()- scoreBoardData.getTeam2().getTotalScore())
            + " runs.");
        }
        else if(scoreBoardData.getTeam2().getTotalScore() > scoreBoardData.getTeam1().getTotalScore()){
            System.out.println(scoreBoardData.getTeam2().getTeamName() + " beats " + scoreBoardData.getTeam1().getTeamName()
                    +  " by " + (scoreBoardData.getTeam2().getTotalScore()- scoreBoardData.getTeam1().getTotalScore()) + " runs.");
        }
        else {
            System.out.println("Match Draws as both team scores "+ scoreBoardData.getTeam1().getTotalScore());
        }
    }

    public void showTeam1ScoreCard(){
        System.out.println("Team "+ scoreBoardData.getTeam1().getTeamName()+" Total Score is : "+ scoreBoardData.getTeam1().getTotalScore());
        System.out.println("Number of over Played "+ scoreBoardData.getTeam1().getNumberOfBallsPlayed()/6+"."+ scoreBoardData.getTeam1().getNumberOfBallsPlayed()%6);
        System.out.println("Number of wickets fallen "+ scoreBoardData.getTeam1().getNumberOfWicketsDown());
        //printing the score card for each player
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate"+ scoreBoardData.getTeam1().getNumberOfWicketsDown());
        for(int i = 0; i< Constants.NO_OF_PLAYER; i++){
            if(scoreBoardData.getTeam1().getIthPlayerBalls(i)!=0) {
                System.out.println(scoreBoardData.getTeam1().getIthPlayerName(i) + "      " + scoreBoardData.getTeam1().getIthPlayerScore(i) + "         " +
                        scoreBoardData.getTeam1().getIthPlayerScore(i) / scoreBoardData.getTeam1().getIthPlayerBalls(i));
            }
            else{
                System.out.println(scoreBoardData.getTeam1().getIthPlayerName(i) + "    -----------------------------  " );
            }
        }
    }

    public void showTeam2ScoreCard(){
        System.out.println("Team "+scoreBoardData.getTeam2().getTeamName()+" Total Score is : "+scoreBoardData.getTeam2().getTotalScore());
        System.out.println("Number of over Played "+scoreBoardData.getTeam2().getNumberOfBallsPlayed()/6+"."+scoreBoardData.getTeam2().getNumberOfBallsPlayed()%6);
        System.out.println("Number of wickets fallen "+scoreBoardData.getTeam2().getNumberOfWicketsDown());
        //todo printing the score card for each player
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate"+ scoreBoardData.getTeam2().getNumberOfWicketsDown());
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            if(scoreBoardData.getTeam2().getIthPlayerBalls(i)!=0) {
                System.out.println(scoreBoardData.getTeam2().getIthPlayerName(i) + "      " + scoreBoardData.getTeam2().getIthPlayerScore(i) + "         " +
                        scoreBoardData.getTeam2().getIthPlayerScore(i) / scoreBoardData.getTeam2().getIthPlayerBalls(i));
            }
            else{
                System.out.println(scoreBoardData.getTeam2().getIthPlayerName(i) + "    -----------------------------  " );
            }
        }
    }
}
