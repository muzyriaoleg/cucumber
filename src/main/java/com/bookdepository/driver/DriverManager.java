package com.bookdepository.driver;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriverInstance() {
		if (driver.get() == null) {
			createDriver();
			setupDriver();
		}
		return driver.get();
	}

	private void WebDriver() {
	}

	private static void createDriver() {
		String browser = System.getProperty("browser");
		switch (browser) {
			case "Chrome":
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				driver.set(new ChromeDriver());
				break;
			case "Firefox":
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				driver.set(new FirefoxDriver());
				break;
			default:
				throw new IllegalStateException("This driver is not supported");
		}
	}

	private static void setupDriver() {
		driver.get().manage().window().maximize();
	}

	public static void quitDriver() {
		Optional.ofNullable(getDriverInstance()).ifPresent(driver -> DriverManager.driver.get().quit());
	}

	public static void clearCookies() {
		driver.get().manage().deleteAllCookies();
	}
}
