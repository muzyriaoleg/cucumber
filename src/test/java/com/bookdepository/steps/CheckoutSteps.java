package com.bookdepository.steps;

import java.util.*;

import org.assertj.core.api.Assertions;

import com.bookdepository.driver.DriverManager;
import com.bookdepository.dto.Card;
import com.bookdepository.dto.User;
import com.bookdepository.pages.desktop.pages.*;
import com.bookdepository.utils.WebElementUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.*;


public class CheckoutSteps {

	HomePage homePage = new HomePage(DriverManager.getChromedDriverInstance());
	SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getChromedDriverInstance());
	BasketPage basketPage = new BasketPage(DriverManager.getChromedDriverInstance());
	CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getChromedDriverInstance());

	@Given("^(?:I|[Uu]ser|[Cc]ustomer) (?:am|is|are|) an anonymous customer with clear cookies")
	public void clearCookies() {
		DriverManager.clearCookies();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) (?:open|go)(?:s|) (?:the|to) \"Initial home page\"$")
	public void userOpenHomePage() {
		homePage.open();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) search for (.+)$")
	public void userSearchForProduct(String bookTitle) {
		homePage.search(bookTitle);
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) (?:am|is|are|) redirected to a \"Search page\"$")
	public void searchPageIsOpened() {
		Assertions.assertThat(searchResultPage.isOpened()).withFailMessage("Search result page is not Opened").isTrue();
	}

	@And("^Search results contain(?:s|) (?:the|) (?:following|next) (?:product|book|)(?:s|es|)$")
	public void searchResultPageContainsProducts(List<String> listObBooks) {
		Assertions.assertThat(searchResultPage.isBookPresentInResult(listObBooks)).withFailMessage(
				"Search result page does not contains specified books").isTrue();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) apply (?:the|) (?:following|next) search filters$")
	public void userApplySearchFilters(Map<String, String> filters) {
		searchResultPage.choosePriceRange(filters.get("Price range"));
		searchResultPage.chooseAvailability(filters.get("Availability"));
		searchResultPage.chooseLanguage(filters.get("Language"));
		searchResultPage.chooseFormat(filters.get("Format"));
		searchResultPage.submitFilter();
	}

	@Then("^Search results (?:contain|has) only the (?:following|next) (?:product|book|)(?:s|es|)$")
	public void searchResultPageContainsProductsAfterFiltering(List<String> bookList) {
		Assertions.assertThat(searchResultPage.onlySpecifiedBooksPresentInResult(bookList)).withFailMessage(
				"Search result contains not all products").isTrue();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:click|press) 'Add to basket' button for (?:product|book|)(?:s|es|) with name (.+)$")
	public void userAddProductToBasket(String bookTitle) {
		searchResultPage.addBookToBasket(bookTitle);
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) (?:select|choose) 'Basket/Checkout' in basket pop-up$")
	public void userSelectCheckoutInPopUp() {
		searchResultPage.confirmCheckoutOnModalWindow();
	}

	@Then("^(?:I|[Uu]ser|[Cc]ustomer) (?:am|is|are|) redirected to the \"Basket page\"$")
	public void userRedirectedToBasketPage() {
		Assertions.assertThat(basketPage.isOpened()).withFailMessage("Basket page is not opened").isTrue();
	}

	@And("^Basket order summary is as following:$")
	public void checkBasketOrderSummary(@Transpose Map<String, String> orderSummary) {
		Assertions.assertThat(orderSummary.get("Delivery cost")).withFailMessage(
				"Delivery cost doesn't match expected").isEqualTo(basketPage.getDeliveryCost());
		Assertions.assertThat(orderSummary.get("Total")).withFailMessage("Total cost doesn't match expected").isEqualTo(
				basketPage.getTotalCost());
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:click|press) 'Checkout' button on 'Basket' page$")
	public void userClickCheckoutButton() {
		basketPage.checkout();
	}

	@Then("^(?:I|[Uu]ser|[Cc]ustomer) (?:am|is|are|) redirected to (?:the|) \"Checkout\" page$")
	public void userRedirectedToCheckoutPage() {
		Assertions.assertThat(checkoutPage.isOpened()).withFailMessage("Checkout page is not opened").isTrue();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) click(?:s|) 'Buy now' button$")
	public void userClickBuyNowButton() {
		checkoutPage.pressBuyNowButtonForDeliveryForm();
	}

	@Then("^(?:the|) (?:following|next) validation error messages are (?:displayed|present) on 'Delivery Address' form:$")
	public void checkDeliveryAddressValidationErrors(Map<String, String> errorMessages) {
		List<String> errorList = new ArrayList<>();
		errorMessages.forEach((k, v) -> errorList.add(v));
		errorList.remove(0);
		Assertions.assertThat(errorList).isEqualTo(checkoutPage.getErrorMessagesFromDeliveryAddressForm());
	}

	@And("^Checkout order summary is as following:$")
	public void checkCheckoutOrderSummary(@Transpose Map<String, String> orderSummary) {
		Assertions.assertThat(checkoutPage.getOrderSubTotal()).isEqualTo(orderSummary.get("Sub-total"));
		Assertions.assertThat(checkoutPage.getDeliveryCost()).isEqualTo(orderSummary.get("Delivery"));
		Assertions.assertThat(checkoutPage.getVATCost()).isEqualTo(orderSummary.get("VAT"));
		Assertions.assertThat(checkoutPage.getTotalCost()).isEqualTo(orderSummary.get("Total"));
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) checkout as a new customer with email (.+)$")
	public void userCheckoutAsNewUser(String email) {
		checkoutPage.setEmailAddress(email);
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:fill|provide) delivery address information (?:manually|):$")
	public void userFillDeliveryAddress(@Transpose Map<String, String> map) {
		User user = new ObjectMapper().convertValue(map, User.class);
		checkoutPage.setFullName(user.getFullName());
		checkoutPage.setDeliveryCountry(user.getDeliveryCounty());
		checkoutPage.setAddressLine1(user.getAddressLine1());
		checkoutPage.setAddressLine2(user.getAddressLine2());
		checkoutPage.setCityOrTown(user.getTownCity());
		checkoutPage.setCountyOrState(user.getCountyState());
		checkoutPage.setPostcode(user.getPostCode());
	}

	@Then("^there is no validation error messages (?:displayed|present) on 'Delivery Address' form$")
	public void checkNoValidationErrorsDisplayed() {
		Assertions.assertThat(checkoutPage.getStrippedErrorMessagesFromDeliveryAddressForm().isEmpty()).withFailMessage(
				"Validation errors does not disappear after valid delivery data was provided").
				isTrue();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) click(?:s|) 'Buy now' button again$")
	public void submitPaymentForm() {
			checkoutPage.pressBuyNowButtonForPaymentForm();
	}

	@And("^the following validation error messages are (?:displayed|present) on 'Payment' form:$")
	public void checkPaymentValidationErrors(String error) {
		List<String> list = Arrays.asList(error.split(","));
		Assertions.assertThat(checkoutPage.getValidationErrorsFromPaymentForm())
				.isEqualTo(WebElementUtils.trimElementsInList(list));
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:enter|provide) (?:my|his|) card details$")
	public void userEnterCardDetails(Map<String, String> map) {
		Card card = new ObjectMapper().convertValue(map, Card.class);
		checkoutPage.setCardType(card.getCardType());
		checkoutPage.setCardName(card.getNameOnCard());
		checkoutPage.setCardNumber(card.getCardNumber());
		checkoutPage.setExpirationYear(card.getExpiryYear());
		checkoutPage.setExpirationMonth(card.getExpiryMonth());
		checkoutPage.setCVV(card.getCvv());
	}

}







