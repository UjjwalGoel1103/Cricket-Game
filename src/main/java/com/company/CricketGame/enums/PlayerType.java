package com.company.CricketGame.enums;

public enum PlayerType {
    BATSMAN("Batsmen", 50),
    WICKET_KEEPER("Wicket Keeper", 70),
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
