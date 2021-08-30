package parallel;

import java.util.*;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import com.bookdepository.driver.DriverManager;
import com.bookdepository.dto.Card;
import com.bookdepository.dto.User;
import com.bookdepository.pages.desktop.PageFactory;
import com.bookdepository.utils.WebElementUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.*;


public class CheckoutStepsParallel extends PageFactory {


	@Given("^(?:I|[Uu]ser|[Cc]ustomer) (?:am|is|are|) an anonymous customer with clear cookies")
	public void clearCookies() {
		DriverManager.clearCookies();
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
		getHomePage().search(bookTitle);
	}

	@And("^Search results contain(?:s|) (?:the|) (?:following|next) (?:product|book|)(?:s|es|)$")
	public void searchResultPageContainsProducts(List<String> listObBooks) {
		Assertions.assertThat(getSearchResultPage().isBookPresentInResult(listObBooks)).as(
				"Search result page does not contains specified books").isTrue();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) apply (?:the|) (?:following|next) search filters$")
	public void userApplySearchFilters(Map<String, String> filters) {
		getSearchResultPage().choosePriceRange(filters.get("Price range"));
		getSearchResultPage().chooseAvailability(filters.get("Availability"));
		getSearchResultPage().chooseLanguage(filters.get("Language"));
		getSearchResultPage().chooseFormat(filters.get("Format"));
		getSearchResultPage().submitFilter();
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
		getSearchResultPage().confirmCheckoutOnModalWindow();
	}

	@And("^Basket order summary is as following:$")
	public void checkBasketOrderSummary(@Transpose Map<String, String> orderSummary) {
		SoftAssertions softAssert = new SoftAssertions();
		softAssert.assertThat(getBasketPage().getDeliveryCost()).as("Delivery cost doesn't match expected").isEqualTo(
				orderSummary.get("Delivery cost"));
		softAssert.assertThat(getBasketPage().getTotalCost()).as("Total cost doesn't match expected").isEqualTo(
				orderSummary.get("Total"));
		softAssert.assertAll();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:click|press) 'Checkout' button on 'Basket' page$")
	public void userClickCheckoutButton() {
		getBasketPage().checkout();
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) click(?:s|) 'Buy now' button$")
	public void userClickBuyNowButton() {
		getCheckoutPage().pressBuyNowButtonForDeliveryForm();
	}

	@Then("^(?:the|) (?:following|next) validation error messages are (?:displayed|present) on 'Delivery Address' form:$")
	public void checkDeliveryAddressValidationErrors(Map<String, String> errorMessages) {
		List<String> errorList = new ArrayList<>();
		errorMessages.forEach((k, v) -> errorList.add(v));
		errorList.remove(0);
		Assertions.assertThat(getCheckoutPage().getErrorMessagesFromDeliveryAddressForm()).isEqualTo(errorList);
	}

	@And("^Checkout order summary is as following:$")
	public void checkCheckoutOrderSummary(@Transpose Map<String, String> orderSummary) {
		SoftAssertions softAssert = new SoftAssertions();
		softAssert.assertThat(getCheckoutPage().getOrderSubTotal()).isEqualTo(orderSummary.get("Sub-total"));
		softAssert.assertThat(getCheckoutPage().getDeliveryCost()).isEqualTo(orderSummary.get("Delivery"));
		softAssert.assertThat(getCheckoutPage().getVATCost()).isEqualTo(orderSummary.get("VAT"));
		softAssert.assertThat(getCheckoutPage().getTotalCost()).isEqualTo(orderSummary.get("Total"));
		softAssert.assertAll();
	}

	@And("^(?:I|[Uu]ser|[Cc]ustomer) checkout as a new customer with email (.+)$")
	public void userCheckoutAsNewUser(String email) {
		getCheckoutPage().setEmailAddress(email);
	}

	@When("^(?:I|[Uu]ser|[Cc]ustomer) (?:fill|provide) delivery address information (?:manually|):$")
	public void userFillDeliveryAddress(@Transpose Map<String, String> map) {
		User user = new ObjectMapper().convertValue(map, User.class);
		getCheckoutPage().setFullName(user.getFullName());
		getCheckoutPage().setDeliveryCountry(user.getDeliveryCounty());
		getCheckoutPage().setAddressLine1(user.getAddressLine1());
		getCheckoutPage().setAddressLine2(user.getAddressLine2());
		getCheckoutPage().setCityOrTown(user.getTownCity());
		getCheckoutPage().setCountyOrState(user.getCountyState());
		getCheckoutPage().setPostcode(user.getPostCode());
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
		getCheckoutPage().setCardType(card.getCardType());
		getCheckoutPage().setCardName(card.getNameOnCard());
		getCheckoutPage().setCardNumber(card.getCardNumber());
		getCheckoutPage().setExpirationYear(card.getExpiryYear());
		getCheckoutPage().setExpirationMonth(card.getExpiryMonth());
		getCheckoutPage().setCVV(card.getCvv());
	}
}
