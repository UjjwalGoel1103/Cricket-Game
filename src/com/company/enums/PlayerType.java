package com.company.enums;

public enum PlayerType {
    BATSMAN("Batsmen", 3),
    WICKET_KEEPER("Wicket Keeper", 4),
    BOWLER("Bowler",7),
    ALL_ROUNDER("All Rounder", 6);

    private String playerType;
    private int probOfOut;

    PlayerType(String playerType, int probOfOut) {
        this.playerType= playerType;
        this.probOfOut = probOfOut;
    }

    public int getProbOfOut(){
        return this.probOfOut;
    }
};
