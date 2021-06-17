package com.bookdepository.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

public class DriverManager {

    private static WebDriver driver;
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getChromedDriverInstance() {
        return driver;
    }

    public static void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverThreadLocal.set(driver);
    }

    public static void quitDriver() {
        Optional.ofNullable(getChromedDriverInstance()).ifPresent(driver -> {
            DriverManager.driver.quit();

        });

    }
}
