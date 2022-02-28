package com.company.services;

import com.company.Constants.Constants;
import com.company.bean.PlayerBean;
import com.company.dto.MatchDto;
import com.company.repo.DatabaseImpl;
import com.company.repo.DatabaseService;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class UpdatePlayerDetails {

    public void playerDetailUpdation(MatchDto matchInfo){
        ArrayList<PlayerBean> playersList = preparePlayerBean( matchInfo);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        for(int i=0;i<2*Constants.NO_OF_PLAYER;i++){
            String query=" insert into playerData (playerId, teamId, name, age, score, numberOfBallsPlayed, " +
                    "playerType, matchId, createdTime, modifiedTime) values( "+playersList.get(i).getPlayerId()+", "+playersList.get(i).getTeamId()+", '"+playersList.get(i).getName()+"'," +
                    " "+playersList.get(i).getAge()+", "+playersList.get(i).getScore()+", "+playersList.get(i).getNumberOfBallsPlayed()+", " +
                    " '"+playersList.get(i).getPlayerType()+"', "+ matchInfo.getMatchId()+" , '"+timestamp+"', '"+timestamp+"' )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
        }
    }

    public ArrayList<PlayerBean> preparePlayerBean(MatchDto matchInfo){
        ArrayList<PlayerBean> playerList = new ArrayList<>(2*Constants.NO_OF_PLAYER);
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            PlayerBean newPlayer = new PlayerBean(i, 1, matchInfo.getTeam1().getIthPlayerName(i), matchInfo.getTeam1().getIthPlayerAge(i),
                    matchInfo.getTeam1().getIthPlayerScore(i), matchInfo.getTeam1().getIthPlayerBalls(i), matchInfo.getTeam1().getIthPlayerType(i));
            playerList.add(newPlayer);
        }
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            PlayerBean newPlayer = new PlayerBean(i, 2, matchInfo.getTeam2().getIthPlayerName(i), matchInfo.getTeam2().getIthPlayerAge(i),
                    matchInfo.getTeam2().getIthPlayerScore(i), matchInfo.getTeam2().getIthPlayerBalls(i), matchInfo.getTeam2().getIthPlayerType(i));
            playerList.add(newPlayer);
        }
        return playerList;
    }

}
