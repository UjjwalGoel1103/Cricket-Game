package com.company;

import java.util.ArrayList;

public class Team {
    int number_of_player;
    int total_score;
    int number_of_wickets;
    double number_of_balls;
    ArrayList<Player> team_players = new ArrayList<>(11);
    Team(){
        number_of_player=11;
        total_score = 0;
        number_of_wickets = 0;
        number_of_balls = 10;

        for(int i=0;i<11;i++){
            Player p = new Player();
            team_players.add(p);
        }


                /*String name;
    int age;
    String type;
    int score;
    int wickets_taken;
    int number_of_balls_played;*/
    }
}
