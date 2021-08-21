package com.bookdepository.pages.abstractclasses.fragment;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.bookdepository.utils.WebDriverWaiter;
import com.bookdepository.utils.WebElementUtils;


public abstract class AbstractFragment extends WebDriverWaiter {

	private WebElement rootElement;
	protected WebDriver driver;

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

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void actionClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	public void actionSendKey(WebElement element, Keys key) {
		Actions actions = new Actions(driver);
		actions.sendKeys(key).build().perform();
	}
}
