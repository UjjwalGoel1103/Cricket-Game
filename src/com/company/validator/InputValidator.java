package com.company.validator;

import com.company.enums.MatchType;

public class InputValidator {
    public static boolean validateMatchType(String matchTypeByUser){
        try {
            Enum checkMatchType = MatchType.valueOf(matchTypeByUser) ;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
