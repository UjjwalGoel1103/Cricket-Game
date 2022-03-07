package com.company.CricketGame.repo;

import com.company.CricketGame.bean.TeamBean;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDetailsRepo {

    void teamDetailUpdation(TeamBean teamBean);
    TeamBean getTeamIdDetail(int matchId, int teamId);
    boolean checkTeamId(int matchId,int teamId);
}
