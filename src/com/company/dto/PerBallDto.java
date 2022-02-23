package com.company.dto;

public class PerBallDto {
    private int ballStatus;
    private int playerId;

    public PerBallDto(int ballStatus, int playerId) {
        this.ballStatus = ballStatus;
        this.playerId = playerId;
    }
}
