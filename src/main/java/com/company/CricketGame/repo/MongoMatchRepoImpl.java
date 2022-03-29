package com.company.CricketGame.repo;

import com.company.CricketGame.bean.MatchBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

@Profile("MongoTypeDB")
@Repository
public class MongoMatchRepoImpl implements MatchRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void matchDetailUpdation(MatchBean matchBean) {
        long timestamp = (System.currentTimeMillis());
        matchBean.setCreatedTime(timestamp);
        matchBean.setModifiedTime(timestamp);
        matchBean.setDeleted(false);
        mongoTemplate.save(matchBean, "MatchData");
    }

    @Override
    public MatchBean getMatchIdInfo(int matchId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId));
        return mongoTemplate.findOne(query , MatchBean.class , "MatchData");
    }

    @Override
    public boolean checkMatchId(int matchId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId));
        MatchBean matchDetail =  mongoTemplate.findOne(query , MatchBean.class , "MatchData");
        if(matchDetail == null)
            return false;
        else
            return true;
    }

    @Override
    public int getNewMatchId() {
        int matchId = 0;
        Query query = new Query();
        query.addCriteria(Criteria.where("matchId").is(matchId));
        MatchBean matchDetail =  mongoTemplate.findOne(query , MatchBean.class , "MatchData");
        matchId++;
        return matchId;

    }
}
