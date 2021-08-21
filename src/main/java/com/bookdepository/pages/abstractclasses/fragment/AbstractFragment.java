package com.bookdepository.pages.abstractclasses.fragment;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bookdepository.utils.WebDriverWaiter;


public abstract class AbstractFragment extends WebDriverWaiter {

	private WebElement rootElement;
	protected static WebDriver driver;


	public void setRootElement(WebElement element) {
		this.rootElement = element;
	}

	public WebElement getRootElement() {
		return rootElement;
	}

	protected AbstractFragment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected AbstractFragment(WebElement element, WebDriver driver) {
		this.rootElement = element;
		PageFactory.initElements(driver, this);
	}

	public static void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void actionClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
}
