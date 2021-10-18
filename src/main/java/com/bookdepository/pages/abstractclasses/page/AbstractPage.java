package com.bookdepository.pages.abstractclasses.page;

import com.bookdepository.constants.Constants;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.impl.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;


public abstract class AbstractPage {

    private String pageUrlPattern = Constants.EMPTY_STRING;
    Waiter waiter = new Waiter();

    protected AbstractPage() {

    }

    public void setPageUrlPattern(String pageUrlPattern) {
        this.pageUrlPattern = pageUrlPattern;
    }

    public String getPageUrlPattern() {
        return pageUrlPattern;
    }

    public AbstractPage open() {
        Selenide.open(pageUrlPattern);
        isPageLoaded();
        return this;
    }

    public boolean isOpened() {
        return isPageUrlMatchUrlPattern() && isPageLoaded();
    }

    public AbstractPage switchToIframe(By by) {
        Selenide.switchTo().frame(Selenide.$(by));
        return this;
    }

    public AbstractPage switchToIframe(int index) {
        Selenide.switchTo().frame(index);
        return this;
    }

    private ExpectedCondition<Boolean> pageUrlIsUpdated() {
        return webDriver -> webDriver.getCurrentUrl().contains(pageUrlPattern);
    }

    private ExpectedCondition<Boolean> jsIsLoaded() {
        return webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")
                .equals("complete");
    }

    private ExpectedCondition<Boolean> jQueryIsLoaded() {
        return webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return jQuery.active").toString()
                .equals("0");
    }

    private boolean isPageLoaded() {
        Selenide.Wait().until(jsIsLoaded());
        return true;
    }

    private boolean isPageUrlMatchUrlPattern() {
        Selenide.Wait().until(pageUrlIsUpdated());
        return true;
    }
}
