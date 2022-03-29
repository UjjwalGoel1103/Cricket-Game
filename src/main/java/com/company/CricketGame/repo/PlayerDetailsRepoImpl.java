package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.constants.Constants;
import com.company.CricketGame.bean.PlayerMatchBean;
import com.company.CricketGame.dto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
public class PlayerDetailsRepoImpl implements PlayerDetailsRepo {

    @Autowired
    DatabaseRepo dbService;

    public PlayerDetailsRepoImpl(DatabaseRepo dbService) {
        this.dbService = dbService;
    }

    public void playerDetailUpdation(ArrayList<PlayerMatchBean> playersList, MatchDto matchInfo){
        long timestamp = (System.currentTimeMillis());
        for(int i=0;i<2*Constants.NO_OF_PLAYER;i++){
            String query=" insert into PlayerMatchData (playerId, teamId, score, numberOfBallsPlayed, " +
                    " matchId, createdTime, modifiedTime, deleted) values( "+playersList.get(i).getPlayerId()+", "+playersList.get(i).getTeamId()+"," +
                    "  "+playersList.get(i).getScore()+", "+playersList.get(i).getNumberOfBallsPlayed()+", " +
                    "  "+ matchInfo.getMatchId()+" , '"+timestamp+"', '"+timestamp+"', "+0+" )";
            dbService.updateQueryToDb(query);
        }
    }

    public PlayerInfoBean getPlayerIdInfo(int matchId, int teamId, int playerId){
        PlayerInfoBean playerInfo = new PlayerInfoBean(0,0,0,"",0,"");
        String query = " select * from PlayerInfo where (matchId = "+matchId+"  AND teamId = "+teamId+" AND playerId = "+playerId+")";
        ResultSet rs= dbService.getQueryFromDb(query);
        try {
            rs.next();
            playerInfo.setMatchId(rs.getInt("matchId"));
            playerInfo.setTeamId(rs.getInt("teamId"));
            playerInfo.setPlayerId(rs.getInt("playerId"));
            playerInfo.setName(rs.getString("name"));
            playerInfo.setAge(rs.getInt("age"));
            playerInfo.setPlayerType(rs.getString("playerType"));
            playerInfo.setCreatedTime(rs.getLong("createdTime"));
            playerInfo.setModifiedTime(rs.getLong("modifiedTime"));
            playerInfo.setDeleted(rs.getBoolean("deleted"));
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return playerInfo;
    }

    public PlayerMatchBean getPlayerIdMatchInfo(int matchId, int teamId, int playerId){
        PlayerMatchBean playerMatchInfo = new PlayerMatchBean(0,0,0,0);
        String query = " select * from PlayerMatchData where (matchId = "+matchId+"  AND teamId = "+teamId+" AND playerId = "+playerId+")";
        ResultSet rs= dbService.getQueryFromDb(query);
        try {
            rs.next();
            playerMatchInfo.setMatchId(rs.getInt("matchId"));
            playerMatchInfo.setPlayerId(rs.getInt("playerId"));
            playerMatchInfo.setTeamId(rs.getInt("teamId"));
            playerMatchInfo.setScore(rs.getInt("score"));
            playerMatchInfo.setNumberOfBallsPlayed(rs.getInt("numberOfBallsPlayed"));
            playerMatchInfo.setCreatedTime(rs.getLong("createdTime"));
            playerMatchInfo.setModifiedTime(rs.getLong("modifiedTime"));
            playerMatchInfo.setDeleted(rs.getBoolean("deleted"));
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return playerMatchInfo;
    }

    public void playerInfoUpdation(ArrayList<PlayerInfoBean> playerInfoList, MatchDto matchInfo) {
        long timestamp = (System.currentTimeMillis());
        for(int i=0;i<2*Constants.NO_OF_PLAYER;i++){
            String query=" insert into PlayerInfo (playerId, teamId, matchId, name, age, playerType, createdTime, modifiedTime, deleted) values" +
                    "( "+playerInfoList.get(i).getPlayerId()+", "+playerInfoList.get(i).getTeamId()+", "+matchInfo.getMatchId()+", '"+playerInfoList.get(i).getName()+"', " +
                    "  "+playerInfoList.get(i).getAge()+", '"+playerInfoList.get(i).getPlayerType()+"' , '"+timestamp+"', '"+timestamp+"', "+0+" )";
            dbService.updateQueryToDb(query);
        }
    }

    public boolean checkPlayerId(int matchId,int teamId,int playerId){
        boolean validatePlayer = false;

        String query = " select * from PlayerMatchData where (matchId = "+matchId+"  AND teamId = "+teamId+" AND playerId = "+playerId+")";
        ResultSet rs= dbService.getQueryFromDb(query);
        try {
            while (rs.next()){
                validatePlayer = true;
            }
        }
        catch (SQLException exce){
            exce.printStackTrace();
        }
        return validatePlayer;
    }

}
