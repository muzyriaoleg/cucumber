package com.bookdepository.pages.desktop.pages;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.*;


public class CheckoutPage extends AbstractPage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		setPageUrlPattern(Constants.CHECKOUT_PAGE_GUEST_URL_PATTERN);
	}

	DeliveryForm deliveryForm = new DeliveryForm(driver);
	OrderSummaryWidget orderSummaryWidget = new OrderSummaryWidget(driver);
	PaymentForm paymentForm = new PaymentForm(driver);

	public List<String> getErrorMessagesFromDeliveryAddressForm() {
		return deliveryForm.getValidationErrorList();
	}

	public List<String> getStrippedErrorMessagesFromDeliveryAddressForm() {
		return deliveryForm.getStrippedValidationErrorList();
	}

	public List<String> getValidationErrorsFromPaymentForm() {
		return paymentForm.getValidationErrorList();
	}

	public String getOrderSubTotal() {
		return orderSummaryWidget.getOrderSubTotal();
	}

	public String getDeliveryCost() {
		return orderSummaryWidget.getDeliveryCost();
	}

	public String getVATCost() {
		return orderSummaryWidget.getVATCost();
	}

	public String getTotalCost() {
		return orderSummaryWidget.getTotalCost();
	}

	public void setEmailAddress(String emailAddress) {
		deliveryForm.typeInEmailAddressInput(emailAddress);
	}

	public void setFullName(String fullName) {
		deliveryForm.typeInFullNameInput(fullName);
	}

	public void setDeliveryCountry(String deliveryCountry) {
		deliveryForm.selectDeliveryCountry(deliveryCountry);
	}

	public void setAddressLine1(String addressLine1) {
		deliveryForm.typeInAddressLine1Input(addressLine1);
	}

	public void setAddressLine2(String addressLine2) {
		deliveryForm.typeInAddressLine2Input(addressLine2);
	}

	public void setCityOrTown(String city) {
		deliveryForm.typeInCityOrTownInput(city);
	}

	public void setCountyOrState(String state) {
		deliveryForm.typeInCountyOrStateInput(state);
	}

	public void setPostcode(String postcode) {
		deliveryForm.typeInPostcodeInput(postcode);
	}

	public void pressBuyNowButtonForDeliveryForm() {
		deliveryForm.submitDeliveryForm();
	}

	public void pressBuyNowButtonForPaymentForm() {
		paymentForm.pressBuyNowButton();
	}

	public void setCardType(String cardType) {
		paymentForm.chooseCardType(cardType);
	}

	public void setCardName(String cardName) {
		paymentForm.typeCardName(cardName);
	}

	public void setCardNumber(String cardNumber) {
		paymentForm.typeCardNumber(cardNumber);
	}

	public void setExpirationYear(String year) {
		paymentForm.selectValidToYear(year);
	}

	public void setExpirationMonth(String month) {
		paymentForm.selectValidToMonth(month);
	}

	public void setCVV(String cvv) {
		paymentForm.typeCardCVV(cvv);
	}
}
