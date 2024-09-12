package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PlayerMatchBean;
import com.company.CricketGame.dto.MatchDto;

import java.util.ArrayList;

public interface PlayerDetailsRepoService {

    void playerDetailUpdation(ArrayList<PlayerMatchBean> playersList, MatchDto matchInfo);
}
