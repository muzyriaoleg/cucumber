package com.bookdepository.pages.desktop.pages;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;


public class WelcomePage extends AbstractPage {

	public WelcomePage() {
		setPageUrlPattern(Constants.WELCOME_PAGE_URL_PATTERN);
	}
}
