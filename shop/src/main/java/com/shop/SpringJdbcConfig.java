package com.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class SpringJdbcConfig {
    public static synchronized Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            Locale.setDefault(Locale.ENGLISH);
        } catch (ClassNotFoundException e) {
        }
        return DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/shop_db",
                "postgres",
                "123456"
                );
    }
}
