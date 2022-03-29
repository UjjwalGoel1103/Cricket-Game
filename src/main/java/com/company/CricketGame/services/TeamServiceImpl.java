package com.company.CricketGame.services;

import com.company.CricketGame.bean.TeamBean;
import com.company.CricketGame.dto.PerBallDto;
import com.company.CricketGame.dto.PlayerDto;
import com.company.CricketGame.dto.TeamDto;
import com.company.CricketGame.enums.PlayerType;
import com.company.CricketGame.repo.DatabaseRepo;
import com.company.CricketGame.repo.DatabaseRepoImpl;
import com.company.CricketGame.repo.TeamDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Component
@CacheConfig(cacheNames = {"team"})
public class TeamServiceImpl implements TeamService{

    @Autowired
    TeamDetailsRepo teamDetails;

    public TeamServiceImpl(TeamDetailsRepo teamDetails) {
        this.teamDetails = teamDetails;
    }

    public TeamDto playCurrentBall(TeamDto teamdto,int currentBallStatus){
        TeamDto teamDto = teamdto;
        teamDto.setNumberOfBallsPlayed(teamDto.getNumberOfBallsPlayed()+1);
        if(currentBallStatus==-1){
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerLossesWicket();
            teamDto.setNumberOfWicketsDown(teamDto.getNumberOfWicketsDown()+1);
        }
        else if(currentBallStatus==0){
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerScoreZero();
        }
        else if(currentBallStatus==1){
            teamDto.setTotalScore(teamDto.getTotalScore()+1) ;
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerScoreOne();
        }
        else if(currentBallStatus==2){
            teamDto.setTotalScore(teamDto.getTotalScore()+2) ;
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerScoreTwo();
        }
        else if(currentBallStatus==3){
            teamDto.setTotalScore(teamDto.getTotalScore()+3) ;
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerScoreThree();
        }
        else if(currentBallStatus==4){
            teamDto.setTotalScore(teamDto.getTotalScore()+4) ;
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerScoreFour();
        }
        else if(currentBallStatus==5){
            teamDto.setTotalScore(teamDto.getTotalScore()+5) ;
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerScoreFive();
        }
        else if(currentBallStatus==6){
            teamDto.setTotalScore(teamDto.getTotalScore()+6) ;
            teamDto.getPlayersOfATeam().get(teamDto.getNumberOfWicketsDown()).playerScoreSix();
        }
        return teamDto;
    }

    @Cacheable(cacheNames = "teamCache")
    public TeamBean getTeamDetail(int matchId, int teamId){
        return teamDetails.getTeamIdDetail(matchId, teamId);
    }

    public boolean validateTeamInquiry(int matchId,int teamId){
        return teamDetails.checkTeamId(matchId, teamId);
    }
}