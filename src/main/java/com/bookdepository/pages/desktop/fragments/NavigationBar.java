package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import com.bookdepository.pages.desktop.pages.ContactUsPage;
import com.bookdepository.pages.desktop.pages.HomePage;
import com.bookdepository.utils.WebDriverWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractFragment {

    private static final By CONTACT_US_BUTTON = By.cssSelector(".user-nav-wrap  a[href='/contactus']");
    private static final By HOME_BUTTON = By.cssSelector(".user-nav-wrap  .home-icon-link");
    private static final By NAV_BAR = By.cssSelector(".user-nav-wrap");
    private static final By SIGN_OUT_BUTTON = By.cssSelector(".user-nav-wrap a[href='/account']");

    private Button contactUsButton = new Button(CONTACT_US_BUTTON);
    private Button homeButton = new Button(HOME_BUTTON);

    public NavigationBar() {
        super(NAV_BAR);
    }

    public ContactUsPage pressContactUsButton(WebDriver driver) {
        contactUsButton.press();
        return new ContactUsPage(driver);
    }

    public HomePage pressHomeButton(WebDriver driver) {
        homeButton.press();
        return new HomePage(driver);
    }

    public boolean isAccountButtonPresent() {
        try {
            WebDriverWaiter.find(SIGN_OUT_BUTTON);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
