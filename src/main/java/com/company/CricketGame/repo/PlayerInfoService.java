package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.bean.TeamBean;
import com.company.CricketGame.dto.MatchDto;

import java.util.ArrayList;

public interface PlayerInfoService {
    void playerInfoUpdation(ArrayList<PlayerInfoBean> playerInfoList, MatchDto matchInfo);
}
