package com.company.services;

import com.company.bean.PerBallBean;
import com.company.dto.MatchDto;
import com.company.dto.PerBallDto;
import com.company.repo.DatabaseImpl;
import com.company.repo.DatabaseService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UpdatePerBallDetails {

    public void perBallDetailUpdation(MatchDto matchInfo){
        ArrayList<PerBallBean> perBallStatus = preparePerBallBean( matchInfo);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        for(int i=0;i<perBallStatus.size();i++){
            String query=" insert into perBallData (matchId, teamId, ballStatus, playerId, createdTime, modifiedTime) values( "+perBallStatus.get(i).getMatchId()+", " +
                    " "+perBallStatus.get(i).getTeamId()+", "+perBallStatus.get(i).getBallStatus()+", "+perBallStatus.get(i).getPlayerId()+" , '"+timestamp+"', '"+timestamp+"' )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
        }

    }

    public ArrayList<PerBallBean> preparePerBallBean(MatchDto matchInfo){
        ArrayList<PerBallBean> perBallStatus = new ArrayList<>();
        for(int i=0; i < matchInfo.getTeam1().getPerBallStatus().size() ; i++){
            PerBallBean currentBallStatus = new PerBallBean(matchInfo.getMatchId(), 1, matchInfo.getTeam1().getIthBallStatus(i),
                    matchInfo.getTeam1().getIthBallPlayerId(i));
            perBallStatus.add(currentBallStatus);
        }
        for(int i=0; i < matchInfo.getTeam2().getPerBallStatus().size() ; i++){
            PerBallBean currentBallStatus = new PerBallBean(matchInfo.getMatchId(), 2, matchInfo.getTeam2().getIthBallStatus(i),
                    matchInfo.getTeam2().getIthBallPlayerId(i));
            perBallStatus.add(currentBallStatus);
        }
        return perBallStatus;
    }

}
