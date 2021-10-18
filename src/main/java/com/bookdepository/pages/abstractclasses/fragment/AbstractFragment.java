package com.bookdepository.pages.abstractclasses.fragment;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;


public abstract class AbstractFragment {

    private SelenideElement rootElement;

    protected AbstractFragment() {
    }

    public SelenideElement get() {
        return Selenide.$(rootElement).shouldBe(enabled);
    }

    public AbstractFragment(By by) {
        rootElement = Selenide.$(by);
    }

    public AbstractFragment jsClick() {
        Selenide.executeJavaScript("arguments[0].click();", get());
        return this;
    }

    public AbstractFragment actionClick() {
        Selenide.actions().moveToElement(get()).click().build().perform();
        return this;
    }

    public AbstractFragment actionSendKey(WebElement element, Keys key) {
        Selenide.actions().moveToElement(element).sendKeys(key).build().perform();
        return this;
    }

    public AbstractFragment jsScrollIntoView() {
        Selenide.executeJavaScript("arguments[0].scrollIntoView();", get());
        return this;
    }


    public AbstractFragment click() {
        get().click();
        return this;
    }

    public String getText() {
        return get().getText();
    }

}
