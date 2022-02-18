package com.company.validator;

import com.company.dto.MatchDto;
import com.company.enums.BattingOrBowlingType;
import com.company.enums.MatchType;

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
