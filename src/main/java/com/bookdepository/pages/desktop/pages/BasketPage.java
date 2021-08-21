package com.bookdepository.pages.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.CheckoutForm;
import com.bookdepository.utils.WebDriverWaiter;


public class BasketPage extends AbstractPage {

	@FindBy(css = ".basket-page")
	WebElement basketPageBaseElement;

	CheckoutForm checkoutForm = new CheckoutForm(driver);

	public BasketPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isOpened() {
		return WebDriverWaiter.driverWait().until(ExpectedConditions.visibilityOf(basketPageBaseElement)).isDisplayed();
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
