package com.bookdepository.steps;

import java.util.*;

import com.codeborne.selenide.WebDriverRunner;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import com.bookdepository.dto.Card;
import com.bookdepository.dto.User;
import com.bookdepository.pages.desktop.PageFactory;
import com.bookdepository.utils.WebElementUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.*;


public class CheckoutSteps extends PageFactory {


	@Given("^(?:I|[Uu]ser|[Cc]ustomer) (?:am|is|are|) an anonymous customer with clear cookies")
	public void clearCookies() {
		WebDriverRunner.driver().clearCookies();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) (?:open|go)(?:s|) (?:the|to) \"(.+)\"$")
	public void userOpenPage(String pageName) {
		Assertions.assertThat(createPage(pageName).open().isOpened()).as(pageName + " is not opened").isTrue();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) (?:am|is|are|) redirected to (?:a|the|) \"(.+)\"$")
	public void userIsRedirectedToPage(String pageName) {
		Assertions.assertThat(createPage(pageName).isOpened())
				.as(pageName + " is not opened").isTrue();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) search for (.+)$")
	public void userSearchForProduct(String bookTitle) {
		getHomePage().searchBar.searchInput.typeText(bookTitle).submitWithEnter();
	}

	@And("^Search results contain(?:s|) (?:the|) (?:following|next) (?:product|book|)(?:s|es|)$")
	public void searchResultPageContainsProducts(List<String> listObBooks) {
		Assertions.assertThat(getSearchResultPage().isBookPresentInResult(listObBooks)).as(
				"Search result page does not contains specified books").isTrue();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) apply (?:the|) (?:following|next) search filters$")
	public void userApplySearchFilters(Map<String, String> filters) {
		getSearchResultPage().searchWidget.priceRangeSelect.selectByText(filters.get("Price range"));
		getSearchResultPage().searchWidget.availabilitySelect.selectByText(filters.get("Availability"));
		getSearchResultPage().searchWidget.languageSelect.selectByText(filters.get("Language"));
		getSearchResultPage().searchWidget.formatSelect.selectByText(filters.get("Format"));
		getSearchResultPage().searchWidget.submitFiltersButton.press();
	}

	@Then("^Search results (?:contain|has) only the (?:following|next) (?:product|book|)(?:s|es|)$")
	public void searchResultPageContainsProductsAfterFiltering(List<String> bookList) {
		Assertions.assertThat(getSearchResultPage().onlySpecifiedBooksPresentInResult(bookList)).as(
				"Search result contains not all products").isTrue();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:click|press) 'Add to basket' button for (?:product|book|)(?:s|es|) with name (.+)$")
	public void userAddProductToBasket(String bookTitle) {
		getSearchResultPage().addBookToBasket(bookTitle);
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) (?:select|choose) 'Basket/Checkout' in basket pop-up$")
	public void userSelectCheckoutInPopUp() {
		getSearchResultPage().basketModalWindow.basketCheckoutButton.press();
	}

	@And("^Basket order summary is as following:$")
	public void checkBasketOrderSummary(@Transpose Map<String, String> orderSummary) {
		Map<String, String> actualOrderSummary = new HashMap<>();
		actualOrderSummary.put("Delivery cost", getBasketPage().checkoutForm.deliveryCost.get().getText());
		actualOrderSummary.put("Total", getBasketPage().checkoutForm.totalCost.get().getText());
		Assertions.assertThat(actualOrderSummary).as("Order summary doesnt match expected")
				.isEqualTo(orderSummary);
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:click|press) 'Checkout' button on 'Basket' page$")
	public void userClickCheckoutButton() {
		getBasketPage().checkoutForm.checkoutButton.press();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) click(?:s|) 'Buy now' button$")
	public void userClickBuyNowButton() {
		getCheckoutPage().deliveryForm.buyNowButton.jsScrollIntoView();
		getCheckoutPage().deliveryForm.buyNowButton.press();
	}

	@Then("^(?:the|) (?:following|next) validation error messages are (?:displayed|present) on 'Delivery Address' form:$")
	public void checkDeliveryAddressValidationErrors(Map<String, String> errorMessages) {
		Assertions.assertThat(getCheckoutPage().getErrorMessagesFromDeliveryAddressForm()).isEqualTo(errorMessages);
	}

	@And("^Checkout order summary is as following:$")
	public void checkCheckoutOrderSummary(@Transpose Map<String, String> orderSummary) {
		SoftAssertions softAssert = new SoftAssertions();
		softAssert.assertThat(getCheckoutPage().orderSummaryWidget.subTotal.get().getText()).isEqualTo(orderSummary.get("Sub-total"));
		softAssert.assertThat(getCheckoutPage().orderSummaryWidget.deliveryCost.get().getText()).isEqualTo(orderSummary.get("Delivery"));
		softAssert.assertThat(getCheckoutPage().orderSummaryWidget.vatCost.get().getText()).isEqualTo(orderSummary.get("VAT"));
		softAssert.assertThat(getCheckoutPage().orderSummaryWidget.totalCost.get().getText()).isEqualTo(orderSummary.get("Total"));
		softAssert.assertAll();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) checkout as a new customer with email (.+)$")
	public void userCheckoutAsNewUser(String email) {
		getCheckoutPage().deliveryForm.emailInput.typeText(email);
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:fill|provide) delivery address information (?:manually|):$")
	public void userFillDeliveryAddress(@Transpose Map<String, String> map) {
		User user = new ObjectMapper().convertValue(map, User.class);
		getCheckoutPage().deliveryForm.fullNameInput.typeText(user.getFullName());
		getCheckoutPage().deliveryForm.deliveryCountrySelect.selectByText(user.getDeliveryCounty());
		getCheckoutPage().deliveryForm.addressLine1Input.typeText(user.getAddressLine1());
		getCheckoutPage().deliveryForm.addressLine2Input.typeText(user.getAddressLine2());
		getCheckoutPage().deliveryForm.townCityInput.typeText(user.getTownCity());
		getCheckoutPage().deliveryForm.countyStateInput.typeText(user.getCountyState());
		getCheckoutPage().deliveryForm.postCodeInput.typeText(user.getPostCode());
	}

	@Then("^there is no validation error messages (?:displayed|present) on 'Delivery Address' form$")
	public void checkNoValidationErrorsDisplayed() {
		Assertions.assertThat(getCheckoutPage().getStrippedErrorMessagesFromDeliveryAddressForm()).as(
				"Validation errors does not disappear after valid delivery data was provided").isEmpty();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) click(?:s|) 'Buy now' button again$")
	public void submitPaymentForm() {
		getCheckoutPage().pressBuyNowButtonForPaymentForm();
	}

	@And("^the following validation error messages are (?:displayed|present) on 'Payment' form:$")
	public void checkPaymentValidationErrors(String error) {
		List<String> list = Arrays.asList(error.split(","));
		Assertions.assertThat(WebElementUtils.trimElementsInList(list)).isEqualTo(
				getCheckoutPage().getValidationErrorsFromPaymentForm());
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:enter|provide) (?:my|his|) card details$")
	public void userEnterCardDetails(Map<String, String> map) {
		Card card = new ObjectMapper().convertValue(map, Card.class);
		getCheckoutPage().paymentForm.cardTypeSelect.selectByText(card.getCardType());
		getCheckoutPage().paymentForm.cardNameInput.typeText(card.getNameOnCard());
		getCheckoutPage().paymentForm.cardNumberInput.typeText(card.getCardNumber());
		getCheckoutPage().paymentForm.validToYearSelect.selectByText(card.getExpiryYear());
		getCheckoutPage().paymentForm.validToMonthSelect.selectByText(card.getExpiryMonth());
		getCheckoutPage().paymentForm.cardCVVInput.typeText(card.getCvv());
	}
}
