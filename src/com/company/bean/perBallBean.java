package com.company.bean;

public class perBallBean {
    int matchId;
    int teamId;
    private int ballStatus;
    private int playerId;

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
