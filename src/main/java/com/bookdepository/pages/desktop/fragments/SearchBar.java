package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class SearchBar extends AbstractFragment {

	@FindBy(css = "input[name='searchTerm']")
	WebElement searchInputElement;

	public SearchBar(WebDriver driver) {
		super(driver);
	}

	public void search(String text) {
		searchInputElement.sendKeys(text);
		searchInputElement.sendKeys(Keys.ENTER);
	}
}
