package com.company.CricketGame.repo;

import com.company.CricketGame.bean.TeamBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public class MongoTeamDetailsRepoImpl implements TeamDetailsRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void teamDetailUpdation(TeamBean teamBean) {
        long timestamp = (System.currentTimeMillis());
        teamBean.setCreatedTime(timestamp);
        teamBean.setModifiedTime(timestamp);
        teamBean.setDeleted(false);
        mongoTemplate.save(teamBean, "TeamMatchData");
    }

    @Override
    public TeamBean getTeamIdDetail(int matchId, int teamId) {
        TeamBean teamDetail = new TeamBean();
        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId).and("teamId").is(teamId));
        return mongoTemplate.findOne(query , TeamBean.class , "TeamMatchData");
    }

    @Override
    public boolean checkTeamId(int matchId, int teamId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId).and("teamId").is(teamId));
        TeamBean teamDetail =  mongoTemplate.findOne(query , TeamBean.class , "TeamMatchData");
        if(teamDetail == null)
            return false;
        else
            return true;
    }
}
