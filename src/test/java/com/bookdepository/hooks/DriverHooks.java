package com.bookdepository.hooks;

import com.bookdepository.db.DBConnector;
import com.bookdepository.driver.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.sql.SQLException;


public class DriverHooks {
	@Before
	public void setupDriver() {
		DriverManager.getDriverInstance();
	}

	@After
	public void quitDriver() throws SQLException {
		DriverManager.quitDriver();
		DBConnector.closeConnection();
	}
}
