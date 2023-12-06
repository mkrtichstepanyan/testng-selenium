package org.example.membership;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailsEditPage extends BasePage {

    @FindBy(xpath = "//iframe[@id = 'braintree-hosted-field-number']")
    public WebElement inputCardNumber;

    @FindBy(xpath = "//iframe[@id = 'braintree-hosted-field-expirationDate']")
    public WebElement inputExpiration;

    @FindBy(xpath = "//iframe[@id = 'braintree-hosted-field-cvv']")
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
        return super.isPageOpened(inputCardNumber, inputExpiration, inputCvv, cancelButton, saveButton);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }
}
