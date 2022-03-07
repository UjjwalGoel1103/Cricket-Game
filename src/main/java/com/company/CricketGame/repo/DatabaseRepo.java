package com.company.CricketGame.repo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Repository
public interface DatabaseRepo {

    ResultSet getQueryFromDb(String query);

    void updateQueryToDb(String query);
}
