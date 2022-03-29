package com.company.CricketGame.repo;

import com.company.CricketGame.bean.TeamBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TeamDetailsRepoImpl implements TeamDetailsRepo {

    @Autowired
    private final DatabaseRepo dbService;

    public TeamDetailsRepoImpl(DatabaseRepo dbService) {
        this.dbService = dbService;
    }

    public void teamDetailUpdation(TeamBean teamBean) {

        long timestamp = (System.currentTimeMillis());
        String query=" insert into TeamMatchData (matchID, teamName, teamId, numberOfPlayer, totalScore, " +
                "numberOfWicketsDown, numberOfBallsPlayed, createdTime, modifiedTime, deleted) values("+ teamBean.getMatchId()+", '"+ teamBean.getTeamName()+"', "+ teamBean.getTeamId()+", "+ teamBean.getNumberOfPlayer()+", " +
                " "+ teamBean.getTotalScore()+", "+ teamBean.getNumberOfWicketsDown()+", "+ teamBean.getNumberOfBallsPlayed()+", '"+timestamp+"', '"+timestamp+"', "+0+")";
        dbService.updateQueryToDb(query);

    }

    public TeamBean getTeamIdDetail(int matchId, int teamId){
        TeamBean teamDetail = new TeamBean();
        String query = " select * from TeamMatchData where (matchId = "+matchId+"  AND teamId = "+teamId+")";
        ResultSet rs= dbService.getQueryFromDb(query);
        try {
            rs.next();
            teamDetail.setMatchId(rs.getInt("matchId"));
            teamDetail.setTeamId(rs.getInt("teamId"));
            teamDetail.setTeamName(rs.getString("teamName"));
            teamDetail.setTotalScore(rs.getInt("totalScore"));
            teamDetail.setNumberOfBallsPlayed(rs.getInt("numberOfBallsPlayed"));
            teamDetail.setNumberOfWicketsDown(rs.getInt("numberOfWicketsDown"));
            teamDetail.setNumberOfPlayer(rs.getInt("numberOfPlayer"));
            teamDetail.setCreatedTime(rs.getLong("createdTime"));
            teamDetail.setModifiedTime(rs.getLong("modifiedTime"));
            teamDetail.setDeleted(rs.getBoolean("deleted"));
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return teamDetail;
    }

    public boolean checkTeamId(int matchId,int teamId){
        boolean validateTeam = false;
        String query = " select * from TeamMatchData where (matchId = "+matchId+"  AND teamId = "+teamId+")";
        ResultSet rs= dbService.getQueryFromDb(query);
        try {
            while (rs.next()){
                validateTeam = true;
            }
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return validateTeam;
    }

}
