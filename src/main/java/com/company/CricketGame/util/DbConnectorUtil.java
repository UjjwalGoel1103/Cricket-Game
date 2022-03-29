package com.company.CricketGame.util;

import com.company.CricketGame.variables.EnvironmentVariables;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectorUtil {
    public static Connection getConnection() {
        try {
            String driver = EnvironmentVariables.driver ;
            String dataBaseUrl = EnvironmentVariables.dataBaseUrl;
            String username = EnvironmentVariables.username;
            String password = EnvironmentVariables.password;
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(dataBaseUrl, username, password);
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
