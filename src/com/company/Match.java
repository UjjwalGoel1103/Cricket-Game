package com.company;

import com.company.enums.MatchType;

import java.util.ArrayList;
import java.util.Scanner;

public class Match {
    int numberOfOvers;
    Team team1 = new Team();
    Team team2 = new Team();

    Match(String teamName1, String teamName2){
        team1.setTeamName(teamName1);
        team2.setTeamName(teamName2);
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting A New Match");
        System.out.println("Which Format Match you want : FIVE_OVER / T20 / FIFTY_OVER");
        String matchTypeByUser = sc.next();
        // convert String to enum
        MatchType applyingMatchType = MatchType.valueOf(matchTypeByUser);
        if(MatchType.FIVE_OVER==applyingMatchType){
            numberOfOvers=5;
        }
        else if(MatchType.T20==applyingMatchType){
            numberOfOvers=20;
        }
        else if(MatchType.FIFTY_OVER==applyingMatchType) {
            numberOfOvers = 50;
        }
        startMatch();
    }

    private void startMatch(){
        int winnerOfToss = performToss();
        performInningSchedule(winnerOfToss);
        showFinalResult();
    }

    private void performInningSchedule(int winnerOfToss){
        int winnerChoice = 1;
        if(winnerOfToss==1 )
        {
            if(winnerChoice==1){
                System.out.println("FIRST INNING START");
                playInning(team1);
                System.out.println();
                System.out.println();
                System.out.println("SECOND INNING START");
                System.out.println();
                System.out.println();

                playInning(team2);
            }
            else{
                System.out.println("FIRST INNING START");
                playInning(team2);
                System.out.println();
                System.out.println();
                System.out.println("SECOND INNING START");
                System.out.println();
                System.out.println();
                playInning(team1);
            }
        }
        else
        {
            if(winnerChoice==1){
                System.out.println("FIRST INNING START");
                playInning(team2);
                System.out.println();
                System.out.println();
                System.out.println("SECOND INNING START");
                System.out.println();
                System.out.println();
                playInning(team1);
            }
            else{
                System.out.println("FIRST INNING START");
                playInning(team1);
                System.out.println();
                System.out.println();
                System.out.println("SECOND INNING START");
                System.out.println();
                System.out.println();
                playInning(team2);
            }
        }
    }

    void showFinalResult(){
        System.out.println();
        System.out.println("Final result");
    }

    int performToss(){
        int winnerOfToss = randomNumberBetweenLtoR(1,2);
        return winnerOfToss;
    }

    int currentBallStatus(){
        int ballStatus = randomNumberBetweenLtoR(-1,6);
        return ballStatus;
    }

    void playInning(Team battingTeam){
        while (battingTeam.getNumberOfWicketsDown()<10 && battingTeam.getNumberOfBallsPlayed()<6*numberOfOvers){
            int currentBallStatus = currentBallStatus();
            if(battingTeam.getNumberOfBallsPlayed()%6==0 )
                System.out.println();
            if(battingTeam.getNumberOfBallsPlayed()==0 || battingTeam.getNumberOfBallsPlayed()%6==0 )
                System.out.println(battingTeam.getNumberOfBallsPlayed()/6+1 + " Over");
            showCurrentBallStatus(currentBallStatus);
            battingTeam.playCurrentBall(currentBallStatus);
        }
    }

    void showCurrentBallStatus(int currentBallStatus){
        if(currentBallStatus==-1){
            System.out.print("W ");
        }
        else{
            System.out.print(currentBallStatus+ " ");
        }
    }

    int randomNumberBetweenLtoR(int min, int max){
        min--;
        max++;
        int randomNumber = (int)(Math.random()*(max-min)+min);
        return randomNumber;
    }
}

