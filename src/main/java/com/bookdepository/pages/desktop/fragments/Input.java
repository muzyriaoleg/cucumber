package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class Input extends AbstractFragment {

	public Input(WebElement element) {
		super(element);
	}

	public void type(String text) {
		getRootElement().sendKeys(text);
		getRootElement().sendKeys(Keys.ENTER);
	}

}
