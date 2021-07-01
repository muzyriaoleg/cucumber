package com.epam.pages;

import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.epam.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends AbstractPage {

    @FindBy(css = "span.source-sans")
    WebElement headquarterAdress;

    public ContactPage(WebDriver driver) {
        super(driver);
        setPageUrl(Constants.URL);
        setPageUrlPattern(Constants.CONTACTS_PAGE);
        PageFactory.initElements(driver, this);
    }

    public ContactPage open() {
        super.open();
        return this;
    }

    public String getAddress() {
    return headquarterAdress.getAttribute("textContent").trim();
    }

}
