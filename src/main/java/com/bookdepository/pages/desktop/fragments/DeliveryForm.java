package com.bookdepository.pages.desktop.fragments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import com.bookdepository.utils.WebElementUtils;


public class DeliveryForm extends AbstractFragment {

	@FindBy(css = "button[name='buyNow']")
	WebElement buyNowButton;

	@FindBy(xpath = "//input[@name='emailAddress']/../div[@class='error-block']")
	WebElement emailInputValidationError;

	@FindBy(xpath = "//input[@name='delivery-fullName']/../div[@class='error-block']")
	WebElement deliveryFullNameValidationError;

	@FindBy(xpath = "//input[@name='delivery-addressLine1']/../div[@class='error-block']")
	WebElement addressLine1ValidationError;

	@FindBy(xpath = "//input[@name='delivery-city']/../div[@class='error-block']")
	WebElement deliveryCityValidationError;

	@FindBy(xpath = "//input[@name='delivery-postCode']/../div[@class='error-block']")
	WebElement deliveryPostCodeValidationError;

	@FindBy(css = "input[name='emailAddress']")
	WebElement emailInput;

	@FindBy(css = "input[name='delivery-fullName']")
	WebElement fullNameInput;

	@FindBy(css = "#deliveryCountryDropdown")
	WebElement deliveryCountrySelect;

	@FindBy(css = "input[name='delivery-addressLine1']")
	WebElement addressLine1Input;

	@FindBy(css = "input[name='delivery-addressLine2']")
	WebElement addressLine2Input;

	@FindBy(css = "input[name='delivery-city']")
	WebElement townCityInput;

	@FindBy(css = "input[name='delivery-county']")
	WebElement countyStateInput;

	@FindBy(css = "input[name='delivery-postCode']")
	WebElement postCodeInput;

	public DeliveryForm(WebDriver driver) {
		super(driver);
	}

	public List<String> getValidationErrorList() {
		List<String> errorList = new ArrayList<>();
		errorList.add(WebElementUtils.getTextContentFromElement(driver, emailInputValidationError));
		errorList.add(WebElementUtils.getTextContentFromElement(driver, deliveryFullNameValidationError));
		errorList.add(WebElementUtils.getTextContentFromElement(driver, addressLine1ValidationError));
		errorList.add(WebElementUtils.getTextContentFromElement(driver, deliveryCityValidationError));
		errorList.add(WebElementUtils.getTextContentFromElement(driver, deliveryPostCodeValidationError));
		return errorList;
	}

	public List<String> getStrippedValidationErrorList() {
		List<String> errorList = getValidationErrorList();
		errorList.removeIf(s -> s.equals(""));
		return errorList;
	}

	public void typeInEmailAddressInput(String emailAddress) {
		emailInput.sendKeys(emailAddress);
	}

	public void typeInFullNameInput(String fullName) {
		fullNameInput.sendKeys(fullName);
	}

	public void selectDeliveryCountry(String deliveryCountry) {
		Select deliverCountrySelect = new Select(deliveryCountrySelect);
		deliverCountrySelect.selectByVisibleText(deliveryCountry);
	}

	public void typeInAddressLine1Input(String addressLine1) {
		addressLine1Input.sendKeys(addressLine1);
	}

	public void typeInAddressLine2Input(String addressLine2) {
		addressLine2Input.sendKeys(addressLine2);
	}

	public void typeInCityOrTownInput(String city) {
		townCityInput.sendKeys(city);
	}

	public void typeInCountyOrStateInput(String state) {
		countyStateInput.sendKeys(state);
	}

	public void typeInPostcodeInput(String postcode) {
		postCodeInput.sendKeys(postcode);
	}

	public void submitDeliveryForm() {
		actionClick(buyNowButton);
	}

}
