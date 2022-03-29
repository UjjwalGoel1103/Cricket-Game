package com.company.CricketGame.services;

import com.company.CricketGame.bean.TeamBean;
import com.company.CricketGame.dto.PerBallDto;
import com.company.CricketGame.dto.TeamDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface TeamService {

    TeamBean getTeamDetail(int matchId, int teamId);

    TeamDto playCurrentBall(TeamDto teamDto,int currentBallStatus);

    boolean validateTeamInquiry(int matchId,int teamId);

}
