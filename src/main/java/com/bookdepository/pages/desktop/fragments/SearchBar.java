package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class SearchBar extends AbstractFragment {

	public Input searchInput = new Input(By.cssSelector("input[name='searchTerm']"));
}
