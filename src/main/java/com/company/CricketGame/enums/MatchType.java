package com.company.CricketGame.enums;

public enum MatchType {
    FIVE_OVER(5),
    T20(20),
    FIFTY_OVER(50);

    private final int numberOfOver;
    MatchType(int i) {
        numberOfOver = i;
    }

    public int getOverInThisType(){
        return numberOfOver;
    }
}
