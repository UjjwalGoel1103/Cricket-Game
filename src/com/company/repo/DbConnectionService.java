package com.company.repo;

import com.company.bean.matchBean;
import com.company.bean.perBallBean;
import com.company.bean.playerBean;
import com.company.bean.teamBean;
import com.company.dto.MatchDto;
import com.company.services.ScoreBoardService;

import java.util.ArrayList;

public interface DbConnectionService {
    void updateMatchData(matchBean matchBean);
    void updateTeamData(teamBean teamBean);
    void updatePlayerData(ArrayList<playerBean> playersList);
    void updatePerBallData(ArrayList<perBallBean> perBallStatus);
    void updateBeans (MatchDto scoreBoard);
}
