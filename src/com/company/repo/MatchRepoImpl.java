package com.company.repo;

import com.company.bean.MatchBean;
import com.company.dto.MatchDto;

import java.math.BigInteger;
import java.sql.*;

public class MatchRepoImpl implements MatchRepoService {

    public void matchDetailUpdation(MatchBean matchBean) {
            long timestamp = (System.currentTimeMillis());
            String query= "insert into MatchData (matchId, numberOfOvers, tossWinner, matchWinner, createdTime, modifiedTime, deleted) " +
                    " values ("+matchBean.getMatchId()+", "+matchBean.getNumberOfOvers()+", '"+matchBean.getTossWinner()+"'," +
                    " '"+matchBean.getMatchWinner()+"', '"+timestamp+"', '"+timestamp+"', "+0+" )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
    }

}
