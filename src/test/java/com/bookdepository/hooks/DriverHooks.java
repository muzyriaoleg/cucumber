package com.bookdepository.hooks;

import com.bookdepository.constants.Constants;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DriverHooks {
    @Before
    public void setBaseUrl() {
        Configuration.baseUrl = Constants.URL;
    }

    @Before
    public void setBrowser() {
        Configuration.browser = System.getProperty("browser");
    }

    @After()
    public void takeScreenshot() {
        Selenide.screenshot(generateScreenshotFileName());
    }

    private String generateScreenshotFileName() {
        LocalDateTime time = LocalDateTime.now();
        String formattedDateTime = time.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        return "screenshot_" + formattedDateTime;
    }
}
