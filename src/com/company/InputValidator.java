package com.company;

import com.company.enums.MatchType;

public class InputValidator {
    public static boolean validateMatchType(String matchTypeByUser){
        if(matchTypeByUser.equals("T20")){
            return true;
        }
        else if(matchTypeByUser.equals("FIVE_OVER")){
            return true;
        }
        else if(matchTypeByUser.equals("FIFTY_OVER") ){
            return true;
        }
        else{
            return false;
        }
    }
}
