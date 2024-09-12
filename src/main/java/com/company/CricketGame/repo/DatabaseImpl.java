package com.company.CricketGame.repo;

import com.company.CricketGame.dto.MatchDto;
import com.company.CricketGame.util.DbConnectorUtil;

import java.sql.*;

public class DatabaseImpl implements DatabaseService {

    Connection conn;

    public ResultSet getQueryFromDb(String query){
        conn = DbConnectorUtil.getConnection();
        PreparedStatement preparedStatement ;
        try {
            preparedStatement=conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return null;
    }

    public void updateQueryToDb(String query){
        PreparedStatement preparedStatement ;
        conn = DbConnectorUtil.getConnection();
        try {
            preparedStatement=conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }
}
