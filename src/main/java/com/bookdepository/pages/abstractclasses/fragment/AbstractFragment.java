package com.bookdepository.pages.abstractclasses.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.bookdepository.utils.WebDriverWaiter;

public abstract class AbstractFragment {

    private WebElement rootElement;

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public AbstractFragment(By by) {
        rootElement = WebDriverWaiter.find(by);
    }

}
