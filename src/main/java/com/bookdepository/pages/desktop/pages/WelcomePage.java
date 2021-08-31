package com.bookdepository.pages.desktop.pages;

import org.openqa.selenium.WebDriver;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;


public class WelcomePage extends AbstractPage {

	public WelcomePage(WebDriver driver) {
		super(driver);
		setPageUrlPattern(Constants.WELCOME_PAGE_URL_PATTERN);
	}
}
