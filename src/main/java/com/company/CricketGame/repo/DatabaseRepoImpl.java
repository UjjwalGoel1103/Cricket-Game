package com.company.CricketGame.repo;

import com.company.CricketGame.util.DbConnectorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DatabaseRepoImpl implements DatabaseRepo {

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
        conn = DbConnectorUtil.getConnection();
        PreparedStatement preparedStatement ;
        try {
            preparedStatement=conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }
}
