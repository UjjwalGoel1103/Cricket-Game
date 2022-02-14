package com.company;

import java.util.ArrayList;

public class Team {

    private String teamName;
    private int numberOfPlayer;
    private int totalScore;
    private int numberOfWicketsDown;
    private int numberOfBallsPlayed;
    private ArrayList<Player> playersOfATeam = new ArrayList<>(Constants.NO_OF_PLAYER);

    Team() {
        numberOfPlayer = Constants.NO_OF_PLAYER;
        totalScore = 0;
        numberOfWicketsDown = 0;
        numberOfBallsPlayed = 0;

        for(int i=0;i<numberOfPlayer;i++){
            Player p = new Player();
            playersOfATeam.add(p);
        }

        //set_player_name();
        //set_player_age();
        //set_player_type();

    }

    void setTeamName(String teamName){
        this.teamName=teamName;
    }

    String getTeamName(){
        return this.teamName;
    }

    void setNumberOfPlayer(int numberOfPlayer){
        this.numberOfPlayer=numberOfPlayer;
    }

    int getNumberOfPlayer(){
        return this.numberOfPlayer;
    }

    void setTotalScore(int totalScore){
        this.totalScore=totalScore;
    }

    int getTotalScore(){
        return this.totalScore;
    }

    void setNumberOfWicketsDown(int numberOfWicketsDown){
        this.numberOfWicketsDown=numberOfWicketsDown;
    }

    int getNumberOfWicketsDown(){
        return this.numberOfWicketsDown;
    }

    void setNumberOfBallsPlayed(int numberOfBallsPlayed){
        this.numberOfBallsPlayed=numberOfBallsPlayed;
    }

    int getNumberOfBallsPlayed(){
        return this.numberOfBallsPlayed;
    }

    void playCurrentBall(int currentBallStatus){
        this.numberOfBallsPlayed+=1;
        if(currentBallStatus==-1){
            this.numberOfWicketsDown+=1;
        }
        else if(currentBallStatus==0){
            return ;
        }
        else if(currentBallStatus==1){
            this.totalScore += 1;
            playersOfATeam.get(numberOfWicketsDown).playerScoreOne();
        }
        else if(currentBallStatus==2){
            this.totalScore += 2;
            playersOfATeam.get(numberOfWicketsDown).playerScoreTwo();
        }
        else if(currentBallStatus==3){
            this.totalScore += 3;
            playersOfATeam.get(numberOfWicketsDown).playerScoreThree();
        }
        else if(currentBallStatus==4){
            this.totalScore += 4;
            playersOfATeam.get(numberOfWicketsDown).playerScoreFour();
        }
        else if(currentBallStatus==5){
            this.totalScore += 5;
            playersOfATeam.get(numberOfWicketsDown).playerScoreFive();
        }
        else if(currentBallStatus==6){
            this.totalScore += 6;
            playersOfATeam.get(numberOfWicketsDown).playerScoreSix();
        }
    }




   /* void set_player_name(){
        team_players.get(0).setname("Player_1");
        team_players.get(1).setname("Player_2");
        team_players.get(2).setname("Player_3");
        team_players.get(3).setname("Player_4");
        team_players.get(4).setname("Player_5");
        team_players.get(5).setname("Player_6");
        team_players.get(6).setname("Player_7");
        team_players.get(7).setname("Player_8");
        team_players.get(8).setname("Player_9");
        team_players.get(9).setname("Player_10");
        team_players.get(10).setname("Player_11");
    }

    void set_player_age(){
        team_players.get(0).setage(19);
        team_players.get(1).setage(23);
        team_players.get(2).setage(22);
        team_players.get(3).setage(11);
        team_players.get(4).setage(12);
        team_players.get(5).setage(12);
        team_players.get(6).setage(16);
        team_players.get(7).setage(26);
        team_players.get(8).setage(29);
        team_players.get(9).setage(12);
        team_players.get(10).setage(19);
    }

    void set_player_type(){
        team_players.get(0).settype("Batsmen");
        team_players.get(1).settype("Batsmen");
        team_players.get(2).settype("Batsmen");
        team_players.get(3).settype("Batsmen");
        team_players.get(4).settype("All-rounder");
        team_players.get(5).settype("All-rounder");
        team_players.get(6).settype("All-rounder");
        team_players.get(7).settype("Bolwer");
        team_players.get(8).settype("Bowler");
        team_players.get(9).settype("Bowler");
        team_players.get(10).settype("Bowler");
    }*/
}