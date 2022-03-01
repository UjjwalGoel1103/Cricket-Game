package com.company.repo;

import com.company.Constants.Constants;
import com.company.bean.PlayerBean;
import com.company.dto.MatchDto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PlayerDetailsRepoImpls implements PlayerDetailsRepoService{

    public void playerDetailUpdation(ArrayList<PlayerBean> playersList, MatchDto matchInfo){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        for(int i=0;i<2*Constants.NO_OF_PLAYER;i++){
            String query=" insert into PlayerMatchData (playerId, teamId, name, age, score, numberOfBallsPlayed, " +
                    "playerType, matchId, createdTime, modifiedTime) values( "+playersList.get(i).getPlayerId()+", "+playersList.get(i).getTeamId()+", '"+playersList.get(i).getName()+"'," +
                    " "+playersList.get(i).getAge()+", "+playersList.get(i).getScore()+", "+playersList.get(i).getNumberOfBallsPlayed()+", " +
                    " '"+playersList.get(i).getPlayerType()+"', "+ matchInfo.getMatchId()+" , '"+timestamp+"', '"+timestamp+"' )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
        }
    }

}
