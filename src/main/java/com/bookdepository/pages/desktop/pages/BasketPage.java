package com.bookdepository.pages.desktop.pages;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.CheckoutForm;


public class BasketPage extends AbstractPage {

	public CheckoutForm checkoutForm = new CheckoutForm();

	public BasketPage() {
		super();
		setPageUrlPattern(Constants.BASKET_PAGE_URL_PATTERN);
	}
}
