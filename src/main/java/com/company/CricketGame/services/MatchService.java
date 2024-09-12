package com.company.CricketGame.services;

import com.company.CricketGame.dto.MatchDto;

public interface MatchService {

    int performToss();
    void startMatch(MatchDto matchData);

    void performInningSchedule(int winnerOFToss, MatchDto matchData);

}
