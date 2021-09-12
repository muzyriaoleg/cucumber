package com.bookdepository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

    private static Connection connection;

    private static void setUpDriver() {
        try {
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/public", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        setUpDriver();
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }


}
