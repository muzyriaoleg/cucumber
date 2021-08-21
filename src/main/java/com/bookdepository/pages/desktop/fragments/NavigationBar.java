package com.bookdepository.pages.desktop.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bookdepository.driver.DriverManager;
import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import com.bookdepository.pages.desktop.pages.ContactUsPage;
import com.bookdepository.pages.desktop.pages.HomePage;


public class NavigationBar extends AbstractFragment {

	@FindBy(css = ".user-nav-wrap")
	WebElement navigationBarCoreElement;

	@FindBy(css = ".user-nav-wrap  a[href='/contactus']")
	WebElement contactUsButtonElement;

	@FindBy(css = ".user-nav-wrap  .home-icon-link")
	WebElement homeButtonElement;


	public NavigationBar(WebDriver driver) {
		super(driver);
		PageFactory.initElements(DriverManager.getChromedDriverInstance(), this);
		setRootElement(navigationBarCoreElement);
	}

	public ContactUsPage pressContactUsButton(WebDriver driver){
		contactUsButtonElement.click();
		return new ContactUsPage(driver);
	}

	public HomePage pressHomeButton(WebDriver driver){
		homeButtonElement.click();
		return new HomePage(driver);
	}


}
