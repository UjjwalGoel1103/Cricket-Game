package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Match {
    int number_of_overs;
    Team team1 = new Team();
    Team team2 = new Team();

    Scanner sc = new Scanner(System.in);

    Match(){
        System.out.println("Starting A New Match");
        System.out.println("Which Format Match you want : T20 / 50-50 ");
        String type = sc.nextLine();
        if(type=="T20")
            number_of_overs = 20;
        else
            number_of_overs = 50;
    }

    void start_match(){

        int winner_of_toss = toss();
        int winner_choice = 1;
        if(winner_of_toss==1 )
        {
            if(winner_choice==1){
                play_inning(team1);
                play_inning(team2);
            }
            else{
                play_inning(team2);
                play_inning(team1);
            }
        }
        else
        {
            if(winner_choice==1){
                play_inning(team2);
                play_inning(team1);
            }
            else{
                play_inning(team1);
                play_inning(team2);
            }
        }

    }

    void show_final_result(){
        System.out.println("in show final result");
    }

    int toss(){
        int winner_of_toss = (int)(Math.random()*(2-1+1)+1);    // (int)(Math.random()*(max-min+1)+min);
        return winner_of_toss;
    }

    int CurrentBallStatus(){
        int BallStatus = (int)(Math.random()*(6-(-1)+1)+(-1));
        return BallStatus;
    }

    void play_inning(Team BattingTeam){
        while (BattingTeam.getNumberOfWicketsDown()<10 && BattingTeam.getNumberOfBallsPlayed()<6*number_of_overs){
            int CurrentBallStatus = CurrentBallStatus();
            BattingTeam.PlayCurrentBall(CurrentBallStatus);
        }
    }
}
