package com.company.repo;

import com.company.bean.PlayerBean;
import com.company.dto.MatchDto;

import java.util.ArrayList;

public interface PlayerDetailsRepoService {

    void playerDetailUpdation(ArrayList<PlayerBean> playersList, MatchDto matchInfo);
}
