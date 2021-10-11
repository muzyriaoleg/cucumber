package com.bookdepository.hooks;

import com.bookdepository.driver.DriverManager;

import com.bookdepository.utils.WebDriverWaiter;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class DriverHooks {
	@Before
	public void setupDriver() {
		DriverManager.getDriverInstance();
	}

	@After(order = 1)
	public void quitDriver() {
		DriverManager.quitDriver();
	}

	@After(order = 2)
	public void clearWater() {
		WebDriverWaiter.clearWaiter();
	}
}
