package com.company.CricketGame.dto;

import com.company.CricketGame.constants.Constants;
import com.company.CricketGame.enums.PlayerType;
import lombok.Data;

import java.util.ArrayList;

@Data
public class TeamDto {

    private String teamName;
    private int numberOfPlayer;
    private int totalScore;
    private int teamId;
    private int numberOfWicketsDown;
    private int numberOfBallsPlayed;
    private ArrayList<PlayerDto> playersOfATeam = new ArrayList<>(Constants.NO_OF_PLAYER);
    private ArrayList<PerBallDto> perBallStatus = new ArrayList<>();

    public TeamDto() {
        this.numberOfPlayer = Constants.NO_OF_PLAYER;
        this.totalScore = 0;
        this.numberOfWicketsDown = 0;
        this.numberOfBallsPlayed = 0;
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

    public int getIthPlayerScore(int playerID){
        return getPlayersOfATeam().get(playerID).getScore();
    }

    public int getIthPlayerBalls(int playerID){
        return getPlayersOfATeam().get(playerID).getNumberOfBallsPlayed();
    }

    public String getIthPlayerType(int playerID){
        return getPlayersOfATeam().get(playerID).getPlayerType().getStringPlayerType();
    }

    public String getIthPlayerName(int playerID){
        return getPlayersOfATeam().get(playerID).getName();
    }

    public int getIthPlayerAge( int playerID){
        return getPlayersOfATeam().get(playerID).getAge();
    }

    public int getIthBallStatus( int ballId) {
        return getPerBallStatus().get(ballId).getBallStatus();
    }

    public int getIthBallPlayerId( int ballId) {
        return getPerBallStatus().get(ballId).getPlayerId();
    }

    public int getIthPlayerProbOfOut( int playerId) {
        return getPlayersOfATeam().get(playerId).getPlayerType().getProbOfOut();
    }



}
