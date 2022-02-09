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
                play_inning(1);
                play_inning(2);
            }
            else{
                play_inning(2);
                play_inning(1);
            }
        }
        else
        {
            if(winner_choice==1){
                play_inning(2);
                play_inning(1);
            }
            else{
                play_inning(1);
                play_inning(2);
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

    int play_current_ball(){
        int ball_status = (int)(Math.random()*(6-(-1)+1)+(-1));
        return ball_status;
    }

    void play_inning(int team_id){
        if(team_id==1){

        }
        //while (team1.getnumber_of_wickets<10 && number_);
    }
}
