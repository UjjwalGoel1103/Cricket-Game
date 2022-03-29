package com.company.CricketGame.repo;

import com.company.CricketGame.bean.PerBallBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public class MongoPerBallDetailsRepoImpl implements PerBallDetailsRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void perBallDetailUpdation(ArrayList<PerBallBean> perBallStatus) {
        long timestamp = (System.currentTimeMillis());
        for(int i=0;i<perBallStatus.size();i++){

            perBallStatus.get(i).setCreatedTime(timestamp);
            perBallStatus.get(i).setModifiedTime(timestamp);
            perBallStatus.get(i).setDeleted(false);
            mongoTemplate.save(perBallStatus.get(i), "PerBallMatchData");
        }
    }
}
