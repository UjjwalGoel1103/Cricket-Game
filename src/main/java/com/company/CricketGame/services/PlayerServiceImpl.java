package com.company.CricketGame.services;

import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.bean.PlayerMatchBean;
import com.company.CricketGame.repo.DatabaseRepo;
import com.company.CricketGame.repo.DatabaseRepoImpl;
import com.company.CricketGame.repo.PlayerDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private final PlayerDetailsRepo playerDetail;

    public PlayerServiceImpl(PlayerDetailsRepo playerDetail) {
        this.playerDetail = playerDetail;
    }

    @Cacheable( cacheNames="playerInfo" )
    public PlayerInfoBean getPlayerInfo(int matchId, int teamId, int playerId){
        return playerDetail.getPlayerIdInfo(matchId, teamId, playerId);
    }

    @Cacheable( cacheNames="playerMatchInfo" )
    public PlayerMatchBean getPlayerMatchInfo(int matchId, int teamId, int playerId){
        return playerDetail.getPlayerIdMatchInfo(matchId, teamId, playerId);
    }

    public boolean validatePlayerInquiry(int matchId, int teamId, int playerId){
        return playerDetail.checkPlayerId(matchId, teamId, playerId);
    }

}
