package com.company.CricketGame.util;

public class MatchUtils {
    public static int randomNumberBetweenLtoR(int min, int max){
        min--;
        max++;
        int randomNumber = (int)(Math.random()*(max-min)+min);
        return randomNumber;

    }
}
