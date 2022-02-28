package com.company.services;

import com.company.dto.MatchDto;

public interface ScoreBoardService {
    void showLiveScore(MatchDto thisMatchScoreBoard);
    void showFinalResult(MatchDto thisMatchScoreBoard);
    void showTeam1ScoreCard(MatchDto thisMatchScoreBoard);
    void showTeam2ScoreCard(MatchDto thisMatchScoreBoard);
}
