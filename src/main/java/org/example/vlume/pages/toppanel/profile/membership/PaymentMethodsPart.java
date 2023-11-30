package org.example.vlume.pages.toppanel.profile.membership;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentMethodsPart extends BasePage {

    @FindBy(id="addPaymentMethod")
    public WebElement debitOrCreditCard;

    @FindBy(id="number")
    public WebElement cardNumber;

    @FindBy(id="expirationDate")
    public WebElement expirationData;

    @FindBy(css = "div[id='cvv']")
    public WebElement cvv;

    @FindBy(id="buttonCancel")
    public WebElement cancelButton;

    @FindBy(id="buttonSave")
    public WebElement saveButton;

    @FindBy(id="paypal-animation-content")
    public WebElement payPal;

    public PaymentMethodsPart(WebDriver driver) {
        super(driver);
    }

    public void enterCardNumber(String cardNumber) {
        this.cardNumber.sendKeys(cardNumber);
    }

    public void enterExpirationData(String expirationData) {
        this.expirationData.sendKeys(expirationData);
    }
    public void enterCvv(String cvv) {
        this.cvv.sendKeys(cvv);
    }

    public void pressOnDebitOrCreditCardButton(){
        debitOrCreditCard.click();
    }

    public void pressOnCardNumberField(){
        cardNumber.click();
    }

    public void pressOnExpirationDataField(){
        expirationData.click();
    }

    public void pressOnCvvField(){
        cvv.click();
    }

    public void pressOnCancelButton(){
        cancelButton.click();
    }

    public void pressOnSaveButton(){
        saveButton.click();
    }

    public void pressOnPayPalButton(){
        payPal.click();
    }

    public boolean paymentMethodsPartIsLoaded(){
        return super.pageIsLoaded(this.debitOrCreditCard, this.payPal,
                this.cvv, this.saveButton, this.cancelButton, this.cardNumber, this.expirationData);
    }
}
