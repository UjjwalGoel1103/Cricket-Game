package com.company.CricketGame.controller;

import com.company.CricketGame.bean.MatchBean;
import com.company.CricketGame.dto.MatchCreationResponseDto;
import com.company.CricketGame.dto.MatchDto;
import com.company.CricketGame.services.MatchService;
import com.company.CricketGame.services.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/match")
public class MatchController {

    @Autowired
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping (value = "/startMatch")
    public MatchBean startNewMatch(@RequestBody MatchCreationResponseDto matchCreationResponse){
        boolean newMatchResponse = matchService.validateMatchCreationResponse(matchCreationResponse);
        MatchBean matchDetail = new MatchBean();
        if(newMatchResponse) {
            matchDetail = matchService.startMatch(matchCreationResponse);
            return matchDetail;
        }
        return matchDetail;
    }

    @GetMapping("/matchInfo/{matchId}")
    public ResponseEntity<MatchBean> getMatchInfo(@PathVariable Integer matchId){
        boolean matchInquiry = matchService.validateMatchId(matchId);
        MatchBean matchInfo = new MatchBean();
        if(matchInquiry){
            matchInfo= matchService.getMatchInfo(matchId);
        }
        return ResponseEntity.ok(matchInfo);
    }

}
