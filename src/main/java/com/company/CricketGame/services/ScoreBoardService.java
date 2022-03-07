package com.company.CricketGame.services;

import com.company.CricketGame.dto.MatchDto;
import org.springframework.stereotype.Service;

@Service
public interface ScoreBoardService {
    void showLiveScore(MatchDto thisMatchScoreBoard, int teamId);
    void showFinalResult(MatchDto thisMatchScoreBoard);
    void showTeam1ScoreCard(MatchDto thisMatchScoreBoard);
    void showTeam2ScoreCard(MatchDto thisMatchScoreBoard);
}
