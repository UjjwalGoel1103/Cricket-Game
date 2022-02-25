package com.company.repo;

import com.company.Constants.Constants;
import com.company.bean.matchBean;
import com.company.bean.perBallBean;
import com.company.bean.playerBean;
import com.company.bean.teamBean;
import com.company.dto.MatchDto;
import com.company.services.ScoreBoardImpls;
import com.company.services.ScoreBoardService;
import com.company.util.DbConnectorUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbConnectionImpls implements DbConnectionService {

    Connection conn;
    MatchDto scoreBoard;
    matchBean matchBean;
    private static PreparedStatement preparedStatement ;

    public void updateBeans(MatchDto scoreBoard){
        this.scoreBoard = scoreBoard;
        conn = DbConnectorUtil.getConnection();
        prepareMatchBean();
        preparePerBallBean();
        preparePlayerBean();
        prepareTeamBean();
    }

    public void prepareMatchBean(){
        matchBean = new matchBean();
        ResultSet resultSet;
        try {
            String query="select * from matchData ";
            preparedStatement=conn.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();
            int id = 0;
            while (resultSet.next())
            {
                id = resultSet.getInt("matchId");
            }
            matchBean.setMatchId(id+1);
            matchBean.setNumberOfOvers(scoreBoard.getNumberOfOvers());
            matchBean.setTossWinner(scoreBoard.getTossWinner());
            matchBean.setMatchWinner(scoreBoard.getMatchWinner());
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }

        updateMatchData(matchBean);
    }

    public void updateMatchData(matchBean matchBean) {
        try{
            String query= "insert into matchData (matchId, numberOfOvers, tossWinner, matchWinner) " +
                    " values ("+matchBean.getMatchId()+", "+matchBean.getNumberOfOvers()+", '"+matchBean.getTossWinner()+"'," +
                    " '"+matchBean.getMatchWinner()+"' )";
            preparedStatement=conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }

    public void prepareTeamBean(){
        int matchId = matchBean.getMatchId();
        teamBean teamBean1 = new teamBean();
        teamBean teamBean2 = new teamBean();

        teamBean1.setMatchId(matchId);
        teamBean1.setTeamName(scoreBoard.getTeam1().getTeamName());
        teamBean1.setNumberOfPlayer(scoreBoard.getTeam1().getNumberOfPlayer());
        teamBean1.setTotalScore(scoreBoard.getTeam1().getTotalScore());
        teamBean1.setNumberOfWicketsDown(scoreBoard.getTeam1().getNumberOfWicketsDown());
        teamBean1.setNumberOfBallsPlayed(scoreBoard.getTeam1().getNumberOfBallsPlayed());
        teamBean1.setTeamId(1);

        teamBean2.setMatchId(matchId);
        teamBean2.setTeamName(scoreBoard.getTeam2().getTeamName());
        teamBean2.setNumberOfPlayer(scoreBoard.getTeam2().getNumberOfPlayer());
        teamBean2.setTotalScore(scoreBoard.getTeam2().getTotalScore());
        teamBean2.setNumberOfWicketsDown(scoreBoard.getTeam2().getNumberOfWicketsDown());
        teamBean2.setNumberOfBallsPlayed(scoreBoard.getTeam2().getNumberOfBallsPlayed());
        teamBean2.setTeamId(2);

        updateTeamData(teamBean1);
        updateTeamData(teamBean2);
    }

    public void updateTeamData(teamBean teamBean) {
        try{
            String query=" insert into teamData (matchID, teamName, teamId, numberOfPlayer, totalScore, " +
                    "numberOfWicketsDown, numberOfBallsPlayed) values("+teamBean.getMatchId()+", '"+teamBean.getTeamName()+"', "+teamBean.getTeamId()+", "+teamBean.getNumberOfPlayer()+", " +
                    " "+teamBean.getTotalScore()+", "+teamBean.getNumberOfWicketsDown()+", "+teamBean.getNumberOfBallsPlayed()+")";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }

    public void preparePlayerBean(){
        ArrayList <playerBean> playersList = new ArrayList<>(2 * Constants.NO_OF_PLAYER);
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            playerBean newPlayer = new playerBean(i, 1, scoreBoard.getTeam1().getIthPlayerName(i), scoreBoard.getTeam1().getIthPlayerAge(i),
                    scoreBoard.getTeam1().getIthPlayerScore(i), scoreBoard.getTeam1().getIthPlayerBalls(i), scoreBoard.getTeam1().getIthPlayerType(i));
            playersList.add(newPlayer);
        }
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            playerBean newPlayer = new playerBean(i, 2, scoreBoard.getTeam2().getIthPlayerName(i), scoreBoard.getTeam2().getIthPlayerAge(i),
                    scoreBoard.getTeam2().getIthPlayerScore(i), scoreBoard.getTeam2().getIthPlayerBalls(i), scoreBoard.getTeam2().getIthPlayerType(i));
            playersList.add(newPlayer);
        }
        updatePlayerData(playersList);
    }

    public void updatePlayerData(ArrayList<playerBean> playersList){
        try{
            for(int i=0;i<2*Constants.NO_OF_PLAYER;i++){
                String query=" insert into playerData (playerId, teamId, name, age, score, numberOfBallsPlayed, " +
                        "playerType, matchId) values( "+playersList.get(i).getPlayerId()+", "+playersList.get(i).getTeamId()+", '"+playersList.get(i).getName()+"'," +
                        " "+playersList.get(i).getAge()+", "+playersList.get(i).getScore()+", "+playersList.get(i).getNumberOfBallsPlayed()+", " +
                        " '"+playersList.get(i).getPlayerType()+"', "+matchBean.getMatchId()+" )";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }

    public void preparePerBallBean(){
        ArrayList<perBallBean> perBallStatus = new ArrayList<>();
        for(int i=0; i < scoreBoard.getTeam1().getPerBallStatus().size() ; i++){
            perBallBean currentBallStatus = new perBallBean(matchBean.getMatchId(), 1, scoreBoard.getTeam1().getIthBallStatus(i),
                    scoreBoard.getTeam1().getIthBallPlayerId(i));
            perBallStatus.add(currentBallStatus);
        }
        for(int i=0; i < scoreBoard.getTeam2().getPerBallStatus().size() ; i++){
            perBallBean currentBallStatus = new perBallBean(matchBean.getMatchId(), 2, scoreBoard.getTeam2().getIthBallStatus(i),
                    scoreBoard.getTeam2().getIthBallPlayerId(i));
            perBallStatus.add(currentBallStatus);
        }
        updatePerBallData(perBallStatus);
    }

    public void updatePerBallData(ArrayList<perBallBean> perBallStatus){
        try{
            for(int i=0;i<perBallStatus.size();i++){
                String query=" insert into perBallData (matchId, teamId, ballStatus, playerId) values( "+perBallStatus.get(i).getMatchId()+", " +
                        " "+perBallStatus.get(i).getTeamId()+", "+perBallStatus.get(i).getBallStatus()+", "+perBallStatus.get(i).getPlayerId()+" )";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.executeUpdate();
            }
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
    }
}
