package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class SearchFilterWidget extends AbstractFragment {

	@FindBy(css = "#filterPrice")
	WebElement priceRangeSelectElem;

	@FindBy(css = "#filterAvailability")
	WebElement availabilitySelectElem;

	@FindBy(css = "#filterLang")
	WebElement languageSelectElem;

	@FindBy(css = "#filterFormat")
	WebElement formatSelectElem;

	@FindBy(css = ".padded-btn-wrap button[type='submit']")
	WebElement submitFiltersButtonElem;

	public SearchFilterWidget(WebDriver driver) {
		super(driver);
	}

	public void choosePriceRange(String priceValue) {
		Select priceRangeSelect = new Select(priceRangeSelectElem);
		priceRangeSelect.selectByVisibleText(priceValue);
	}

	public void chooseAvailability(String availabilityValue) {
		Select availabilitySelect = new Select(availabilitySelectElem);
		availabilitySelect.selectByVisibleText(availabilityValue);
	}

	public void chooseLanguage(String languageValue) {
		Select languageSelect = new Select(languageSelectElem);
		languageSelect.selectByVisibleText(languageValue);
	}

	public void chooseFormat(String formatValue) {
		Select formatSelect = new Select(formatSelectElem);
		formatSelect.selectByVisibleText(formatValue);
	}

	public void pressButtonSubmit() {
		submitFiltersButtonElem.click();
	}
}
