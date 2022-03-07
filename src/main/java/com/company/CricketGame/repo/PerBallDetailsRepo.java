package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PerBallBean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Repository
public interface PerBallDetailsRepo {

    void perBallDetailUpdation(ArrayList<PerBallBean> perBallStatus) ;
}
