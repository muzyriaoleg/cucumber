package com.bookdepository.pages.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;


public class AccountPage extends AbstractPage {

	@FindBy(css = "form[name='signIn'] #ap_email")
	WebElement emailInput;

	@FindBy(css = "form[name='signIn'] #ap_password")
	WebElement passwordInput;

	@FindBy(css = "#signInSubmit")
	WebElement signInButton;

	public AccountPage(WebDriver driver) {
		super(driver);
		setPageUrlPattern(Constants.ACCOUNT_PAGE_URL_PATTERN);
	}

	public void typeUserEmail(String userEmail) {
		driver.switchTo().frame(0);
		emailInput.sendKeys(userEmail);
	}

	public void typePassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void signIn() {
		signInButton.click();
	}

}
