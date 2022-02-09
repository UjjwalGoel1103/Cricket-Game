package com.company;

import java.util.ArrayList;

public class Team {
    private int NumberOfPlayer;
    private int TotalScore;
    private int NumberOfWicketsDown;
    private int NumberOfBallsPlayed;
    private ArrayList<Player> TeamPlayers = new ArrayList<>(11);
    Team(){
        NumberOfPlayer=11;
        TotalScore = 0;
        NumberOfWicketsDown = 0;
        NumberOfBallsPlayed = 10;

        for(int i=0;i<NumberOfPlayer;i++){
            Player p = new Player();
            TeamPlayers.add(p);
        }

        //set_player_name();
        //set_player_age();
        //set_player_type();

    }

    void setNumberOfPlayer(int NumberOfPlayer){
        this.NumberOfPlayer=NumberOfPlayer;
    }

    int getNumberOfPlayer(){
        return this.NumberOfPlayer;
    }

    void setTotalScore(int TotalScore){
        this.TotalScore=TotalScore;
    }

    int getTotalScore(){
        return this.TotalScore;
    }

    void setNumberOfWicketsDown(int NumberOfWicketsDown){
        this.NumberOfWicketsDown=NumberOfWicketsDown;
    }

    int getNumberOfWicketsDown(){
        return this.NumberOfWicketsDown;
    }

    void setNumberOfBallsPlayed(int NumberOfBallsPlayed){
        this.NumberOfBallsPlayed=NumberOfBallsPlayed;
    }

    int getNumberOfBallsPlayed(){
        return this.NumberOfBallsPlayed;
    }

    void PlayCurrentBall(int CurrentBallStatus){
        this.NumberOfBallsPlayed+=1;
        if(CurrentBallStatus==-1){
            this.NumberOfWicketsDown+=1;
        }
        else if(CurrentBallStatus==0){
            return ;
        }
        else if(CurrentBallStatus==1){
            this.TotalScore += 1;
            TeamPlayers.get(NumberOfWicketsDown).PlayerScoreOne();
        }
        else if(CurrentBallStatus==2){
            this.TotalScore += 2;
            TeamPlayers.get(NumberOfWicketsDown).PlayerScoreTwo();
        }
        else if(CurrentBallStatus==3){
            this.TotalScore += 3;
            TeamPlayers.get(NumberOfWicketsDown).PlayerScoreThree();
        }
        else if(CurrentBallStatus==4){
            this.TotalScore += 4;
            TeamPlayers.get(NumberOfWicketsDown).PlayerScoreFour();
        }
        else if(CurrentBallStatus==5){
            this.TotalScore += 5;
            TeamPlayers.get(NumberOfWicketsDown).PlayerScoreFive();
        }
        else if(CurrentBallStatus==6){
            this.TotalScore += 6;
            TeamPlayers.get(NumberOfWicketsDown).PlayerScoreSix();
        }
    }




   /* void set_player_name(){
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
    }*/
}
