package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;


public class CheckoutForm extends AbstractFragment {

    public Field deliveryCost = new Field(By.cssSelector(".delivery-text dd"));
    public Field totalCost = new Field(By.cssSelector(".basket-totals-wrap .total dd"));
    public Button checkoutButton = new Button(By.xpath("//a[text()='Checkout']"));
}
