package com.bookdepository.driver;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
//
//	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//	public static WebDriver getDriverInstance() {
//		if (driver.get() == null) {
//			createDriver();
//			setupDriver();
//		}
//		return driver.get();
//	}
//
//	private void WebDriver() {
//	}
//
//	private static void createDriver() {
//		String browser = System.getProperty("browser");
//		switch (browser.toUpperCase()) {
//			case "CHROME":
//				System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
//				driver.set(new ChromeDriver());
//				break;
//			case "FIREFOX":
//				System.setProperty("webdriver.gecko.driver", getFirefoxDriverPath());
//				driver.set(new FirefoxDriver());
//				break;
//			default:
//				throw new IllegalStateException("This driver is not supported");
//		}
//	}
//
//	private static void setupDriver() {
//		driver.get().manage().window().maximize();
//	}
//
//	public static void quitDriver() {
//		driver.get().quit();
//	}
//
//	public static void clearCookies() {
//		driver.get().manage().deleteAllCookies();
//	}
//
//	private static String getChromeDriverPath() {
//		String os = System.getProperty("os.name");
//		switch (os) {
//			case "Mac OS X":
//				return "src/test/resources/drivers/chromedriver";
//			case "Windows 10":
//				return "src/test/resources/drivers/chromedriver.exe";
//			default:
//				throw new IllegalStateException("This OS is not supported");
//		}
//	}
//
//	private static String getFirefoxDriverPath() {
//		String os = System.getProperty("os.name");
//		switch (os) {
//			case "Mac OS X":
//				return "src/test/resources/drivers/geckodriver";
//			case "Windows 10":
//				return "src/test/resources/drivers/geckodriver.exe";
//			default:
//				throw new IllegalStateException("This OS is not supported");
//		}
//	}

}
