package com.bookdepository.pages.desktop.fragments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class PaymentForm extends AbstractFragment {

	@FindBy(xpath = "//label[@for='visacardNumber']/../..//span[@class='grid_12 notification custom_notification hide']")
	WebElement creditCardNumberValidationError;

	@FindBy(xpath = "//label[@for='visacardName']/../..//span[@class='grid_12 notification custom_notification hide']")
	WebElement creditCardNameValidationError;

	@FindBy(xpath = "//label[@for='visacardCvv']/../..//span[@class='grid_12 notification custom_notification hide']")
	WebElement creditCardCVVValidationError;

	@FindBy(css = "#submitButton")
	WebElement buyNowButton;

	@FindBy(css = "#brandSelected")
	WebElement cardTypeSelectElement;

	@FindBy(css = "#visacardNumber")
	WebElement cardNumberInput;

	@FindBy(css = "#visacardValidToMonth")
	WebElement validToMonthSelectElement;

	@FindBy(css = "#visacardValidToYear")
	WebElement validToYearSelectElement;

	@FindBy(css = "#visacardName")
	WebElement cardNameInput;

	@FindBy(css = "#visacardCvv")
	WebElement cardCVVInput;

	public List<String> getValidationErrorList() {
		List<String> errorList = new ArrayList<>();
		errorList.add(creditCardNumberValidationError.getText());
		errorList.add(creditCardNameValidationError.getText());
		errorList.add(creditCardCVVValidationError.getText());
		return errorList;
	}

	public void pressBuyNowButton() {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='chase']")));
		jsClick(buyNowButton);
	}

	public void chooseCardType(String cardType) {
		Select cardTypeSelect = new Select(cardTypeSelectElement);
		cardTypeSelect.selectByVisibleText(cardType);
	}

	public void typeCardNumber(String cardNumber) {
		cardNumberInput.sendKeys(cardNumber);
	}

	public void selectValidToMonth(String month) {
		Select validToMonthSelect = new Select(validToMonthSelectElement);
		validToMonthSelect.selectByVisibleText(month);
	}

	public void selectValidToYear(String year) {
		Select validToYearSelect = new Select(validToYearSelectElement);
		validToYearSelect.selectByVisibleText(year);
	}

	public void typeCardName(String cardName) {
		cardNameInput.sendKeys(cardName);
	}

	public void typeCardCVV(String cvv) {
		cardCVVInput.sendKeys(cvv);
	}

}
