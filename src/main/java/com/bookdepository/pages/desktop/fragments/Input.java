package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.*;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class Input extends AbstractFragment {

	public Input(WebDriver driver, WebElement element) {
		super(driver, element);
	}

	public void type(String text) {
		getRootElement().sendKeys(text);
		getRootElement().sendKeys(Keys.ENTER);
	}

}
