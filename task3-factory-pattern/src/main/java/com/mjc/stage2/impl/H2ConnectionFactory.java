package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() throws SQLException {
        try (InputStream input = new FileInputStream("task3-factory-pattern/src/main/resources/h2database.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            String driver = prop.getProperty("jdbc_driver");
            String url = prop.getProperty("db_url");
            String userName = prop.getProperty("user");
            String password = prop.getProperty("password");
            try {
                Class.forName(driver);
                return DriverManager.getConnection(url,userName,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    // Write your code here!
}

