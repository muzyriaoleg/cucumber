package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class SearchBar extends AbstractFragment {

	@FindBy(css = "input[name='searchTerm']")
	WebElement searchInputElement;

	public void search(String text) {
		typeText(searchInputElement, text);
	}
}
