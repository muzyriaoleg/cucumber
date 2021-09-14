package com.bookdepository.db;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.ibatis.jdbc.ScriptRunner;

public class DBService {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DBService() throws SQLException {
        connection = DBConnector.getConnection();
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public void createTableWithSQLFile(String filePath) throws FileNotFoundException {
        Reader reader = new BufferedReader(new FileReader(
            filePath));
        ScriptRunner runner = new ScriptRunner(connection);
        runner.runScript(reader);
    }

    public int countRowsInTable(String tableName) throws SQLException {
        resultSet = statement.executeQuery(String.format(
            "SELECT count(*) "
                + "FROM %s;", tableName));
        resultSet.next();
        return resultSet.getInt("count(*)");
    }

    public void dropTableIfExist(String tableName) throws SQLException {
        resultSet = statement.executeQuery(String.format("SHOW TABLES LIKE '%s';", tableName));
        if (countRowsInResultSet() > 0) {
            statement.executeUpdate(String.format("DROP TABLE %s", tableName));
        }
    }

    public ResultSet select(String sqlQuery) throws SQLException {
        resultSet = statement.executeQuery(sqlQuery);
        resultSet.next();
        return resultSet;
    }

    public int update(String sqlQuery) throws SQLException {
        return statement.executeUpdate(sqlQuery);
    }

    public int countRowsInResultSet() throws SQLException {
        resultSet.last();
        return resultSet.getRow();
    }
}
