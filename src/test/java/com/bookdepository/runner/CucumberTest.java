package com.bookdepository.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-reports/CucumberTest.html", "json:target/cucumber-reports/CucumberTest.json" },
        monochrome = true,
        tags = "@Regression",
        glue = "com.bookdepository",
        features = "src/test/resources/com.cucumber.junit.features"
)
public class CucumberTest {
}
