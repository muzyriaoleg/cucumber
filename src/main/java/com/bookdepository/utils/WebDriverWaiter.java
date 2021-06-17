package com.bookdepository.utils;

import com.bookdepository.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaiter {

    public static WebElement find(By by) {
        return new WebDriverWait(DriverManager.getChromedDriverInstance(), 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
