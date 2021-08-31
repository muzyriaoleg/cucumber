package com.bookdepository.pages.desktop.pages;

import org.openqa.selenium.WebDriver;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;


public class ContactUsPage extends AbstractPage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		setPageUrlPattern(Constants.CONTACT_US_PAGE_URL_PATTERN);
	}
}
