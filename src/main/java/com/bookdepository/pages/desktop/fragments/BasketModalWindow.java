package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;


public class BasketModalWindow extends AbstractFragment {

    public Button basketCheckoutButton = new Button(By.cssSelector(".continue-to-basket"));

    public BasketModalWindow() {
		super(By.cssSelector(".modal-dialog"));
    }
}
