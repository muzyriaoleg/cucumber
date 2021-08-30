package com.bookdepository.pages.desktop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.*;
import com.bookdepository.utils.WebElementUtils;


public class SearchResultPage extends AbstractPage {

	private String bookTitleXpathTemplate = "//a[contains(text(), '%s')]/../../..//div[@class='btn-wrap']";

	BasketModalWindow basketModalWindow = new BasketModalWindow();
	SearchFilterWidget searchWidget = new SearchFilterWidget();

	public SearchResultPage() {
		super();
		setPageUrlPattern(Constants.SEARCH_RESULT_PAGE_URL_PATTERN);
	}

	public void choosePriceRange(String priceValue) {
		searchWidget.choosePriceRange(priceValue);
	}

	public void chooseAvailability(String availabilityValue) {
		searchWidget.chooseAvailability(availabilityValue);
	}

	public void chooseLanguage(String languageValue) {
		searchWidget.chooseLanguage(languageValue);
	}

	public void chooseFormat(String formatValue) {
		searchWidget.chooseFormat(formatValue);
	}

	public void submitFilter() {
		searchWidget.pressButtonSubmit();
	}

	public boolean isBookPresentInResult(List<String> listOfBooks) {
		List<String> bookTitlesList = WebElementUtils.getTextContentListByCSS(driver, ".title");
		return bookTitlesList.containsAll(listOfBooks);
	}

	public boolean onlySpecifiedBooksPresentInResult(List<String> bookList) {
		List<String> bookTitlesList = WebElementUtils.getTextContentListByCSS(driver, ".title");
		bookTitlesList.removeAll(bookList);
		return bookTitlesList.isEmpty();
	}

	public void addBookToBasket(String bookTitle) {
		WebElement addToBasketButton = driver.findElement(By.xpath(String.format(bookTitleXpathTemplate, bookTitle)));
		addToBasketButton.click();


	}

	public void confirmCheckoutOnModalWindow() {
		basketModalWindow.pressButtonBasketCheckout();
	}
}
