package com.company.CricketGame.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class MatchCreationResponseDto {

    @JsonView
    private String team1Name;
    @JsonView
    private String team2Name;
    @JsonView
    private String matchType;
    @JsonView
    private String tossWinnerPreference;

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getTossWinnerPreference() {
        return tossWinnerPreference;
    }

    public void setTossWinnerPreference(String tossWinnerPreference) {
        this.tossWinnerPreference = tossWinnerPreference;
    }

    public MatchCreationResponseDto(String team1Name, String team2Name, String matchType, String tossWinnerPreference) {
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.matchType = matchType;
        this.tossWinnerPreference = tossWinnerPreference;
    }
}
