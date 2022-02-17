package com.company.services;

import com.company.dto.MatchDto;

public interface ScoreBoardService {
    void updateScoreBoard(MatchDto matchData);
    void showLiveScore();
    void showFinalResult();
    void showTeam1ScoreCard();
    void showTeam2ScoreCard();
}
