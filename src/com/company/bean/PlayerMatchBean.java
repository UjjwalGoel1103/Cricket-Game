package com.company.bean;

public class PlayerMatchBean {
    int playerId;
    int teamId;
    int score;
    int numberOfBallsPlayed;
    int matchId;
    long createdTime;
    long modifiedTime;
    boolean deleted;

    public PlayerMatchBean(int playerId, int teamId, int score, int numberOfBallsPlayed) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.score = score;
        this.numberOfBallsPlayed = numberOfBallsPlayed;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfBallsPlayed() {
        return numberOfBallsPlayed;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed) {
        this.numberOfBallsPlayed = numberOfBallsPlayed;
    }

}
