package com.company.CricketGame.repo;

import com.company.CricketGame.dto.MatchDto;

import java.sql.ResultSet;

public interface DatabaseService {

    ResultSet getQueryFromDb(String query);

    void updateQueryToDb(String query);
}
