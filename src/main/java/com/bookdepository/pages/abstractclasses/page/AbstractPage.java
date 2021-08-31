package com.bookdepository.pages.abstractclasses.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.bookdepository.constants.Constants;
import com.bookdepository.utils.WebDriverWaiter;


public abstract class AbstractPage extends WebDriverWaiter {

	protected WebDriver driver;
	private String pageUrl;
	private String pageUrlPattern = Constants.EMPTY_STRING;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		setPageUrl(Constants.URL);
		PageFactory.initElements(driver, this);
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrlPattern(String pageUrlPattern) {
		this.pageUrlPattern = pageUrlPattern;
	}

	public String getPageUrlPattern() {
		return pageUrlPattern;
	}

	public AbstractPage open() {
		driver.get(getPageUrl() + getPageUrlPattern());
		isPageLoaded();
		return this;
	}

	public boolean isOpened() {
		return isPageUrlMatchUrlPattern() && isPageLoaded();
	}

	private ExpectedCondition<Boolean> jsIsLoaded() {
		return webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals(
				"complete");
	}

	private ExpectedCondition<Boolean> jQueryIsLoaded() {
		return webDriver -> ((JavascriptExecutor) webDriver).executeScript("return jQuery.active").toString().equals("0");
	}

	private boolean isPageLoaded() {
		driverWait(driver).until(jsIsLoaded());
		return true;
	}

	private boolean isPageUrlMatchUrlPattern() {
		driverWait(driver).until(pageUrlIsUpdated());
		return true;
	}

	private ExpectedCondition<Boolean> pageUrlIsUpdated() {
		return webDriver -> webDriver.getCurrentUrl().contains(pageUrlPattern);
	}
}
