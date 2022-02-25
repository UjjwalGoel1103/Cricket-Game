package com.company.bean;

import com.company.enums.PlayerType;

public class playerBean {
    int playerId;
    int teamId;
    String name;
    int age;
    int score;
    int numberOfBallsPlayed;
    String playerType;
    int matchId;

    public playerBean(int playerId, int teamId, String name, int age, int score, int numberOfBallsPlayed, String playerType) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.name = name;
        this.age = age;
        this.score = score;
        this.numberOfBallsPlayed = numberOfBallsPlayed;
        this.playerType = playerType;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
}
