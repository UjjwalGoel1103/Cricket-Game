package com.company.repo;

import com.company.Constants.Constants;
import com.company.bean.PlayerMatchBean;
import com.company.dto.MatchDto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PlayerDetailsRepoImpls implements PlayerDetailsRepoService{

    public void playerDetailUpdation(ArrayList<PlayerMatchBean> playersList, MatchDto matchInfo){

        long timestamp = (System.currentTimeMillis());
        for(int i=0;i<2*Constants.NO_OF_PLAYER;i++){
            String query=" insert into PlayerMatchData (playerId, teamId, score, numberOfBallsPlayed, " +
                    " matchId, createdTime, modifiedTime, deleted) values( "+playersList.get(i).getPlayerId()+", "+playersList.get(i).getTeamId()+"," +
                    "  "+playersList.get(i).getScore()+", "+playersList.get(i).getNumberOfBallsPlayed()+", " +
                    "  "+ matchInfo.getMatchId()+" , '"+timestamp+"', '"+timestamp+"', "+0+" )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
        }
    }

}
