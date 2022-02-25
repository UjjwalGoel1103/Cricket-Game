package com.company.enums;

public enum MatchType {
    FIVE_OVER(5),
    T20(20),
    FIFTY_OVER(50);

    //todo add more enums
    private final int numberOfOver;
    MatchType(int i) {
        numberOfOver = i;
    }

    public int getOverInThisType(){
        return numberOfOver;
    }
}
