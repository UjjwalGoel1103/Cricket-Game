package com.company.repo;

import com.company.dto.MatchDto;

import java.sql.ResultSet;

public interface DatabaseService {

    ResultSet getQueryFromDb(String query);

    void updateQueryToDb(String query);
}
