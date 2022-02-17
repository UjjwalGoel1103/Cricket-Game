package com.company.services;

public interface MatchService {

    int performToss();
    void startMatch();
    void performInningSchedule(int winnerOFToss);
}
