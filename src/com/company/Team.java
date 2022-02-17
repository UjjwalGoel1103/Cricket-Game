package com.company;

import com.company.Constants.Constants;
import com.company.dto.PlayerDto;
import com.company.dto.TeamDto;
import com.company.enums.PlayerType;

import java.util.ArrayList;

public class Team {

    TeamDto mTeamDto;

    public Team() {
        mTeamDto = new TeamDto(Constants.NO_OF_PLAYER, new ArrayList<>(), );
        mTeamDto.numberOfPlayer = Constants.NO_OF_PLAYER;
        totalScore = 0;
        numberOfWicketsDown = 0;
        numberOfBallsPlayed = 0;

        for(int i=0;i<numberOfPlayer;i++){
            PlayerDto p = new PlayerDto();
            playersOfATeam.add(p);
        }

        setPlayersDefaultInfo();
    }

    public ArrayList getPlayersOfATeam(){
        return this.playersOfATeam;
    }

    public int getIthPlayerProbOfOut(int playerId) {
        return playersOfATeam.get(playerId).getPlayerType().getProbOfOut();
    }

    public void setTeamName(String teamName){
        this.teamName=teamName;
    }

    public String getTeamName(){
        return this.teamName;
    }

    public void setNumberOfPlayer(int numberOfPlayer){
        this.numberOfPlayer=numberOfPlayer;
    }

    public int getNumberOfPlayer(){
        return this.numberOfPlayer;
    }

    public void setTotalScore(int totalScore){
        this.totalScore=totalScore;
    }

    public int getTotalScore(){
        return this.totalScore;
    }

    public void setNumberOfWicketsDown(int numberOfWicketsDown){
        this.numberOfWicketsDown=numberOfWicketsDown;
    }

    public int getNumberOfWicketsDown(){
        return this.numberOfWicketsDown;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed){
        this.numberOfBallsPlayed=numberOfBallsPlayed;
    }

    public int getNumberOfBallsPlayed(){
        return this.numberOfBallsPlayed;
    }

    private private void setIthPlayerOfATeam(int playerId, String name, int age, PlayerType playerType){
        playersOfATeam.get(playerId).setName(name);
        playersOfATeam.get(playerId).setAge(age);
        playersOfATeam.get(playerId).setPlayerType(playerType);
    }

    public String getIthPlayerName(int playerID){
        return playersOfATeam.get(playerID).getName();
    }

    public int getIthPlayerAge(int playerID){
        return playersOfATeam.get(playerID).getAge();
    }

    public int getIthPlayerScore(int playerID){
        return playersOfATeam.get(playerID).getScore();
    }

    public int getIthPlayerBalls(int playerID){
        return playersOfATeam.get(playerID).getNumberOfBallsPlayed();
    }

    public void playCurrentBall(int currentBallStatus){
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