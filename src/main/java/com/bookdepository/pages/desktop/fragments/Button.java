package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebElement;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;


public class Button extends AbstractFragment {

	public Button(WebElement element) {
		super(element);
	}

	public void press() {
		click(getRootElement());
	}

}
