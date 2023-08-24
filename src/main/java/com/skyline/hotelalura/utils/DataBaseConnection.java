package com.skyline.hotelalura.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    private static BasicDataSource pool;

    private static void initializePool() {
        if (pool == null) {
            Properties properties = new Properties();

            try (InputStream inputStream = DataBaseConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
                properties.load(inputStream);

                String url = properties.getProperty("db.url");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");

                int initialSize = Integer.parseInt(properties.getProperty("db.initialSize"));
                int minIdle = Integer.parseInt(properties.getProperty("db.minIdle"));
                int maxIdle = Integer.parseInt(properties.getProperty("db.maxIdle"));
                int maxTotal = Integer.parseInt(properties.getProperty("db.maxTotal"));

                pool = new BasicDataSource();
                pool.setUrl(url);
                pool.setUsername(user);
                pool.setPassword(password);
                pool.setInitialSize(initialSize);
                pool.setMinIdle(minIdle);
                pool.setMaxIdle(maxIdle);
                pool.setMaxTotal(maxTotal);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static BasicDataSource getInstance() {
        if (pool == null) {
            initializePool();
        }

        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
