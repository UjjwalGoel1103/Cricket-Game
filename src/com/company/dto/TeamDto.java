package com.company.dto;

import com.company.Constants.Constants;

import java.util.ArrayList;

public class TeamDto {

    private String teamName;
    private int numberOfPlayer;

    public TeamDto(String teamName, int numberOfPlayer, int totalScore, int numberOfWicketsDown, int numberOfBallsPlayed,
                   ArrayList<PlayerDto> playersOfATeam, ArrayList<PerBallDto> perBallStatus) {
        this.teamName = teamName;
        this.numberOfPlayer = numberOfPlayer;
        this.totalScore = totalScore;
        this.numberOfWicketsDown = numberOfWicketsDown;
        this.numberOfBallsPlayed = numberOfBallsPlayed;
        this.playersOfATeam = playersOfATeam;
        this.perBallStatus = perBallStatus;
    }

    private int totalScore;
    private int numberOfWicketsDown;
    private int numberOfBallsPlayed;
    private ArrayList<PlayerDto> playersOfATeam = new ArrayList<>(Constants.NO_OF_PLAYER);
    private ArrayList<PerBallDto> perBallStatus = new ArrayList<>();

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

    public ArrayList<PlayerDto> getPlayersOfATeam() {
        return playersOfATeam;
    }

    public void setPlayersOfATeam(ArrayList<PlayerDto> playersOfATeam) {
        this.playersOfATeam = playersOfATeam;
    }

    public ArrayList<PerBallDto> getPerBallStatus() {
        return perBallStatus;
    }

    public void setPerBallStatus(ArrayList<PerBallDto> perBallStatus) {
        this.perBallStatus = perBallStatus;
    }
}
