package com.company.bean;

import java.sql.Timestamp;

public class PerBallBean {
    int matchId;
    int teamId;
    private int ballStatus;
    private int playerId;
    Timestamp createdTime;
    Timestamp modifiedTime;

    public PerBallBean(int matchId, int teamId, int ballStatus, int playerId) {
        this.matchId = matchId;
        this.teamId = teamId;
        this.ballStatus = ballStatus;
        this.playerId = playerId;
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

    public int getBallStatus() {
        return ballStatus;
    }

    public void setBallStatus(int ballStatus) {
        this.ballStatus = ballStatus;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
