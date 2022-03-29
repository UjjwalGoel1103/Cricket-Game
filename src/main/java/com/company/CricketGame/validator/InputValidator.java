package com.company.CricketGame.validator;

import com.company.CricketGame.enums.BattingOrBowlingType;
import com.company.CricketGame.enums.MatchType;

public class InputValidator {
    public static boolean validateMatchType(String matchTypeByUser){
        try {
            MatchType checkMatchType = MatchType.valueOf(matchTypeByUser) ;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static boolean validateBattingOrBowlingType(String battingOrBowlingTypeByUser){
        try {
            BattingOrBowlingType checkBattingOrBowlingType = BattingOrBowlingType.valueOf(battingOrBowlingTypeByUser) ;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
