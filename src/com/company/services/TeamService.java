package com.company.services;

import com.company.Constants.Constants;
import com.company.dto.PerBallDto;
import com.company.dto.PlayerDto;
import com.company.dto.TeamDto;
import com.company.enums.PlayerType;

import java.util.ArrayList;

public class TeamService {

    TeamDto teamDto;

    public TeamService(int teamId) {
        teamDto = new TeamDto( );

        for(int i=0;i<teamDto.getNumberOfPlayer();i++){
            PlayerDto p = new PlayerDto();
            teamDto.getPlayersOfATeam().add(p);
        }
        if(teamId == 1)
            setTeam1PlayersDefaultInfo();
        else
            setTeam2PlayersDefaultInfo();
    }

    public ArrayList<PerBallDto> getPerBallStatus(){
        return this.teamDto.getPerBallStatus();
    }

    public void setPerBallStatus(ArrayList<PerBallDto> perBallStatus){
        this.teamDto.setPerBallStatus(perBallStatus);
    }

    public TeamDto getTeamDto(){
        return teamDto;
    }

    public ArrayList getPlayersOfATeam(){
        return this.teamDto.getPlayersOfATeam();
    }

    public int getIthBallStatus(int ballId) {
        return teamDto.getPerBallStatus().get(ballId).getBallStatus();
    }

    public int getIthBallPlayerId(int ballId) {
        return teamDto.getPerBallStatus().get(ballId).getPlayerId();
    }

    public int getIthPlayerProbOfOut(int playerId) {
        return teamDto.getPlayersOfATeam().get(playerId).getPlayerType().getProbOfOut();
    }

    public void setTeamName(String teamName){
        teamDto.setTeamName(teamName);
    }

    public String getTeamName(){
        return teamDto.getTeamName();
    }

    public void setNumberOfPlayer(int numberOfPlayer){
        teamDto.setNumberOfPlayer(numberOfPlayer);
    }

    public int getNumberOfPlayer(){
        return teamDto.getNumberOfPlayer();
    }

    public void setTotalScore(int totalScore){
        teamDto.setTotalScore(totalScore);
    }

    public int getTotalScore(){
        return teamDto.getTotalScore();
    }

    public void setNumberOfWicketsDown(int numberOfWicketsDown){
        teamDto.setNumberOfWicketsDown(numberOfWicketsDown);
    }

    public int getNumberOfWicketsDown(){
        return teamDto.getNumberOfWicketsDown();
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed){
        teamDto.setNumberOfBallsPlayed(numberOfBallsPlayed);
    }

    public int getNumberOfBallsPlayed(){
        return teamDto.getNumberOfBallsPlayed();
    }

    private void setIthPlayerOfATeam(int playerId, String name, int age, PlayerType playerType){
        teamDto.getPlayersOfATeam().get(playerId).setName(name);
        teamDto.getPlayersOfATeam().get(playerId).setAge(age);
        teamDto.getPlayersOfATeam().get(playerId).setPlayerType(playerType);
    }

    public String getIthPlayerName(int playerID){
        return teamDto.getPlayersOfATeam().get(playerID).getName();
    }

    public int getIthPlayerAge(int playerID){
        return teamDto.getPlayersOfATeam().get(playerID).getAge();
    }

    public int getIthPlayerScore(int playerID){
        return teamDto.getPlayersOfATeam().get(playerID).getScore();
    }

    public int getIthPlayerBalls(int playerID){
        return teamDto.getPlayersOfATeam().get(playerID).getNumberOfBallsPlayed();
    }

    public String getIthPlayerType(int playerID){
        return teamDto.getPlayersOfATeam().get(playerID).getPlayerType().getStringPlayerType();
    }

    public void playCurrentBall(int currentBallStatus){
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
    }

    private void setTeam1PlayersDefaultInfo(){
        setIthPlayerOfATeam(0,"Sachin Tendulakr ", 25, PlayerType.BATSMAN);
        setIthPlayerOfATeam(1,"Virendar Sehwag  ", 20, PlayerType.BATSMAN);
        setIthPlayerOfATeam(2,"Virat Kohli      ", 22, PlayerType.BATSMAN);
        setIthPlayerOfATeam(3,"Rohit Sharma     ", 30, PlayerType.BATSMAN);
        setIthPlayerOfATeam(4,"MS Dhoni         ", 25, PlayerType.WICKET_KEEPER);
        setIthPlayerOfATeam(5,"Ravindra Jadeja  ", 21, PlayerType.ALL_ROUNDER);
        setIthPlayerOfATeam(6,"Yuvraj Singh     ", 28, PlayerType.ALL_ROUNDER);
        setIthPlayerOfATeam(7,"Harbhajan Singh  ", 29, PlayerType.BOWLER);
        setIthPlayerOfATeam(8,"Jasprit Bumrah   ", 20, PlayerType.BOWLER);
        setIthPlayerOfATeam(9,"Ravindra Ashwin  ", 27, PlayerType.BOWLER);
        setIthPlayerOfATeam(10,"Mohomadd Shami  ", 29, PlayerType.BOWLER);
    }

    private void setTeam2PlayersDefaultInfo(){
        setIthPlayerOfATeam(0,"Aaron Finch      ", 21, PlayerType.BATSMAN);
        setIthPlayerOfATeam(1,"Ricky Pointing   ", 30, PlayerType.BATSMAN);
        setIthPlayerOfATeam(2,"Steve Smith      ", 22, PlayerType.BATSMAN);
        setIthPlayerOfATeam(3,"David Warner     ", 20, PlayerType.BATSMAN);
        setIthPlayerOfATeam(4,"Matthew Wade     ", 35, PlayerType.WICKET_KEEPER);
        setIthPlayerOfATeam(5,"Marcus Stoinis   ", 29, PlayerType.ALL_ROUNDER);
        setIthPlayerOfATeam(6,"Glenn Maxwell    ", 25, PlayerType.ALL_ROUNDER);
        setIthPlayerOfATeam(7,"Daniel Sams      ", 24, PlayerType.BOWLER);
        setIthPlayerOfATeam(8,"Mitchell Starc   ", 23, PlayerType.BOWLER);
        setIthPlayerOfATeam(9,"Adam Zampa       ", 21, PlayerType.BOWLER);
        setIthPlayerOfATeam(10,"Pat Cummins      ", 28, PlayerType.BOWLER);
    }

}