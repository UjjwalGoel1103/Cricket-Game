package com.company.dto;

import com.company.enums.PlayerType;

public class PlayerDto {
    private String name;
    private int age;
    private int score;
    private int wicketsTaken;
    private int numberOfBallsPlayed;
    PlayerType playerType;

    public PlayerDto(){
        score=0;
        wicketsTaken=0;
        numberOfBallsPlayed=0;
    }

    public void playerScoreZero(){
        this.numberOfBallsPlayed += 1;
    }

    public void playerScoreOne(){
        this.numberOfBallsPlayed += 1;
        this.score += 1;
    }

    public void playerScoreTwo(){
        this.numberOfBallsPlayed += 1;
        this.score += 2;
    }

    public void playerScoreThree(){
        this.numberOfBallsPlayed += 1;
        this.score += 3;
    }

    public void playerScoreFour(){
        this.numberOfBallsPlayed += 1;
        this.score += 4;
    }

    public void playerScoreFive(){
        this.numberOfBallsPlayed += 1;
        this.score += 5;
    }

    public void playerScoreSix(){
        this.numberOfBallsPlayed += 1;
        this.score += 6;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return this.age;
    }

    public void setScore(int score){
        this.score=score;
    }

    public int getScore(){
        return this.score;
    }

    public void setWicketsTaken(int wicketsTaken){
        this.wicketsTaken=wicketsTaken;
    }

    public int getWicketsTaken(){
        return this.wicketsTaken;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed){
        this.numberOfBallsPlayed=numberOfBallsPlayed;
    }

    public int getNumberOfBallsPlayed(){
        return this.numberOfBallsPlayed;
    }

    public void setPlayerType(PlayerType playerType){
        this.playerType=playerType;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }


}