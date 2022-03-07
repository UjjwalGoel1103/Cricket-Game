package com.company.CricketGame.controller;

import com.company.CricketGame.bean.MatchBean;
import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.bean.PlayerMatchBean;
import com.company.CricketGame.services.MatchService;
import com.company.CricketGame.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/playerMatchInfo/{matchId}/{teamId}/{playerId}")
    public ResponseEntity<PlayerMatchBean> getPlayerMatchInfo(@PathVariable("matchId") Integer matchId, @PathVariable("teamId") Integer teamId, @PathVariable("playerId") Integer playerId ){
        boolean playerInquiry = playerService.validatePlayerInquiry(matchId, teamId, playerId);
        PlayerMatchBean playerMatchInfo = new PlayerMatchBean(-1,-1,-1,-1);
        if(playerInquiry) {
            playerMatchInfo= playerService.getPlayerMatchInfo(matchId, teamId, playerId);
        }
        return ResponseEntity.ok(playerMatchInfo);
    }

    @GetMapping("/playerInfo/{matchId}/{teamId}/{playerId}")
    public ResponseEntity<PlayerInfoBean> getPlayerInfo(@PathVariable("matchId") Integer matchId, @PathVariable("teamId") Integer teamId, @PathVariable("playerId") Integer playerId ){
        boolean playerInquiry = playerService.validatePlayerInquiry(matchId, teamId, playerId);
        PlayerInfoBean playerInfo = new PlayerInfoBean(-1,-1,-1, "",-1, "");
        if(playerInquiry){
            playerInfo= playerService.getPlayerInfo(matchId, teamId, playerId);
        }
        return ResponseEntity.ok(playerInfo);
    }

}
