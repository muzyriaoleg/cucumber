package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.driver.DriverManager;
import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import com.bookdepository.utils.WebElementUtils;


public class CheckoutForm extends AbstractFragment {

	@FindBy(css = ".delivery-text dd")
	WebElement deliveryCost;

	@FindBy(css = ".basket-totals-wrap .total dd")
	WebElement totalCost;

	@FindBy(css = "a[href='/payments/checkout']")
	WebElement checkoutButtonElement;

	public CheckoutForm(WebDriver driver) {
		super(driver);
	}

	public String getDeliveryCost() {
		return WebElementUtils.getTextContentFromElement(DriverManager.getChromedDriverInstance(), deliveryCost);
	}

	public String getTotalCost() {
		return WebElementUtils.getTextContentFromElement(DriverManager.getChromedDriverInstance(), totalCost);
	}

	public void pressCheckoutButton() {
		jsClick(checkoutButtonElement);
	}

}
