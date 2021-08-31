package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class OrderSummaryWidget extends AbstractFragment {

	@FindBy(xpath = "//div[@class='sidebar right']//strong[contains(text(),'Sub-total')]//parent::dt/following-sibling::dd[@class='text-right']")
	WebElement subTotal;

	@FindBy(xpath = "//div[@class='sidebar right']//strong[contains(text(),'Delivery')]//parent::dt/following-sibling::dd[@class='text-right']/strong")
	WebElement deliveryCost;

	@FindBy(xpath = "//div[@class='sidebar right']//strong[contains(text(),'VAT')]//parent::dt/following-sibling::dd[@class='text-right total-tax']")
	WebElement vatCost;

	@FindBy(xpath = "//div[@class='sidebar right']//dt[@class='total']/following-sibling::dd[@class='text-right total-price']")
	WebElement totalCost;

	public OrderSummaryWidget(WebDriver driver) {
		super(driver);
	}

	public String getOrderSubTotal() {
		return subTotal.getText();
	}

	public String getDeliveryCost() {
		return deliveryCost.getText();
	}

	public String getVATCost() {
		return vatCost.getText();
	}

	public String getTotalCost() {
		return totalCost.getText();
	}
}
