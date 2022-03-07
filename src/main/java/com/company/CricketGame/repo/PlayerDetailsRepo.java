package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.bean.PlayerMatchBean;
import com.company.CricketGame.dto.MatchDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PlayerDetailsRepo {

    void playerDetailUpdation(ArrayList<PlayerMatchBean> playersList, MatchDto matchInfo);
    void playerInfoUpdation(ArrayList<PlayerInfoBean> playerInfoList, MatchDto matchInfo);
    PlayerInfoBean getPlayerIdInfo(int matchId, int teamId, int playerId);
    PlayerMatchBean getPlayerIdMatchInfo(int matchId, int teamId, int playerId);
    boolean checkPlayerId(int matchId, int teamId,int  playerId);

}
