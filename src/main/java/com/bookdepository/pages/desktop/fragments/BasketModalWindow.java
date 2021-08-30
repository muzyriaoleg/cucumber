package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class BasketModalWindow extends AbstractFragment {

	@FindBy(css = ".continue-to-basket")
	WebElement basketCheckoutButtonElement;

	@FindBy(css = ".modal-dialog")
	WebElement modalWindowRootElement;

	public void pressButtonBasketCheckout() {
		click(basketCheckoutButtonElement);
	}
}
