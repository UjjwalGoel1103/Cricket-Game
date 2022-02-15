package com.company;

import com.company.enums.MatchType;
import com.company.enums.PlayerType;

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

        setPlayersDefaultInfo();
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

    private void setIthPlayerOfATeam(int playerId, String name, int age, PlayerType playerType){
        playersOfATeam.get(playerId).setName(name);
        playersOfATeam.get(playerId).setAge(age);
        playersOfATeam.get(playerId).setPlayerType(playerType);
    }

    String getIthPlayerName(int playerID){
        return playersOfATeam.get(playerID).getName();
    }

    int getIthPlayerAge(int playerID){
        return playersOfATeam.get(playerID).getAge();
    }

    int getIthPlayerScore(int playerID){
        return playersOfATeam.get(playerID).getScore();
    }

    int getIthPlayerBalls(int playerID){
        return playersOfATeam.get(playerID).getNumberOfBallsPlayed();
    }

    void playCurrentBall(int currentBallStatus){
        this.numberOfBallsPlayed+=1;
        if(currentBallStatus==-1){
            this.numberOfWicketsDown+=1;
        }
        else if(currentBallStatus==0){
            playersOfATeam.get(numberOfWicketsDown).playerScoreZero();;
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

    private void setPlayersDefaultInfo(){
        setIthPlayerOfATeam(0,"Sachin Tendulakr ", 25, PlayerType.BATSMAN);
        setIthPlayerOfATeam(1,"Virendar Sehwag  ", 20, PlayerType.BATSMAN);
        setIthPlayerOfATeam(2,"Virat Kohli      ", 22, PlayerType.BATSMAN);
        setIthPlayerOfATeam(3,"Rohit Sharma     ", 30, PlayerType.BATSMAN);
        setIthPlayerOfATeam(4,"MS Dhoni         ", 25, PlayerType.WICKET_KEEPER);
        setIthPlayerOfATeam(5,"Ravindra Jadeja  ", 21, PlayerType.ALL_ROUNDER);
        setIthPlayerOfATeam(6,"Yuvraj Singh     ", 28, PlayerType.ALL_ROUNDER);
        setIthPlayerOfATeam(7,"Harbhajan Singh  ", 29, PlayerType.BOWLER);
        setIthPlayerOfATeam(8,"Jasprit Bumrah   ", 20, PlayerType.BOWLER);
        setIthPlayerOfATeam(9,"Ravindra Ashwin  ", 27, PlayerType.BOWLER);
        setIthPlayerOfATeam(10,"Mohomadd Shami  ", 29, PlayerType.BOWLER);
    }

}