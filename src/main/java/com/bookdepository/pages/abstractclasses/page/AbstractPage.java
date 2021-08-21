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

	public void open() {
		driver.get(getPageUrl() + getPageUrlPattern());
		driverWait().until(pageIsLoaded());
	}

	public boolean isOpened() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
	}

	private ExpectedCondition<Boolean> pageIsLoaded() {
		return webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState")
				.equals("complete");
	}
}
