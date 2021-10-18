package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class Input extends AbstractFragment {

    public Input(By by) {
        super(by);
    }

    public Input typeText(String text) {
        get().sendKeys(text);
        return this;
    }

    public Input submitWithEnter() {
        get().sendKeys(Keys.ENTER);
        return this;
    }
}
