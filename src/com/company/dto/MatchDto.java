package com.company.dto;

import com.company.services.TeamService;

public class MatchDto {
    int numberOfOvers;
    int currentBattingTeam;
    TeamService teamService1;
    TeamService teamService2;

    public MatchDto() {
        teamService1 = new TeamService();
        teamService2 = new TeamService();
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
