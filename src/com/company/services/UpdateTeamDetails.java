package com.company.services;

import com.company.bean.MatchBean;
import com.company.bean.TeamBean;
import com.company.dto.MatchDto;
import com.company.repo.DatabaseImpl;
import com.company.repo.DatabaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UpdateTeamDetails {

    public void teamDetailUpdation(MatchDto matchInfo) {
        TeamBean teamBean1 = prepareTeamBean1(matchInfo);
        TeamBean teamBean2 = prepareTeamBean2(matchInfo);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String query=" insert into teamData (matchID, teamName, teamId, numberOfPlayer, totalScore, " +
                "numberOfWicketsDown, numberOfBallsPlayed, createdTime, modifiedTime) values("+teamBean1.getMatchId()+", '"+teamBean1.getTeamName()+"', "+teamBean1.getTeamId()+", "+teamBean1.getNumberOfPlayer()+", " +
                " "+teamBean1.getTotalScore()+", "+teamBean1.getNumberOfWicketsDown()+", "+teamBean1.getNumberOfBallsPlayed()+", '"+timestamp+"', '"+timestamp+"')";
        DatabaseService updateToDB = new DatabaseImpl();
        updateToDB.updateQueryToDb(query);

        query=" insert into teamData (matchID, teamName, teamId, numberOfPlayer, totalScore, " +
                "numberOfWicketsDown, numberOfBallsPlayed, createdTime, modifiedTime) values("+teamBean2.getMatchId()+", '"+teamBean2.getTeamName()+"', "+teamBean2.getTeamId()+", "+teamBean2.getNumberOfPlayer()+", " +
                " "+teamBean2.getTotalScore()+", "+teamBean2.getNumberOfWicketsDown()+", "+teamBean2.getNumberOfBallsPlayed()+", '"+timestamp+"', '"+timestamp+"')";
        updateToDB.updateQueryToDb(query);

    }

    public TeamBean prepareTeamBean1(MatchDto matchInfo){
        TeamBean teamBean1 = new TeamBean();
        int matchId = matchInfo.getMatchId();

        teamBean1.setMatchId(matchId);
        teamBean1.setTeamName(matchInfo.getTeam1().getTeamName());
        teamBean1.setNumberOfPlayer(matchInfo.getTeam1().getNumberOfPlayer());
        teamBean1.setTotalScore(matchInfo.getTeam1().getTotalScore());
        teamBean1.setNumberOfWicketsDown(matchInfo.getTeam1().getNumberOfWicketsDown());
        teamBean1.setNumberOfBallsPlayed(matchInfo.getTeam1().getNumberOfBallsPlayed());
        teamBean1.setTeamId(1);

        return teamBean1;
    }

    public TeamBean prepareTeamBean2(MatchDto matchInfo){
        TeamBean teamBean2 = new TeamBean();
        int matchId = matchInfo.getMatchId();

        teamBean2.setMatchId(matchId);
        teamBean2.setTeamName(matchInfo.getTeam2().getTeamName());
        teamBean2.setNumberOfPlayer(matchInfo.getTeam2().getNumberOfPlayer());
        teamBean2.setTotalScore(matchInfo.getTeam2().getTotalScore());
        teamBean2.setNumberOfWicketsDown(matchInfo.getTeam2().getNumberOfWicketsDown());
        teamBean2.setNumberOfBallsPlayed(matchInfo.getTeam2().getNumberOfBallsPlayed());
        teamBean2.setTeamId(2);

        return teamBean2;
    }
}
