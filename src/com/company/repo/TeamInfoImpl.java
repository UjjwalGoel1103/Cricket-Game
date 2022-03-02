package com.company.repo;

import com.company.bean.TeamBean;

import java.sql.Timestamp;

public class TeamInfoImpl implements TeamInfoService {
    public void teamDetailUpdation(TeamBean teamBean) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String query=" insert into TeamMatchData (matchID, teamName, teamId, numberOfPlayer " +
                ", createdTime, modifiedTime) values("+teamBean.getMatchId()+", '"+teamBean.getTeamName()+"', "+teamBean.getTeamId()+", "+teamBean.getNumberOfPlayer()+", " +
                " "+teamBean.getTotalScore()+", , '"+timestamp+"', '"+timestamp+"')";
        DatabaseService updateToDB = new DatabaseImpl();
        updateToDB.updateQueryToDb(query);

    }
}
