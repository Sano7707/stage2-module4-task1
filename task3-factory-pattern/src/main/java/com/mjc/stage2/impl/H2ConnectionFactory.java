package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    private Connection con;
    @Override
    public Connection createConnection() throws SQLException {

        try {
            Properties prop = new Properties();
            prop.load(
                    H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties")
            );

            String driver = prop.getProperty("jdbc_driver");
            String url = prop.getProperty("db_url");
            String userName = prop.getProperty("user");
            String password = prop.getProperty("password");
            System.out.println(url);
            System.out.println(userName);

            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, userName, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            return con;
    }

        // Write your code here!

        public static void main (String[]args) throws SQLException {
            H2ConnectionFactory h2 = new H2ConnectionFactory();
            h2.createConnection();
        }
    }


