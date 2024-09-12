package com.company.repo;

import com.company.bean.PerBallBean;
import com.company.dto.MatchDto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PerBallDetailsRepoImpl implements PerBallDetailsRepoService {

    public void perBallDetailUpdation(ArrayList<PerBallBean> perBallStatus){
        long timestamp = (System.currentTimeMillis());
        for(int i=0;i<perBallStatus.size();i++){
            String query=" insert into PerBallMatchData (matchId, teamId, ballStatus, playerId, createdTime, modifiedTime, deleted) values( "+perBallStatus.get(i).getMatchId()+", " +
                    " "+perBallStatus.get(i).getTeamId()+", "+perBallStatus.get(i).getBallStatus()+", "+perBallStatus.get(i).getPlayerId()+" , '"+timestamp+"', '"+timestamp+"', "+0+" )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
        }

    }

}
