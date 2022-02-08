package com.company;

import java.util.ArrayList;

public class Match {
    int number_of_overs;
    Team team1 = new Team();
    Team team2 = new Team();

    Match(){
        System.out.println("DONe");
    }

    void start_match(){

        int winner_of_toss = toss();
        if(winner_of_toss==1)
        {
            play_inning(1);
            play_inning(2);
        }
        else
        {
            play_inning(2);
            play_inning(1);
        }
    }

    void show_final_result(){
        System.out.println("result");
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

    }
}
