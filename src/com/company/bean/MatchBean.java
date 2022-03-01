package com.company.bean;

import java.sql.Timestamp;

public class MatchBean {
    int matchId;
    int numberOfOvers;
    String tossWinner;
    String matchWinner;
    long createdTime;
    long modifiedTime;
    long deletionTime;


    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getNumberOfOvers() {
        return numberOfOvers;
    }

    public void setNumberOfOvers(int numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
    }

    public String getTossWinner() {
        return tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

}
