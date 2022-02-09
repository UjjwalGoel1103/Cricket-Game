package com.company;

public class Player {
    private String name;
    private int age;
    private String type;
    private int score;
    private int wickets_taken;
    private int number_of_balls_played;
    Player(){
        score=0;
        wickets_taken=0;
        number_of_balls_played=0;
    }

    void setname(String name){
        this.name=name;
    }

    void setage(int age){
        this.age=age;
    }

    void settype(String type){
        this.type=type;
    }

    void setscore(int score){
        this.score=score;
    }

    void setwickets_taken(int wickets_taken){
        this.wickets_taken=wickets_taken;
    }

    void setNumber_of_balls_played(int number_of_balls_played){
        this.number_of_balls_played=number_of_balls_played;
    }

    String getname(){
        return this.name;
    }

    int getage(){
        return this.age;
    }

    String gettype(){
        return this.type;
    }

    int getscore(){
        return this.score;
    }

    int getwickets_taken(){
        return this.wickets_taken;
    }

    int getNumber_of_balls_played(){
        return this.number_of_balls_played;
    }






}
