package com.company;

public class ScoreBoard {
    Team team1 = new Team();
    Team team2 = new Team();

    void showFinalResult(){
        System.out.println("Team "+team1.getTeamName()+" Total Score is : ");
        System.out.println(team1.getTotalScore());
        System.out.println("Team "+team1.getTeamName()+" Total Score is : ");
        System.out.println(team2.getTotalScore());
        //System.out.println("Final result");
    }

    void showTeam1ScoreCard(){
        System.out.println("Team "+team1.getTeamName()+" Scoreboard is : ");
        //printing the score card for each player
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            System.out.println("Team "+team1.playersofatema+" Total Score is : ");
        }
    }
}
