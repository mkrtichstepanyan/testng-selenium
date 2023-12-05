package org.example.membership;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentMethodePage extends BasePage {

    @FindBy(xpath = "//button[@id = 'addPaymentMethod']")
    public WebElement addPaymentMethod;

    @FindBy(xpath = "//div[@id = 'paypal-animation-content']")
    public WebElement payPal;

    public PaymentMethodePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(addPaymentMethod, payPal);
    }

    public void clickAddPaymentMethod() {
        addPaymentMethod.click();
    }

    public void clickPayPal() {
        payPal.click();
    }
}
