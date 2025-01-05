package com.company;

public class ScoreBoard {
    Team team1 ;
    Team team2 ;
    ScoreBoard(Team team1, Team team2){
        this.team1=team1;
        this.team2=team2;
    }

    void showLiveScore(){
        //todo first get the current playing team

        System.out.println(team1.getTeamName() + "     "+team1.getTotalScore() + "-" +
                team1.getNumberOfWicketsDown() + "(" + team1.getNumberOfBallsPlayed()/6 + "." +
                team1.getNumberOfBallsPlayed()%6 + ")");
        System.out.println(team2.getTeamName() + "     "+team2.getTotalScore() + "-" +
                team2.getNumberOfWicketsDown() + "(" + team2.getNumberOfBallsPlayed()/6 + "." +
                team2.getNumberOfBallsPlayed()%6 + ")");

    }

    void showFinalResult(){
        System.out.println(team1.getTeamName() + "     "+team1.getTotalScore() + "-" +
                team1.getNumberOfWicketsDown() + "(" + team1.getNumberOfBallsPlayed()/6 + "." +
                team1.getNumberOfBallsPlayed()%6 + ")");
        System.out.println(team2.getTeamName() + "     "+team2.getTotalScore() + "-" +
                team2.getNumberOfWicketsDown() + "(" + team2.getNumberOfBallsPlayed()/6 + "." +
                team2.getNumberOfBallsPlayed()%6 + ")");

        if(team1.getTotalScore() > team2.getTotalScore()){
            System.out.println(team1.getTeamName() + " beats " + team2.getTeamName() +  " by " + (team1.getTotalScore()- team2.getTotalScore())
            + " runs.");
        }
        else if(team2.getTotalScore() > team1.getTotalScore()){
            System.out.println(team2.getTeamName() + " beats " + team1.getTeamName() +  " by " + (team2.getTotalScore()- team1.getTotalScore())
                    + " runs.");
        }
        else {
            System.out.println("Match Draws as both team scores "+ team1.getTotalScore());
        }
    }

    void showTeam1ScoreCard(){
        System.out.println("Team "+team1.getTeamName()+" Total Score is : "+team1.getTotalScore());
        System.out.println("Number of over Played "+team1.getNumberOfBallsPlayed()/6+"."+team1.getNumberOfBallsPlayed()%6);
        System.out.println("Number of wickets fallen "+team1.getNumberOfWicketsDown());
        //printing the score card for each player
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate"+team1.getNumberOfWicketsDown());
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            if(team1.getIthPlayerBalls(i)!=0) {
                System.out.println(team1.getIthPlayerName(i) + "      " + team1.getIthPlayerScore(i) + "         " +
                        team1.getIthPlayerScore(i) / team1.getIthPlayerBalls(i));
            }
            else{
                System.out.println(team1.getIthPlayerName(i) + "    -----------------------------  " );
            }
        }
    }

    void showTeam2ScoreCard(){
        System.out.println("Team "+team2.getTeamName()+" Total Score is : "+team2.getTotalScore());
        System.out.println("Number of over Played "+team2.getNumberOfBallsPlayed()/6+"."+team2.getNumberOfBallsPlayed()%6);
        System.out.println("Number of wickets fallen "+team2.getNumberOfWicketsDown());
        //printing the score card for each player
        System.out.println();
        System.out.println("Player Name        Runs Scored      Strike Rate"+team2.getNumberOfWicketsDown());
        for(int i=0;i<Constants.NO_OF_PLAYER;i++){
            if(team2.getIthPlayerBalls(i)!=0) {
                System.out.println(team2.getIthPlayerName(i) + "      " + team2.getIthPlayerScore(i) + "         " +
                        team2.getIthPlayerScore(i) / team2.getIthPlayerBalls(i));
            }
            else{
                System.out.println(team2.getIthPlayerName(i) + "    -----------------------------  " );
            }
        }
    }
}
