package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection()  {
        Connection con = null;
        Properties prop = new Properties();
        String driver = prop.getProperty("jdbc_driver");
        String dbUrl = prop.getProperty("db_url");
        String userName = prop.getProperty("user");
        String password = prop.getProperty("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(dbUrl,userName,password);
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return con;
    }
    // Write your code here!
}

