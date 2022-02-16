package com.company;

import com.company.enums.MatchType;
import com.company.util.MatchUtils;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.validator.InputValidator.validateMatchType;

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
        MatchType applyingMatchType;
        String matchTypeByUser = sc.next();
        String defaultMatchType = "FIVE_OVER";
        boolean validateInput = validateMatchType(matchTypeByUser);
        if(!validateInput){
            System.out.println("You Provide inappropriate input, So by default making match of 5 Overs");
            applyingMatchType = MatchType.valueOf(defaultMatchType);
        }
        else{
            // convert String to enum
            applyingMatchType = MatchType.valueOf(matchTypeByUser);
        }
        numberOfOvers = applyingMatchType.getOverInThisType();
        startMatch();
    }

    private void startMatch(){
        int winnerOfToss = performToss();
        performInningSchedule(winnerOfToss);
        //Scoreboard With different Functionalities
        ScoreBoard scoreBoard = new ScoreBoard(team1, team2);
        scoreBoard.showTeam1ScoreCard();
        scoreBoard.showTeam2ScoreCard();
        scoreBoard.showFinalResult();
    }

    private void performInningSchedule(int winnerOfToss){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would You like to Batting or Bowling");
        String battingOrBowlingChoice = sc.nextLine();
        int winnerChoice;
        if(battingOrBowlingChoice.equals("Batting")){
            winnerChoice = 1;
        }
        else{
            winnerChoice = 0;
        }
        if( (winnerOfToss==1 && winnerChoice==1) || (winnerOfToss==0 && winnerChoice==0) )
        {
            System.out.println("\n" + "FIRST INNING START");
            playInning(team1);
            System.out.println("\n"+ "\n" + "SECOND INNING START"  );
            playInning(team2);
        }
        else{
            System.out.println("\n" + "FIRST INNING START");
            playInning(team2);
            System.out.println("\n" + "\n" + "SECOND INNING START"  );
            playInning(team1);
        }
    }

    int performToss(){
        int winnerOfToss = MatchUtils.randomNumberBetweenLtoR(1,2);
        return winnerOfToss;
    }

    int currentBallStatus(){
        int ballStatus = MatchUtils.randomNumberBetweenLtoR(0,6);
        return ballStatus;
    }

    void playInning(Team battingTeam){
        while (battingTeam.getNumberOfWicketsDown()<10 && battingTeam.getNumberOfBallsPlayed()<6*numberOfOvers){
            int randomProbability=MatchUtils.randomNumberBetweenLtoR(1,10);
            int currentBallStatus;
            //todo first add the functionlity to get the cuurent player
            //todo second ccurrent player ke enum ka prob of out nikalna
            //todo third uske corresponding per ball ka status track krna
            //todo arraylist me put krna show tracking krke

            if(randomProbability <= battingTeam.getIthPlayerProbOfOut(battingTeam.getNumberOfWicketsDown())){
                currentBallStatus=-1;
            }
            else{
                currentBallStatus = currentBallStatus();
            }
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
}

