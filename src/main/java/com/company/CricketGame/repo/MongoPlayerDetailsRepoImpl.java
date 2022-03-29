package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.bean.PlayerMatchBean;
import com.company.CricketGame.bean.TeamBean;
import com.company.CricketGame.constants.Constants;
import com.company.CricketGame.dto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public class MongoPlayerDetailsRepoImpl implements PlayerDetailsRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void playerDetailUpdation(ArrayList<PlayerMatchBean> playersList, MatchDto matchInfo) {
        long timestamp = (System.currentTimeMillis());
        for(int i = 0; i<2* Constants.NO_OF_PLAYER; i++){
            playersList.get(i).setMatchId(matchInfo.getMatchId());
            playersList.get(i).setCreatedTime(timestamp);
            playersList.get(i).setModifiedTime(timestamp);
            playersList.get(i).setDeleted(false);
            mongoTemplate.save(playersList.get(i), "PlayerMatchData");
        }
    }

    @Override
    public PlayerInfoBean getPlayerIdInfo(int matchId, int teamId, int playerId){
        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId).and("teamId").is(teamId).and("playerId").is(playerId));
        return mongoTemplate.findOne(query , PlayerInfoBean.class , "PlayerInfo");
    }

    @Override
    public PlayerMatchBean getPlayerIdMatchInfo(int matchId, int teamId, int playerId){
        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId).and("teamId").is(teamId).and("playerId").is(playerId));
        return mongoTemplate.findOne(query , PlayerMatchBean.class , "PlayerMatchData");
    }

    @Override
    public void playerInfoUpdation(ArrayList<PlayerInfoBean> playerInfoList, MatchDto matchInfo) {

        long timestamp = (System.currentTimeMillis());
        for(int i = 0; i<2* Constants.NO_OF_PLAYER; i++){
            playerInfoList.get(i).setMatchId(matchInfo.getMatchId());
            playerInfoList.get(i).setCreatedTime(timestamp);
            playerInfoList.get(i).setModifiedTime(timestamp);
            playerInfoList.get(i).setDeleted(false);
            mongoTemplate.save(playerInfoList.get(i), "PlayerInfo");
        }
    }

    @Override
    public boolean checkPlayerId(int matchId,int teamId,int playerId){

        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId).and("teamId").is(teamId).and("playerId").is(playerId));
        PlayerMatchBean playerDetail =  mongoTemplate.findOne(query , PlayerMatchBean.class , "PlayerMatchData");
        if(playerDetail == null)
            return false;
        else
            return true;
    }
}
