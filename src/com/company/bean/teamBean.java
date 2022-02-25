package com.company.bean;

import com.company.Constants.Constants;
import com.company.dto.PerBallDto;
import com.company.dto.PlayerDto;

import java.util.ArrayList;

public class teamBean {
    int matchId;
    private String teamName;
    private int numberOfPlayer;
    private int totalScore;
    private int numberOfWicketsDown;
    private int numberOfBallsPlayed;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getNumberOfWicketsDown() {
        return numberOfWicketsDown;
    }

    public void setNumberOfWicketsDown(int numberOfWicketsDown) {
        this.numberOfWicketsDown = numberOfWicketsDown;
    }

    public int getNumberOfBallsPlayed() {
        return numberOfBallsPlayed;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed) {
        this.numberOfBallsPlayed = numberOfBallsPlayed;
    }
}