package com.bookdepository.pages.desktop.fragments;

import com.bookdepository.pages.abstractclasses.fragment.AbstractFragment;
import org.openqa.selenium.By;


public class OrderSummaryWidget extends AbstractFragment {

    public Field subTotal = new Field(By.xpath("//div[@class='sidebar right']//strong[contains(text(),'Sub-total')]//parent::dt/following-sibling::dd[@class='text-right']"));

    public Field deliveryCost = new Field(By.xpath("//div[@class='sidebar right']//strong[contains(text(),'Delivery')]//parent::dt/following-sibling::dd[@class='text-right']/strong"));

    public Field vatCost = new Field(By.xpath("//div[@class='sidebar right']//strong[contains(text(),'VAT')]//parent::dt/following-sibling::dd[@class='text-right total-tax']"));

    public Field totalCost = new Field(By.xpath("//div[@class='sidebar right']//dt[@class='total']/following-sibling::dd[@class='text-right total-price']"));
}
