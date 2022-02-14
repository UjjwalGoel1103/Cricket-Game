package com.company;

public class Player {
    private String name;
    private int age;
    private int score;
    private int wicketsTaken;
    private int numberOfBallsPlayed;

    Player(){
        score=0;
        wicketsTaken=0;
        numberOfBallsPlayed=0;
    }

    void setname(String name){
        this.name=name;
    }

    void setAge(int age){
        this.age=age;
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

    void settype(String type){
      //  this.type=type;
    }

    void setscore(int score){
        this.score=score;
    }

    void setwickets_taken(int wickets_taken){
        this.wicketsTaken=wickets_taken;
    }

    void setNumber_of_balls_played(int numberOfBallsPlayed){
        this.numberOfBallsPlayed=numberOfBallsPlayed;
    }

    String getname(){
        return this.name;
    }

    int getAge(){
        return this.age;
    }

    String gettype(){
   //     return this.type;
        return "test";
    }

    int getScore(){
        return this.score;
    }

    int getWicketsTaken(){
        return this.wicketsTaken;
    }

    int getNumberOfBallsPlayed(){
        return this.numberOfBallsPlayed;
    }



}