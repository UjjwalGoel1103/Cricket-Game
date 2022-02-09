package com.company;

import java.util.ArrayList;

public class Team {
    private int number_of_player;
    private int total_score;
    private int number_of_wickets;
    private int number_of_balls;
    private ArrayList<Player> team_players = new ArrayList<>(11);
    Team(){
        number_of_player=11;
        total_score = 0;
        number_of_wickets = 0;
        number_of_balls = 10;

        for(int i=0;i<number_of_player;i++){
            Player p = new Player();
            team_players.add(p);
        }

        set_player_name();
        set_player_age();
        set_player_type();


    void set_player_name(){
        team_players.get(0).setname("Player_1");
        team_players.get(1).setname("Player_2");
        team_players.get(2).setname("Player_3");
        team_players.get(3).setname("Player_4");
        team_players.get(4).setname("Player_5");
        team_players.get(5).setname("Player_6");
        team_players.get(6).setname("Player_7");
        team_players.get(7).setname("Player_8");
        team_players.get(8).setname("Player_9");
        team_players.get(9).setname("Player_10");
        team_players.get(10).setname("Player_11");
    }

    void set_player_age(){
        team_players.get(0).setage(19);
        team_players.get(1).setage(23);
        team_players.get(2).setage(22);
        team_players.get(3).setage(11);
        team_players.get(4).setage(12);
        team_players.get(5).setage(12);
        team_players.get(6).setage(16);
        team_players.get(7).setage(26);
        team_players.get(8).setage(29);
        team_players.get(9).setage(12);
        team_players.get(10).setage(19);
    }

    void set_player_type(){
        team_players.get(0).settype("Batsmen");
        team_players.get(1).settype("Batsmen");
        team_players.get(2).settype("Batsmen");
        team_players.get(3).settype("Batsmen");
        team_players.get(4).settype("All-rounder");
        team_players.get(5).settype("All-rounder");
        team_players.get(6).settype("All-rounder");
        team_players.get(7).settype("Bolwer");
        team_players.get(8).settype("Bowler");
        team_players.get(9).settype("Bowler");
        team_players.get(10).settype("Bowler");
    }
}
