package com.bookdepository.utils;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookdepository.driver.DriverManager;


public class WebDriverWaiter {

    public static final int TIME_OUT = 10;
    private static WebDriverWait driverWait;
    public static WebDriverWait driverWait() {
        if (driverWait == null) {
            return new WebDriverWait(DriverManager.getChromedDriverInstance(), TIME_OUT);
        }
        return driverWait;
    }

}
