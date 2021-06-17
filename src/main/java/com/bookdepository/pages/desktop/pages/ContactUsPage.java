package com.bookdepository.pages.desktop.pages;

import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.constants.Constants;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends AbstractPage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
        setPageUrl(Constants.URL);
        setPageUrlPattern(Constants.CONTACT_US_PAGE);
    }
}
