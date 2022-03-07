package com.company.CricketGame.repo;

import com.company.CricketGame.bean.MatchBean;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo {

    void matchDetailUpdation(MatchBean matchBean) ;
    MatchBean getMatchIdInfo(int matchId) ;
    boolean checkMatchId(int matchId) ;
    int getNewMatchId();
}
