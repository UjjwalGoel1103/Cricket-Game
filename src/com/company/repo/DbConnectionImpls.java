package com.company.repo;

import com.company.bean.matchBean;
import com.company.dto.MatchDto;
import com.company.services.ScoreBoardImpls;
import com.company.services.ScoreBoardService;
import com.company.util.DbConnectorUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnectionImpls implements DbConnectionService {

    Connection conn;
    MatchDto scoreBoard;
    private static PreparedStatement preparedStatement ;

    public void updateBeans(MatchDto scoreBoard){
        this.scoreBoard = scoreBoard;
        prepareMatchBean();
        preparePerBallBean();
        preparePlayerBean();
        prepareTeamBean();
    }

    public void prepareMatchBean(){
        matchBean matchBean;
        String query="select match_won_team1,match_won_team2 from series_data where series_id="+seriesId;
        preparedStatement=cn.prepareStatement(query);
        resultSet=preparedStatement.executeQuery();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            Date dateCreated = rs.getDate("date_created");
            boolean isAdmin = rs.getBoolean("is_admin");
            int numPoints = rs.getInt("num_points");

            // print the results
            System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
        }

        matchBean.setMatchId();
    }

    public void preparePerBallBean(){
        ;
    }

    public void preparePlayerBean(){
        ;
    }

    public void prepareTeamBean(){
        ;
    }

    public void updateMatchData(int matchId, int numberOfOvers, String tossWinner, String matchWinner) {
        try{
            conn = DbConnectorUtil.getConnection();

            String query="select match_won_team1,match_won_team2 from series_data where series_id="+seriesId;
            preparedStatement=cn.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();

            String query= "insert into matchData (matchId, numberOfOvers, tossWinner, matchWinner) " +
                    " values ("+matchId+", "+numberOfOvers+", '"+tossWinner+"', '"+matchWinner+"' )";

            preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }

    public void updateTeamData(int matchID, String teamName, int numberOfPlayer, int totalScore,
                               int numberOfWicketsDown, int numberOfBallsPlayed) {
        try{
            conn = DbConnectorUtil.getConnection();
            String query=" insert into teamData (matchID, teamName, numberOfPlayer, totalScore, " +
                    "numberOfWicketsDown, numberOfBallsPlayed) values()";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }

    public void updatePlayerData(int playerId, int teamId, String name, int age, int score, int numberOfBallsPlayed,
                                 int playerType){
        try{
            conn = DbConnectorUtil.getConnection();
            String query=" insert into playerData (playerId, teamId, name, age, score, numberOfBallsPlayed, " +
                    "playerType) values()";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }

    public void updatePerBallData(int matchId, int teamId, int ballStatus, int playerId){
        try{
            conn = DbConnectorUtil.getConnection();
            String query=" insert into perBallData (matchId, teamId, ballStatus, playerId) values()";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }
}
