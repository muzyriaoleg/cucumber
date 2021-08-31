package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class Button extends AbstractFragment {

	public Button(WebDriver driver,  WebElement element) {
		super(driver,element);
	}

	public void press() {
		click(getRootElement());
	}

}
