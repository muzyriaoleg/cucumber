package com.bookdepository.pages.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.NavigationBar;


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
		setPageUrlPattern(Constants.ACCOUNT_PAGE);
	}

	@Override
	public void open() {
		super.open();
		navigationBar = new NavigationBar(driver);
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
