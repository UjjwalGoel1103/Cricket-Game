package com.company.CricketGame.repo;

import com.company.CricketGame.bean.MatchBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Profile("SqlTypeDB")
@Repository
public class MatchRepoImpl implements MatchRepo {

    @Autowired
    DatabaseRepo dbRepo;

    public MatchRepoImpl(DatabaseRepo dbRepo) {
        this.dbRepo = dbRepo;
    }

    public void matchDetailUpdation(MatchBean matchBean) {
            long timestamp = (System.currentTimeMillis());
            String query= "insert into MatchData (matchId, numberOfOvers, tossWinner, matchWinner, createdTime, modifiedTime, deleted) " +
                    " values ("+matchBean.getMatchId()+", "+matchBean.getNumberOfOvers()+", '"+matchBean.getTossWinner()+"'," +
                    " '"+matchBean.getMatchWinner()+"', '"+timestamp+"', '"+timestamp+"', "+0+" )";
            dbRepo.updateQueryToDb(query);
    }

    public MatchBean getMatchIdInfo(int matchId) {
        MatchBean matchInfo = new MatchBean();
        String query = " select * from matchdata where matchId = "+matchId+" ";
        ResultSet rs= dbRepo.getQueryFromDb(query);
        try {
            rs.next();
            matchInfo.setMatchId(rs.getInt("matchId"));
            matchInfo.setNumberOfOvers(rs.getInt("numberOfOvers"));
            matchInfo.setTossWinner(rs.getString("tossWinner"));
            matchInfo.setMatchWinner(rs.getString("matchWinner"));
            matchInfo.setCreatedTime(rs.getLong("createdTime"));
            matchInfo.setModifiedTime(rs.getLong("modifiedTime"));
            matchInfo.setDeleted(rs.getBoolean("deleted"));
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return matchInfo;
    }

    public boolean checkMatchId(int matchId){
        String query = " select * from matchdata where matchId = "+matchId+" ";
        ResultSet rs= dbRepo.getQueryFromDb(query);
        boolean matchIdExistes=false;
        try {
            while (rs.next())
            {
                matchIdExistes = true;
            }
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return matchIdExistes;
    }

    public int getNewMatchId(){
        ResultSet resultSet;
        int matchId = 0;
        try {
            String query="select * from MatchData ";
            resultSet = dbRepo.getQueryFromDb(query);
            while (resultSet.next())
            {
                matchId = resultSet.getInt("matchId");
            }
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        matchId++;
        return matchId;
    }
}
