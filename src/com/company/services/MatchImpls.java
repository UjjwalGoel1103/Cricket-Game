package com.company.services;

import com.company.Team;
import com.company.dto.MatchDto;
import com.company.enums.MatchType;
import com.company.util.MatchUtils;

import java.util.Scanner;

import static com.company.validator.InputValidator.validateMatchType;

public class MatchImpls implements MatchService {
    MatchDto matchData = new MatchDto();

    public MatchImpls(String teamName1, String teamName2){
        matchData.setTeam1Name(teamName1);
        matchData.setTeam2Name(teamName2);
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
        matchData.setNumberOfOvers(applyingMatchType.getOverInThisType()) ;
        startMatch();
    }

    public void startMatch(){
        int winnerOfToss = performToss();
        //Scoreboard With different Functionalities
        ScoreBoardService scoreBoard = new ScoreBoardImpls(matchData);
        performInningSchedule(winnerOfToss);
        scoreBoard.updateScoreBoard(matchData);
        scoreBoard.showTeam1ScoreCard();
        scoreBoard.showTeam2ScoreCard();
        scoreBoard.showFinalResult();
    }

    public void performInningSchedule(int winnerOfToss){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would You like to Batting or Bowling");
        //todo agr dusri team win then random generate choice dont ask user for batting or bowling
        String battingOrBowlingChoice = sc.nextLine();
        int winnerChoice;
        //todo batting bowling puchne ka enum banana
        if(battingOrBowlingChoice.equals("Batting")){
            winnerChoice = 1;
        }
        else{
            winnerChoice = 0;
        }
        if( (winnerOfToss==1 && winnerChoice==1) || (winnerOfToss==0 && winnerChoice==0) )
        {
            System.out.println("\n" + "FIRST INNING START");
            playInning(matchData.getTeam1());
            System.out.println("\n"+ "\n" + "SECOND INNING START"  );
            playInning(matchData.getTeam2());
        }
        else{
            System.out.println("\n" + "FIRST INNING START");
            playInning(matchData.getTeam2());
            System.out.println("\n" + "\n" + "SECOND INNING START"  );
            playInning(matchData.getTeam1());
        }
    }

    public int performToss(){
        int winnerOfToss = MatchUtils.randomNumberBetweenLtoR(1,2);
        return winnerOfToss;
    }

    int currentBallStatus(){
        int ballStatus = MatchUtils.randomNumberBetweenLtoR(0,6);
        return ballStatus;
    }

    void playInning(Team battingTeam){
        while (battingTeam.getNumberOfWicketsDown()<10 && battingTeam.getNumberOfBallsPlayed()<6*matchData.getNumberOfOvers()){
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

    public void showCurrentBallStatus(int currentBallStatus){
        if(currentBallStatus==-1){
            System.out.print("W ");
        }
        else{
            System.out.print(currentBallStatus+ " ");
        }
    }
}

