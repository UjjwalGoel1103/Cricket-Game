package com.company.enums;

public enum PlayerType {
    BATSMAN("Batsmen", 5),
    WICKET_KEEPER("Wicket Keeper", 4),
    BOWLER("Bowler",2),
    ALL_ROUNDER("All Rounder", 3);

    private String playerType;
    private int probOfOut;
    private PlayerType(String playerType, int probOfOut) {
        this.playerType=playerType;
        this.probOfOut = probOfOut;
    }
};
