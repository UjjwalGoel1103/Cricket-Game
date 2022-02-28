package com.company.services;

import com.company.bean.MatchBean;
import com.company.dto.MatchDto;
import com.company.repo.DatabaseImpl;
import com.company.repo.DatabaseService;

import java.sql.*;

public class UpdateMatchDetails {

    public void matchDetailUpdation(MatchDto matchInfo) {
        MatchBean matchBean = prepareMatchBean( matchInfo);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String query= "insert into matchData (matchId, numberOfOvers, tossWinner, matchWinner, createdTime, modifiedTime) " +
                    " values ("+matchBean.getMatchId()+", "+matchBean.getNumberOfOvers()+", '"+matchBean.getTossWinner()+"'," +
                    " '"+matchBean.getMatchWinner()+"', '"+timestamp+"', '"+timestamp+"' )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
    }
    public MatchBean prepareMatchBean( MatchDto matchInfo){
        MatchBean matchBean = new MatchBean();
        matchBean = new MatchBean();
        ResultSet resultSet;
        try {
            String query="select * from matchData ";
            DatabaseService queryFromDB = new DatabaseImpl();
            resultSet = queryFromDB.getQueryFromDb(query);
            int id = 0;
            while (resultSet.next())
            {
                id = resultSet.getInt("matchId");
            }
            matchInfo.setMatchId(id+1);
            matchBean.setMatchId(id+1);
            matchBean.setNumberOfOvers(matchInfo.getNumberOfOvers());
            matchBean.setTossWinner(matchInfo.getTossWinner());
            matchBean.setMatchWinner(matchInfo.getMatchWinner());
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return matchBean;
    }


}
