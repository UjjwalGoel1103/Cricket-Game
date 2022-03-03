package com.company.repo;

import com.company.bean.PlayerMatchBean;
import com.company.dto.MatchDto;

import java.util.ArrayList;

public interface PlayerDetailsRepoService {

    void playerDetailUpdation(ArrayList<PlayerMatchBean> playersList, MatchDto matchInfo);
}
