package com.bookdepository.pages.desktop;

import org.openqa.selenium.WebDriver;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.pages.*;


public class PageFactory {

	private HomePage homePage;
	private SearchResultPage searchResultPage;
	private BasketPage basketPage;
	private CheckoutPage checkoutPage;
	private AccountPage accountPage;
	private WelcomePage welcomePage;

	public AbstractPage createPage(String pageName, WebDriver driver) {
		if (pageName.equalsIgnoreCase(Constants.HOME_PAGE_NAME)) {
			if (homePage == null) {
				homePage = new HomePage(driver);
			}
			return homePage;
		}
		if (pageName.equalsIgnoreCase(Constants.CHECKOUT_PAGE_NAME)) {
			if (checkoutPage == null) {
				checkoutPage = new CheckoutPage(driver);
			}
			return checkoutPage;
		}
		if (pageName.equalsIgnoreCase(Constants.BASKET_PAGE_NAME)) {
			if (basketPage == null) {
				basketPage = new BasketPage(driver);
			}
			return basketPage;
		}
		if (pageName.equalsIgnoreCase(Constants.SEARCH_RESULT_PAGE_NAME)) {
			if (searchResultPage == null) {
				searchResultPage = new SearchResultPage(driver);
			}
			return searchResultPage;
		}
		if (pageName.equalsIgnoreCase(Constants.WELCOME_PAGE_NAME)) {
			if (welcomePage == null) {
				welcomePage = new WelcomePage(driver);
			}
			return welcomePage;
		}
		if (pageName.equalsIgnoreCase(Constants.ACCOUNT_PAGE_NAME)) {
			if (accountPage == null) {
				accountPage = new AccountPage(driver);
			}
			return accountPage;
		}

		else {
			throw new IllegalStateException("Cannot create specified page");
		}
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public SearchResultPage getSearchResultPage() {
		return searchResultPage;
	}

	public BasketPage getBasketPage() {
		return basketPage;
	}

	public CheckoutPage getCheckoutPage() {
		return checkoutPage;
	}

	public AccountPage getAccountPage() {
		return accountPage;
	}
}
