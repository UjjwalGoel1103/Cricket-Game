package com.company.CricketGame.services;

import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.bean.PlayerMatchBean;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    PlayerInfoBean getPlayerInfo(int matchId, int teamId, int playerId);
    PlayerMatchBean getPlayerMatchInfo(int matchId, int teamId, int playerId);
    boolean validatePlayerInquiry(int matchId, int teamId, int playerId);
}
