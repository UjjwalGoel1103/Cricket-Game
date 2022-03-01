package com.company.controller;

import com.company.services.MatchServiceImpl;
import com.company.services.MatchService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MatchService newMatchService = new MatchServiceImpl("India", "Australia");
    }
}
