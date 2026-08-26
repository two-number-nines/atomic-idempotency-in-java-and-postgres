package com.mycompany.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConfig {

    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private Properties props = new Properties();

    public DatabaseConfig() {
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
    }

    public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, props);
    }
}
