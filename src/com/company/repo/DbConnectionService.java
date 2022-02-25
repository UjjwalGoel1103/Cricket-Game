package com.company.repo;

import com.company.dto.MatchDto;
import com.company.services.ScoreBoardService;

public interface DbConnectionService {
    void updateMatchData(int matchID, int numberOfOvers, String tossWinner, String matchWinner);
    void updateTeamData(int matchID, String teamName, int numberOfPlayer, int totalScore,
                        int numberOfWicketsDown, int numberOfBallsPlayed);
    void updatePlayerData(int playerId, int teamId, String name, int age, int score, int numberOfBallsPlayed,
                          int playerType);
    void updatePerBallData(int matchId, int teamId, int ballStatus, int playerId);
    void updateBeans (MatchDto scoreBoard);
}
