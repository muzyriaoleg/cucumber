package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;


public class DeliveryForm extends AbstractFragment {

    public Button buyNowButton = new Button(By.cssSelector("button[type='submit']"));
    public Field emailInputValidationError = new Field(By.xpath("//input[@name='emailAddress']/../div[@class='error-block']"));
    public Field deliveryFullNameValidationError = new Field(By.xpath("//input[@name='delivery-fullName']/../div[@class='error-block']"));
    public Field addressLine1ValidationError = new Field(By.xpath("//input[@name='delivery-addressLine1']/../div[@class='error-block']"));
    public Field deliveryCityValidationError = new Field(By.xpath("//input[@name='delivery-city']/../div[@class='error-block']"));
    public Field deliveryPostCodeValidationError = new Field(By.xpath("//input[@name='delivery-postCode']/../div[@class='error-block']"));
    public Input emailInput = new Input(By.cssSelector("input[name='delivery-fullName']"));
    public Input fullNameInput = new Input(By.cssSelector("input[name='delivery-fullName']"));
    public Select deliveryCountrySelect = new Select(By.cssSelector("#deliveryCountryDropdown"));
    public Input addressLine1Input = new Input(By.cssSelector("input[name='delivery-addressLine1']"));
    public Input addressLine2Input = new Input(By.cssSelector("input[name='delivery-addressLine2']"));
    public Input townCityInput = new Input(By.cssSelector("input[name='delivery-city']"));
    public Input countyStateInput = new Input(By.cssSelector("input[name='delivery-county']"));
    public Input postCodeInput = new Input(By.cssSelector("input[name='delivery-postCode']"));

    public Map<String, String> getValidationErrorList() {
        Map<String, String> errors = new HashMap<>();
        errors.put("Email address", emailInputValidationError.get().getText());
        errors.put("Full name", deliveryFullNameValidationError.get().getText());
        errors.put("Address line 1", addressLine1ValidationError.get().getText());
        errors.put("Town/City", deliveryCityValidationError.get().getText());
        errors.put(" Postcode/ZIP", deliveryPostCodeValidationError.get().getText());
        return errors;
    }

    public Map<String, String> getStrippedValidationErrorList() {
        Map<String, String> errors = getValidationErrorList();
        errors.forEach((k, v) -> errors.remove(k, ""));
        return errors;
    }
}
