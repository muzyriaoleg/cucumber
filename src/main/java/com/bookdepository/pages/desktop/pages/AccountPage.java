package com.bookdepository.pages.desktop.pages;

import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.constants.Constants;
import com.bookdepository.pages.desktop.fragments.NavigationBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPage {

    @FindBy(css = "form[name='signIn'] #ap_email")
    WebElement emailInput;

    @FindBy(css = "form[name='signIn'] #ap_password")
    WebElement passwordInput;

    @FindBy(css = "#signInSubmit")
    WebElement signInButton;

    private NavigationBar navigationBar;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageUrl(Constants.URL);
        setPageUrlPattern(Constants.ACCOUNT_PAGE);
        PageFactory.initElements(driver, this);
    }

    public AccountPage open(){
        super.open();
        navigationBar = new NavigationBar();
        return this;
    }

    public void typeUserEmail(String userEmail) {
        driver.switchTo().frame(0);
        emailInput.sendKeys(userEmail);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void signIn(){
        signInButton.click();
    }

    public boolean isMyAccountButtonPresent() {
        return navigationBar.isAccountButtonPresent();

    }
}
