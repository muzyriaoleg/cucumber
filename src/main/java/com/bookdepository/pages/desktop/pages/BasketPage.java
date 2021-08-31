package com.bookdepository.pages.desktop.pages;

import org.openqa.selenium.WebDriver;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.CheckoutForm;


public class BasketPage extends AbstractPage {

	CheckoutForm checkoutForm = new CheckoutForm(driver);

	public BasketPage(WebDriver driver) {
		super(driver);
		setPageUrlPattern(Constants.BASKET_PAGE_URL_PATTERN);
	}

	public String getDeliveryCost() {
		return checkoutForm.getDeliveryCost();
	}

	public String getTotalCost() {
		return checkoutForm.getTotalCost();
	}

	public void checkout() {
		checkoutForm.pressCheckoutButton();
	}
}
