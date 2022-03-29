package com.company.CricketGame.util;

import java.util.Arrays;

public class MatchUtils {
    public static int randomNumberBetweenLtoR(int min, int max){
        min--;
        max++;
        int randomNumber = (int)(Math.random()*(max-min)+min);
        return randomNumber;

    }
    public static Long getPercentile(long responseTime[], int percentile){
        Arrays.sort(responseTime , 0 , responseTime.length);
        Long reqResponseValue = (long) responseTime[(int) (( percentile * responseTime.length) / 100)];
        return reqResponseValue;
    }
}
