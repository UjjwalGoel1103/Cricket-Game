package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Match {
    int NumberOfOvers;
    Team Team1 = new Team();
    Team Team2 = new Team();

    enum MatchType {
        FiveOver,
        T20,
        FiftyOver
    }

    Match(String TeamName1, String TeamName2){
        Team1.setTeamName(TeamName1);
        Team2.setTeamName(TeamName2);
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting A New Match");
        System.out.println("Which Format Match you want : FiveOver / T20 / FiftyOver");
        String MatchTypeByUser = sc.next();
        // convert String to enum
        MatchType ApplyingMatchType = MatchType.valueOf(MatchTypeByUser.toUpperCase());
        if(MatchType.FiveOver==ApplyingMatchType){
            NumberOfOvers=5;
        }
        else if(MatchType.T20==ApplyingMatchType){
            NumberOfOvers=20;
        }
        else if(MatchType.FiftyOver==ApplyingMatchType) {
            NumberOfOvers = 50;
        }
        StartMatch();
    }

    private void StartMatch(){
        int WinnerOfToss = PerformToss();
        PerformInningSchedule(WinnerOfToss);
        ShowFinalResult();
    }

    private void PerformInningSchedule(int WinnerOfToss){
        int WinnerChoice = 1;
        if(WinnerOfToss==1 )
        {
            if(WinnerChoice==1){
                PlayInning(Team1);
                PlayInning(Team2);
            }
            else{
                PlayInning(Team2);
                PlayInning(Team1);
            }
        }
        else
        {
            if(WinnerChoice==1){
                PlayInning(Team2);
                PlayInning(Team1);
            }
            else{
                PlayInning(Team1);
                PlayInning(Team2);
            }
        }
    }

    void ShowFinalResult(){
        System.out.println("in show final result");
    }

    int PerformToss(){
        int WinnerOfToss = RandomNumberBetweenLtoR(1,2);
        return WinnerOfToss;
    }

    int CurrentBallStatus(){
        int BallStatus = RandomNumberBetweenLtoR(-1,6);
        return BallStatus;
    }

    void PlayInning(Team BattingTeam){
        while (BattingTeam.getNumberOfWicketsDown()<10 && BattingTeam.getNumberOfBallsPlayed()<6*NumberOfOvers){
            int CurrentBallStatus = CurrentBallStatus();
            BattingTeam.PlayCurrentBall(CurrentBallStatus);
        }
    }

    int RandomNumberBetweenLtoR(int Min, int Max){
        int RandomNumber = (int)(Math.random()*(Max-Min+1)+Min);
        return RandomNumber;
    }
}

