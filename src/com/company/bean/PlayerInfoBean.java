package com.company.bean;

public class PlayerInfoBean {
    int matchId;
    int teamId;
    int playerId;
    String name;
    int age;
    String playerType;
    long createdTime;
    long modifiedTime;
    boolean deleted;

    public PlayerInfoBean(int matchId, int teamId, int playerId, String name, int age, String playerType) {
        this.matchId = matchId;
        this.teamId = teamId;
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.playerType = playerType;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
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

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
}
