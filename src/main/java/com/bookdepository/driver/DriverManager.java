package com.bookdepository.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

	public WebDriver createDriver() {
		String browser = System.getProperty("browser");
		switch (browser.toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				return new ChromeDriver();
			case "FIREFOX":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				return new FirefoxDriver();
			default:
				throw new IllegalStateException("This driver is not supported");
		}
	}
}
