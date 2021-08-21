package com.bookdepository.driver;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverManager {

	private static WebDriver driver;
	private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

	public static WebDriver getChromedDriverInstance() {
		return driver;
	}

	public static void setupDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		webDriverThreadLocal.set(driver);
	}

	public static void quitDriver() {
		Optional.ofNullable(getChromedDriverInstance()).ifPresent(driver -> DriverManager.driver.quit());
	}

	public static void clearCookies() {
		driver.manage().deleteAllCookies();
	}
}
