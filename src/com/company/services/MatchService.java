package com.company.services;

import com.company.dto.MatchDto;

public interface MatchService {

    int performToss();
    void startMatch(MatchDto matchData);

    void performInningSchedule(int winnerOFToss, MatchDto matchData);

}
