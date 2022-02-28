package com.company.repo;

import com.company.dto.MatchDto;
import com.company.services.UpdateMatchDetails;
import com.company.services.UpdatePerBallDetails;
import com.company.services.UpdatePlayerDetails;
import com.company.services.UpdateTeamDetails;
import com.company.util.DbConnectorUtil;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseImpl implements DatabaseService {

    Connection conn;

    public void updateBeans(MatchDto matchInfo){
        conn = DbConnectorUtil.getConnection();
        insertMatchDetailsInDb(matchInfo);
        insertPlayerDetailsInDb(matchInfo);
        insertTeamDetailsInDb(matchInfo);
        insertPerBallDetailsInDb(matchInfo);
    }

    public void insertMatchDetailsInDb(MatchDto matchInfo){
        UpdateMatchDetails matchDetails = new UpdateMatchDetails();
        matchDetails.matchDetailUpdation(matchInfo);
    }

    public void insertTeamDetailsInDb(MatchDto matchInfo){
        UpdateTeamDetails teamDetails = new UpdateTeamDetails();
        teamDetails.teamDetailUpdation(matchInfo);
    }

    public void insertPlayerDetailsInDb(MatchDto matchInfo){
        UpdatePlayerDetails playerDetails = new UpdatePlayerDetails();
        playerDetails.playerDetailUpdation(matchInfo);
    }


    public void insertPerBallDetailsInDb(MatchDto matchInfo){
        UpdatePerBallDetails perBallDetails = new UpdatePerBallDetails();
        perBallDetails.perBallDetailUpdation(matchInfo);
    }

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
