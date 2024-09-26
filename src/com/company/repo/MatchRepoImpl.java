package com.company.repo;

import com.company.bean.MatchBean;
import com.company.dto.MatchDto;

import java.sql.*;

public class MatchRepoImpl implements MatchRepoService {

    public void matchDetailUpdation(MatchBean matchBean) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String query= "insert into MatchData (matchId, numberOfOvers, tossWinner, matchWinner, createdTime, modifiedTime) " +
                    " values ("+matchBean.getMatchId()+", "+matchBean.getNumberOfOvers()+", '"+matchBean.getTossWinner()+"'," +
                    " '"+matchBean.getMatchWinner()+"', '"+timestamp+"', '"+timestamp+"' )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
    }

}
