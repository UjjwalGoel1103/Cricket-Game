package com.company.repo;

import com.company.bean.TeamBean;

import java.sql.Timestamp;

public class TeamDetailsRepoImpl implements TeamDetailsRepoService{

    public void teamDetailUpdation(TeamBean teamBean) {

        long timestamp = (System.currentTimeMillis());
        String query=" insert into TeamMatchData (matchID, teamName, teamId, numberOfPlayer, totalScore, " +
                "numberOfWicketsDown, numberOfBallsPlayed, createdTime, modifiedTime, deleted) values("+ teamBean.getMatchId()+", '"+ teamBean.getTeamName()+"', "+ teamBean.getTeamId()+", "+ teamBean.getNumberOfPlayer()+", " +
                " "+ teamBean.getTotalScore()+", "+ teamBean.getNumberOfWicketsDown()+", "+ teamBean.getNumberOfBallsPlayed()+", '"+timestamp+"', '"+timestamp+"', "+0+")";
        DatabaseService updateToDB = new DatabaseImpl();
        updateToDB.updateQueryToDb(query);

    }

}
