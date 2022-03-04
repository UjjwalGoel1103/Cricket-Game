package com.company.enums;

public enum PlayerType {
    BATSMAN("Batsmen", 30),
    WICKET_KEEPER("Wicket Keeper", 60),
    ALL_ROUNDER("All Rounder", 100),
    BOWLER("Bowler",150);

    private String playerType;
    private int probOfOut;

    PlayerType(String playerType, int probOfOut) {
        this.playerType= playerType;
        this.probOfOut = probOfOut;
    }

    public int getProbOfOut(){
        return this.probOfOut;
    }

    public String getStringPlayerType(){
        return this.playerType;
    }
};
