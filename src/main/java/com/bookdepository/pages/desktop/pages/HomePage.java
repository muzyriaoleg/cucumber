package com.bookdepository.pages.desktop.pages;

import org.openqa.selenium.WebDriver;

import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.SearchBar;


public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void search(String text) {
		SearchBar searchBar = new SearchBar(driver);
		searchBar.search(text);
	}
}
