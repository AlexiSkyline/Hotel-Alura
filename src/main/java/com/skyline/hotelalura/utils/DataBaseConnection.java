package com.skyline.hotelalura.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_alura?useTimezone=true&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";
    private static BasicDataSource pool;

    private static BasicDataSource getInstance() {
        if( pool == null ) {
            pool = new BasicDataSource();
            pool.setUrl( url );
            pool.setUsername( user );
            pool.setPassword( password );
            pool.setInitialSize( 3 );
            pool.setMinIdle( 3 );
            pool.setMaxIdle( 8 );
            pool.setMaxTotal( 8 );
        }

        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
