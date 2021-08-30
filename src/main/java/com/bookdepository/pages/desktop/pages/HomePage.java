package com.bookdepository.pages.desktop.pages;

import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.SearchBar;


public class HomePage extends AbstractPage {

	public void search(String text) {
		SearchBar searchBar = new SearchBar();
		searchBar.search(text);
	}
}
