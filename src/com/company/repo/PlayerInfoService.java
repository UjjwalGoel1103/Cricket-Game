package com.company.repo;

import com.company.bean.PlayerInfoBean;
import com.company.bean.TeamBean;
import com.company.dto.MatchDto;

import java.util.ArrayList;

public interface PlayerInfoService {
    void playerInfoUpdation(ArrayList<PlayerInfoBean> playerInfoList, MatchDto matchInfo);
}
