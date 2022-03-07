package com.company.CricketGame.controller;

import com.company.CricketGame.bean.PlayerInfoBean;
import com.company.CricketGame.bean.PlayerMatchBean;
import com.company.CricketGame.bean.TeamBean;
import com.company.CricketGame.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/team")
public class TeamController {

    @Autowired
    TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teamInfo/{matchId}/{teamId}")
    public ResponseEntity<TeamBean> getPlayerMatchInfo(@PathVariable("matchId") Integer matchId, @PathVariable("teamId") Integer teamId ){
        boolean teamInquiry = teamService.validateTeamInquiry(matchId, teamId);
        TeamBean teamDetail = new TeamBean();
        if(teamInquiry){
            teamDetail= teamService.getTeamDetail(matchId, teamId);
        }
        return ResponseEntity.ok(teamDetail);
    }

}
