package com.bookdepository.pages.desktop.pages;

import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.constants.Constants;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        setPageUrl(Constants.URL);
    }
}
