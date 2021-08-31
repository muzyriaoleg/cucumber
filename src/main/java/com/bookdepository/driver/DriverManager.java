package com.bookdepository.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

	public WebDriver createDriver() {
		String browser = System.getProperty("browser");
		switch (browser) {
			case "Chrome":
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				return new ChromeDriver();
			case "Firefox":
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				return new FirefoxDriver();
			default:
				throw new IllegalStateException("This driver is not supported");
		}
	}
}
