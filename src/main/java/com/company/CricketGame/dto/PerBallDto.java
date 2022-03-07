package com.company.CricketGame.dto;

import lombok.Data;

@Data
public class PerBallDto {
    private int ballStatus;
    private int playerId;

    public PerBallDto(int ballStatus, int playerId) {
        this.ballStatus = ballStatus;
        this.playerId = playerId;
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
