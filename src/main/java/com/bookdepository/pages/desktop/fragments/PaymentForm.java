package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class PaymentForm extends AbstractFragment {

    public Field creditCardNumberValidationError = new Field(By.xpath("//label[@for='visacardNumber']/../..//span[@class='grid_12 notification custom_notification hide']"));

    public Field creditCardNameValidationError = new Field(By.xpath("//label[@for='visacardName']/../..//span[@class='grid_12 notification custom_notification hide']"));

    public Field creditCardCVVValidationError = new Field(By.xpath("//label[@for='visacardCvv']/../..//span[@class='grid_12 notification custom_notification hide']"));

    public Button buyNowButton = new Button(By.id("#submitButton"));

    public Select cardTypeSelect = new Select(By.id("#brandSelected"));

    public Input cardNumberInput = new Input(By.id("#visacardNumber"));

    public Select validToMonthSelect = new Select(By.id("#visacardValidToMonth"));

    public Select validToYearSelect = new Select(By.id("#visacardValidToYear"));

    public Input cardNameInput = new Input(By.id("#visacardName"));

    public Input cardCVVInput = new Input(By.id("#visacardCvv"));

    public List<String> getValidationErrorList() {
        List<String> errorList = new ArrayList<>();
        errorList.add(creditCardNumberValidationError.getText());
        errorList.add(creditCardNameValidationError.getText());
        errorList.add(creditCardCVVValidationError.getText());
        return errorList;
    }
}
