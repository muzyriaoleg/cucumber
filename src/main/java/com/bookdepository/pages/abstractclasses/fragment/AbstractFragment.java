package com.bookdepository.pages.abstractclasses.fragment;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.bookdepository.driver.DriverManager;
import com.bookdepository.utils.WebDriverWaiter;


public abstract class AbstractFragment extends WebDriverWaiter {

	private WebElement rootElement;
	protected WebDriver driver = DriverManager.getDriverInstance();

	public void setRootElement(WebElement element) {
		this.rootElement = element;
	}

	public WebElement getRootElement() {
		return rootElement;
	}

	protected AbstractFragment() {
		PageFactory.initElements(driver, this);
	}

	protected AbstractFragment(WebElement element) {
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
		actions.moveToElement(element).sendKeys(key).build().perform();
	}

	public void jsScrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public WebElement find(WebElement element) {
		driverWait().until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public WebElement click(WebElement element) {
		find(element).click();
		return element;
	}

	public WebElement typeText(WebElement element, String text) {
		find(element);
		element.sendKeys(text);
		element.sendKeys(Keys.ENTER);
		return element;
	}

}
