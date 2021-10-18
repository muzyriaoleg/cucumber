package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class Button extends AbstractFragment {

    public Button(By by) {
        super(by);
    }

    public Button press() {
        get().click();
        return this;
    }

}
