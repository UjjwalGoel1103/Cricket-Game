package com.company.dto;

import com.company.services.TeamService;

public class MatchDto {
    int numberOfOvers;
    String tossWinner;
    String matchWinner;
    TeamService teamService1;
    TeamService teamService2;
    int matchId;

    public MatchDto() {
        teamService1 = new TeamService(1);
        teamService2 = new TeamService(2);
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

    public TeamService getTeam1() {
        return teamService1;
    }

    public void setTeam1(TeamService teamService1) {
        this.teamService1 = teamService1;
    }

    public TeamService getTeam2() {
        return teamService2;
    }

    public void setTeam2(TeamService teamService2) {
        this.teamService2 = teamService2;
    }

    public void setTeam1Name(String team1Name){
        teamService1.setTeamName(team1Name);
    }

    public void setTeam2Name(String team2Name){
        teamService2.setTeamName(team2Name);
    }
}
