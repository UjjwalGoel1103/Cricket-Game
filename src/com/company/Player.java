package com.company;

public class Player {
    private String name;
    private int age;
    private int score;
    private int wicketsTaken;
    private int numberOfBallsPlayed;
    Enum playerType;

    Player(){
        score=0;
        wicketsTaken=0;
        numberOfBallsPlayed=0;
    }

    void playerScoreZero(){
        this.numberOfBallsPlayed += 1;
    }

    void playerScoreOne(){
        this.numberOfBallsPlayed += 1;
        this.score += 1;
    }

    void playerScoreTwo(){
        this.numberOfBallsPlayed += 1;
        this.score += 2;
    }

    void playerScoreThree(){
        this.numberOfBallsPlayed += 1;
        this.score += 3;
    }

    void playerScoreFour(){
        this.numberOfBallsPlayed += 1;
        this.score += 4;
    }

    void playerScoreFive(){
        this.numberOfBallsPlayed += 1;
        this.score += 5;
    }

    void playerScoreSix(){
        this.numberOfBallsPlayed += 1;
        this.score += 6;
    }

    void setName(String name){
        this.name=name;
    }

    String getName(){
        return this.name;
    }

    void setAge(int age){
        this.age=age;
    }

    int getAge(){
        return this.age;
    }

    void setScore(int score){
        this.score=score;
    }

    int getScore(){
        return this.score;
    }

    void setWicketsTaken(int wicketsTaken){
        this.wicketsTaken=wicketsTaken;
    }

    int getWicketsTaken(){
        return this.wicketsTaken;
    }

    void setNumberOfBallsPlayed(int numberOfBallsPlayed){
        this.numberOfBallsPlayed=numberOfBallsPlayed;
    }

    int getNumberOfBallsPlayed(){
        return this.numberOfBallsPlayed;
    }

    void setPlayerType(Enum playerType){
        this.playerType=playerType;
    }

    Enum getPlayerType(){
        return this.playerType;
    }


}