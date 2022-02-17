package com.company.dto;

import com.company.Team;

public class MatchDto {
    int numberOfOvers;
    int currentBattingTeam;
    Team team1 ;
    Team team2 ;

    public MatchDto() {
        team1 = new Team();
        team2 = new Team();
    }

    public int getNumberOfOvers() {
        return numberOfOvers;
    }

    public void setNumberOfOvers(int numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public void setTeam1Name(String team1Name){
        team1.setTeamName(team1Name);
    }

    public void setTeam2Name(String team2Name){
        team1.setTeamName(team2Name);
    }
}
