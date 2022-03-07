package com.company.CricketGame.dto;

import com.company.CricketGame.enums.PlayerType;
import com.company.CricketGame.services.TeamServiceImpl;
import lombok.Data;

@Data
public class MatchDto {

    int numberOfOvers;
    String tossWinner;
    String matchWinner;
    TeamDto team1;
    TeamDto team2;
    int matchId;

    public MatchDto() {
        prepareTeam();
    }

    public int getMatchId() {
        return this.matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getTossWinner() {
        return this.tossWinner;
    }

    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }

    public String getMatchWinner() {
        return this.matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public int getNumberOfOvers() {
        return numberOfOvers;
    }

    public void setNumberOfOvers(int numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
    }

    public TeamDto getTeam1() {
        return this.team1;
    }

    public void setTeam1(TeamDto teamDto) {
        this.team1 = teamDto;
    }

    public TeamDto getTeam2() {
        return this.team2;
    }

    public void setTeam2(TeamDto teamDto) {
        this.team2 = teamDto;
    }

    public void setTeam1Name(String team1Name){
        team1.setTeamName(team1Name);
    }

    public void setTeam2Name(String team2Name){
        team2.setTeamName(team2Name);
    }

    void prepareTeam(){
        this.team1 = new TeamDto();
        this.team2 = new TeamDto();

        for(int i=0;i<this.team1.getNumberOfPlayer();i++){
            PlayerDto p = new PlayerDto();
            team1.getPlayersOfATeam().add(p);
        }

        for(int i=0;i<this.team2.getNumberOfPlayer();i++){
            PlayerDto p = new PlayerDto();
            team2.getPlayersOfATeam().add(p);
        }
        setTeam1PlayersDefaultInfo();
        setTeam2PlayersDefaultInfo();
    }

    private void setTeam1PlayersDefaultInfo(){
        setTeam1IthPlayerOfATeam(0,"Sachin Tendulakr ", 25, PlayerType.BATSMAN);
        setTeam1IthPlayerOfATeam(1,"Virendar Sehwag  ", 20, PlayerType.BATSMAN);
        setTeam1IthPlayerOfATeam(2,"Virat Kohli      ", 22, PlayerType.BATSMAN);
        setTeam1IthPlayerOfATeam(3,"Rohit Sharma     ", 30, PlayerType.BATSMAN);
        setTeam1IthPlayerOfATeam(4,"MS Dhoni         ", 25, PlayerType.WICKET_KEEPER);
        setTeam1IthPlayerOfATeam(5,"Ravindra Jadeja  ", 21, PlayerType.ALL_ROUNDER);
        setTeam1IthPlayerOfATeam(6,"Yuvraj Singh     ", 28, PlayerType.ALL_ROUNDER);
        setTeam1IthPlayerOfATeam(7,"Harbhajan Singh  ", 29, PlayerType.BOWLER);
        setTeam1IthPlayerOfATeam(8,"Jasprit Bumrah   ", 20, PlayerType.BOWLER);
        setTeam1IthPlayerOfATeam(9,"Ravindra Ashwin  ", 27, PlayerType.BOWLER);
        setTeam1IthPlayerOfATeam(10,"Mohomadd Shami  ", 29, PlayerType.BOWLER);
    }

    private void setTeam2PlayersDefaultInfo(){
        setTeam2IthPlayerOfATeam(0,"Aaron Finch      ", 21, PlayerType.BATSMAN);
        setTeam2IthPlayerOfATeam(1,"Ricky Pointing   ", 30, PlayerType.BATSMAN);
        setTeam2IthPlayerOfATeam(2,"Steve Smith      ", 22, PlayerType.BATSMAN);
        setTeam2IthPlayerOfATeam(3,"David Warner     ", 20, PlayerType.BATSMAN);
        setTeam2IthPlayerOfATeam(4,"Matthew Wade     ", 35, PlayerType.WICKET_KEEPER);
        setTeam2IthPlayerOfATeam(5,"Marcus Stoinis   ", 29, PlayerType.ALL_ROUNDER);
        setTeam2IthPlayerOfATeam(6,"Glenn Maxwell    ", 25, PlayerType.ALL_ROUNDER);
        setTeam2IthPlayerOfATeam(7,"Daniel Sams      ", 24, PlayerType.BOWLER);
        setTeam2IthPlayerOfATeam(8,"Mitchell Starc   ", 23, PlayerType.BOWLER);
        setTeam2IthPlayerOfATeam(9,"Adam Zampa       ", 21, PlayerType.BOWLER);
        setTeam2IthPlayerOfATeam(10,"Pat Cummins      ", 28, PlayerType.BOWLER);
    }

    private void setTeam1IthPlayerOfATeam(int playerId, String name, int age, PlayerType playerType){
        this.team1.getPlayersOfATeam().get(playerId).setName(name);
        this.team1.getPlayersOfATeam().get(playerId).setAge(age);
        this.team1.getPlayersOfATeam().get(playerId).setPlayerType(playerType);
    }

    private void setTeam2IthPlayerOfATeam(int playerId, String name, int age, PlayerType playerType){
        this.team2.getPlayersOfATeam().get(playerId).setName(name);
        this.team2.getPlayersOfATeam().get(playerId).setAge(age);
        this.team2.getPlayersOfATeam().get(playerId).setPlayerType(playerType);
    }


}
