package com.company.CricketGame.services;

import com.company.CricketGame.bean.MatchBean;
import com.company.CricketGame.dto.MatchCreationResponseDto;
import com.company.CricketGame.dto.MatchDto;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

@Service
public interface MatchService {

    int performToss();

    MatchBean startMatch(MatchCreationResponseDto matchCreationResponse);

    void performInningSchedule(int winnerOFToss, MatchDto matchData);

    MatchBean getMatchInfo(int matchId);
    boolean validateMatchCreationResponse(MatchCreationResponseDto matchCreationResponse);
    boolean validateMatchId(int matchId);
    int getNewMatchId();

}
