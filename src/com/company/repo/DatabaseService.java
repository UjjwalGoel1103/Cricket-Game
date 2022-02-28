package com.company.repo;

import com.company.bean.MatchBean;
import com.company.bean.PerBallBean;
import com.company.bean.PlayerBean;
import com.company.bean.TeamBean;
import com.company.dto.MatchDto;
import com.company.services.UpdateMatchDetails;
import com.company.util.DbConnectorUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DatabaseService {

    void updateBeans(MatchDto matchInfo);

    void insertMatchDetailsInDb(MatchDto matchInfo);

    void insertPlayerDetailsInDb(MatchDto matchInfo);

    void insertTeamDetailsInDb(MatchDto matchInfo);

    void insertPerBallDetailsInDb(MatchDto matchInfo);

    ResultSet getQueryFromDb(String query);

    void updateQueryToDb(String query);
}
