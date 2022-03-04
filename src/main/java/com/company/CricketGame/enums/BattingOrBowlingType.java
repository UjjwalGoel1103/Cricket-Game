package com.company.CricketGame.enums;

public enum BattingOrBowlingType {
    BATTING ("Batting"),
    BOWLING ("Bowling");

    String winnerChoice;
    BattingOrBowlingType(String userChoice) {
        winnerChoice = userChoice;
    }

    public String getWinnerChoice(){
        return winnerChoice;
    }
}
