package com.company.CricketGame.bean;

import java.sql.Timestamp;

public class PerBallBean {
    int matchId;
    int teamId;
    private int ballStatus;
    private int playerId;
    long createdTime;
    long modifiedTime;
    boolean deleted;

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

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
