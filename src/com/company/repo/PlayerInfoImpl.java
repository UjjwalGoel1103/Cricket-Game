package com.company.repo;

import com.company.Constants.Constants;
import com.company.bean.PlayerInfoBean;
import com.company.bean.TeamBean;
import com.company.dto.MatchDto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class PlayerInfoImpl implements PlayerInfoService {
    public void playerInfoUpdation(ArrayList<PlayerInfoBean> playerInfoList, MatchDto matchInfo) {

        long timestamp = (System.currentTimeMillis());
        for(int i=0;i<2*Constants.NO_OF_PLAYER;i++){
            String query=" insert into PlayerMatchData (playerId, teamId, matchId, name, age, playerType, createdTime, modifiedTime) values" +
                "( "+playerInfoList.get(i).getPlayerId()+", "+playerInfoList.get(i).getTeamId()+", "+matchInfo.getMatchId()+", "+playerInfoList.get(i).getName()+", " +
                "  "+playerInfoList.get(i).getAge()+", "+playerInfoList.get(i).getPlayerType()+" , '"+timestamp+"', '"+timestamp+"', "+0+" )";
            DatabaseService updateToDB = new DatabaseImpl();
            updateToDB.updateQueryToDb(query);
        }

    }
}
