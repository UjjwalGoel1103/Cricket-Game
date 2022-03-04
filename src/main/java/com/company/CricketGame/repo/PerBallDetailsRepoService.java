package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PerBallBean;
import com.company.CricketGame.dto.MatchDto;

import java.util.ArrayList;

public interface PerBallDetailsRepoService {

    void perBallDetailUpdation(ArrayList<PerBallBean> perBallStatus) ;
}
