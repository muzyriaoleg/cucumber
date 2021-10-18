package com.bookdepository.pages.desktop.pages;

import com.bookdepository.pages.desktop.fragments.Button;
import com.bookdepository.pages.desktop.fragments.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;


public class AccountPage extends AbstractPage {

	public Input emailInput = new Input(By.cssSelector("form[name='signIn'] #ap_email"));

	public Input passwordInput = new Input(By.cssSelector("form[name='signIn'] #ap_password"));

	public Button signInButton = new Button(By.cssSelector("#signInSubmit"));

	public Button myAccountButton = new Button(By.cssSelector("a[href=\"/account\"]"));

	public AccountPage() {
		super();
		setPageUrlPattern(Constants.ACCOUNT_PAGE_URL_PATTERN);
	}
}
