package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PerBallBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.ArrayList;

@Component
public class PerBallDetailsRepoImpl implements PerBallDetailsRepo {

    @Autowired
    DatabaseRepo dbRepo;

    public PerBallDetailsRepoImpl(DatabaseRepo dbRepo) {
        this.dbRepo = dbRepo;
    }

    public void perBallDetailUpdation(ArrayList<PerBallBean> perBallStatus){
        long timestamp = (System.currentTimeMillis());
        for(int i=0;i<perBallStatus.size();i++){
            String query=" insert into PerBallMatchData (matchId, teamId, ballStatus, playerId, createdTime, modifiedTime, deleted) values( "+perBallStatus.get(i).getMatchId()+", " +
                    " "+perBallStatus.get(i).getTeamId()+", "+perBallStatus.get(i).getBallStatus()+", "+perBallStatus.get(i).getPlayerId()+" , '"+timestamp+"', '"+timestamp+"', "+0+" )";
            dbRepo.updateQueryToDb(query);
        }
    }

}
