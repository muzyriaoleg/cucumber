package com.bookdepository.pages.desktop.pages;

import com.bookdepository.constants.Constants;
import com.bookdepository.pages.abstractclasses.page.AbstractPage;
import com.bookdepository.pages.desktop.fragments.DeliveryForm;
import com.bookdepository.pages.desktop.fragments.OrderSummaryWidget;
import com.bookdepository.pages.desktop.fragments.PaymentForm;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;


public class CheckoutPage extends AbstractPage {

    public CheckoutPage() {
        super();
        setPageUrlPattern(Constants.CHECKOUT_PAGE_GUEST_URL_PATTERN);
    }

    public DeliveryForm deliveryForm = new DeliveryForm();
    public OrderSummaryWidget orderSummaryWidget = new OrderSummaryWidget();
    public PaymentForm paymentForm = new PaymentForm();

    public Map<String, String> getErrorMessagesFromDeliveryAddressForm() {
        return deliveryForm.getValidationErrorList();
    }

    public Map<String, String> getStrippedErrorMessagesFromDeliveryAddressForm() {
        return deliveryForm.getStrippedValidationErrorList();
    }

    public List<String> getValidationErrorsFromPaymentForm() {
        return paymentForm.getValidationErrorList();
    }

    public void pressBuyNowButtonForPaymentForm() {
        switchToIframe(By.xpath("//iframe[@id='chase']"));
        paymentForm.buyNowButton.jsClick();
    }
}
