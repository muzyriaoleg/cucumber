package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

public class Select extends AbstractFragment {
    public Select(By by) {
        super(by);
    }

    public Select selectByText(String value) {
        get().selectOptionContainingText(value);
        return this;
    }

}
