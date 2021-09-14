package com.bookdepository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {

    private static Connection connection;
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/public";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "root";

    private static void setUpDriver() throws SQLException {
        try {
            connection = DriverManager
                .getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            setUpDriver();
        } else if (connection.isClosed()) {
            setUpDriver();
        }
        return connection;
    }

        public static void closeConnection () throws SQLException {
            if (connection != null) {
                connection.close();
            }
        }


    }
