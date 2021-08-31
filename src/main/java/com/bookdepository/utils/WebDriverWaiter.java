package com.bookdepository.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookdepository.driver.DriverManager;


public class WebDriverWaiter {

    public static final int TIME_OUT = 10;
    private static WebDriverWait driverWait;
    public static WebDriverWait driverWait(WebDriver driver) {
        if (driverWait == null) {
            driverWait = new WebDriverWait(driver, TIME_OUT);
            return driverWait;
        }
        return driverWait;
    }
}
