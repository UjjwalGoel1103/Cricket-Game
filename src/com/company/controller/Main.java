package com.company.controller;

import com.company.services.MatchImpls;
import com.company.services.MatchService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MatchService newMatchService = new MatchImpls("India", "Australia");
    }
}
