package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class CheckoutForm extends AbstractFragment {

	@FindBy(css = ".delivery-text dd")
	WebElement deliveryCost;

	@FindBy(css = ".basket-totals-wrap .total dd")
	WebElement totalCost;

	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement checkoutButtonElement;

	public CheckoutForm(WebDriver driver) {
		super(driver);
	}

	public String getDeliveryCost() {
		return deliveryCost.getText();
	}

	public String getTotalCost() {
		return totalCost.getText();
	}

	public void pressCheckoutButton() {
		jsClick(checkoutButtonElement);
	}

}
