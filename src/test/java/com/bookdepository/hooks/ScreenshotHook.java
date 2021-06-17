package com.bookdepository.hooks;

import com.bookdepository.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotHook {

    public static final String PNG_FILE_EXTENSION = "image/png";

    @After
    public void takeScreenshot(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getChromedDriverInstance()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, PNG_FILE_EXTENSION, scenario.getName());
    }
}
