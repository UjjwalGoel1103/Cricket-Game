package com.company.repo;

import com.company.bean.TeamBean;
import com.company.dto.MatchDto;
import com.company.dto.TeamDto;

import java.sql.Timestamp;

public class TeamDetailsRepoImpl implements TeamDetailsRepoService{

    public void teamDetailUpdation(TeamBean teamBean) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String query=" insert into TeamMatchData (matchID, teamName, teamId, numberOfPlayer, totalScore, " +
                "numberOfWicketsDown, numberOfBallsPlayed, createdTime, modifiedTime) values("+teamBean.getMatchId()+", '"+teamBean.getTeamName()+"', "+teamBean.getTeamId()+", "+teamBean.getNumberOfPlayer()+", " +
                " "+teamBean.getTotalScore()+", "+teamBean.getNumberOfWicketsDown()+", "+teamBean.getNumberOfBallsPlayed()+", '"+timestamp+"', '"+timestamp+"')";
        DatabaseService updateToDB = new DatabaseImpl();
        updateToDB.updateQueryToDb(query);

    }

}
