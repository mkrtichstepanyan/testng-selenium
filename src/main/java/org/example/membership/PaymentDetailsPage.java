package org.example.membership;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailsPage extends BasePage {

    @FindBy(xpath = "//b[@id= 'cardNumber']")
    public WebElement cardNumber;

    @FindBy(xpath = "//button[@id = 'changePaymentMethod']")
    public WebElement changePaymentMethodButton;

    protected PaymentDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(cardNumber, changePaymentMethodButton);
    }

    public void clickChangePaymentMethodButton() {
        changePaymentMethodButton.click();
    }

}
