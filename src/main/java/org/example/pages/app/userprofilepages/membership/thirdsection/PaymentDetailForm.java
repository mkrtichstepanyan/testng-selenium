package org.example.pages.app.userprofilepages.membership.thirdsection;

import org.example.models.BankCard;
import org.example.pages.BasePage;
import org.example.providers.modelprovider.BankCardProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentDetailForm extends PaymentDiv {

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-number']")
    public WebElement cardNumberField;
    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-expirationDate']")
    public WebElement expirationDataField;
    @FindBy(css = "//iframe[@id='braintree-hosted-field-cvv']")
    public WebElement cvvField;
    @FindBy(id = "buttonCancel")
    public WebElement cancelButton;
    @FindBy(id = "buttonSave")
    public WebElement saveButton;

    public PaymentDetailForm(WebDriver driver) {
        super(driver);
    }

    public void pressOnCancelButton() {
        cancelButton.click();
    }

    public void pressOnSaveButton() {
        saveButton.click();
    }

    public void enterData() {
        BankCardProvider bankCardProvider = new BankCardProvider();
        BankCard bankCard = bankCardProvider.createValidCardData();
        String cardNumber = bankCard.getCardNumber();
        String expirationDate = bankCard.getExpirationDate();
        String cvv = bankCard.getCvv();

        driver.switchTo().frame(cardNumberField);
        this.cardNumberField.sendKeys(cardNumber);

        driver.switchTo().parentFrame().switchTo().frame(expirationDataField);
        this.expirationDataField.sendKeys(expirationDate);

        driver.switchTo().parentFrame().switchTo().frame(cvvField);
        this.cvvField.sendKeys(cvv);
    }

    public boolean paymentDetailFormIsLoaded() {
        return super.pageIsLoaded(this.cardNumberField, this.cvvField, this.expirationDataField,
                this.cancelButton, this.saveButton);
    }
}
