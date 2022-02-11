package com.company;

import com.company.enums.MatchType;

public class InputValidator {
    private boolean validateMatchType(MatchType matchTypeByUser){
        if(matchTypeByUser!=MatchType.T20 && matchTypeByUser!=MatchType.FIVE_OVER && matchTypeByUser!=MatchType.FIFTY_OVER ){
            return false;
        }
        else{
            return true;
        }
    }
}
