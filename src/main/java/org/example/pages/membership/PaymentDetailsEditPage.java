package org.example.pages.membership;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailsEditPage extends BasePage {

    @FindBy(xpath = "//iframe[@id = 'braintree-hosted-field-number']")
    public WebElement frameCardNumber;

    @FindBy(xpath = "//input[@id = 'credit-card-number']")
    public WebElement inputCardNumber;

    @FindBy(xpath = "//iframe[@id = 'braintree-hosted-field-expirationDate']")
    public WebElement frameExpiration;

    @FindBy(xpath = "//input[@id = 'expiration']")
    public WebElement inputExpiration;

    @FindBy(xpath = "//iframe[@id = 'braintree-hosted-field-cvv']")
    public WebElement frameCvv;

    @FindBy(xpath = "//input[@id = 'cvv']")
    public WebElement inputCvv;

    @FindBy(xpath = "//button[@id = 'buttonCancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[@id = 'buttonSave']")
    public WebElement saveButton;


    public PaymentDetailsEditPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(frameCardNumber, frameExpiration, frameCvv, cancelButton, saveButton);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }
}
