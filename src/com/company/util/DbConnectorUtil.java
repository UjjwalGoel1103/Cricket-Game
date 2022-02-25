package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectorUtil {
    public static Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String dataBaseUrl = "jdbc:mysql://localhost:3306/cricketData";
            String username = "root";
            String password = "password";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(dataBaseUrl, username, password);
            System.out.println("Database connected successfully");
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
