package com.company.enums;

public enum PlayerType {
    BATSMAN("Batsmen", 3),
    WICKET_KEEPER("Wicket Keeper", 4),
    ALL_ROUNDER("All Rounder", 5),
    BOWLER("Bowler",6);

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
