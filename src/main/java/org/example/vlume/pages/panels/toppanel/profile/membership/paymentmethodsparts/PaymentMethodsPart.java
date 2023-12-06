package org.example.vlume.pages.panels.toppanel.profile.membership.paymentmethodsparts;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class PaymentMethodsPart extends BasePage {

    @FindBy(id = "addPaymentMethod")
    public WebElement debitOrCreditCard;

    @FindBy(css = "iframe[title='Secure Credit Card Frame - Credit Card Number']")
    public WebElement cardNumberIframe;

    @FindBy(id="braintree-hosted-field-number")
    public WebElement cardNumber;

    @FindBy(id = "expirationDate")
    public WebElement expirationData;

    @FindBy(css = "div[id='cvv']")
    public WebElement cvv;

    @FindBy(id = "buttonCancel")
    public WebElement cancelButton;

    @FindBy(id = "buttonSave")
    public WebElement saveButton;

    @FindBy(id = "changePaymentMethod")
    public WebElement changePaymentMethodButton;

    @FindBy(css = "iframe[title='PayPal']")
    public WebElement payPalIFrame;

    @FindBy(css = "div[class='paypal-button paypal-button-number-0 paypal-button-layout-horizontal paypal-button-shape-pill paypal-button-branding-branded paypal-button-number-single paypal-button-env-sandbox paypal-should-focus paypal-button-label-paypal paypal-button-color-gold paypal-button-logo-color-blue']")
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

    public void pressOnDebitOrCreditCardButton() {
        debitOrCreditCard.click();
    }

    public void pressOnCardNumberField() {
        waitHelper.waitUntilElementWillBeVisible(this.cardNumberIframe);
        driver.switchTo().frame(cardNumberIframe);
        waitHelper.waitForElementToBeClickable(this.cardNumber);
        waitHelper.waitForSeconds(2);
        cardNumber.click();
    }

    public void pressOnExpirationDataField() {
        expirationData.click();
    }

    public void pressOnCvvField() {
        cvv.click();
    }

    public void pressOnCancelButton() {
        cancelButton.click();
    }

    public void pressOnSaveButton() {
        saveButton.click();
    }

    public void pressOnChangePaymentMethodButton() {
        waitHelper.waitUntilElementWillBeVisible(this.changePaymentMethodButton);
        changePaymentMethodButton.click();
    }

    public void pressOnPayPalButton() {
        String devWindowHandle = driver.getWindowHandle();
        waitHelper.waitUntilElementWillBeVisible(this.payPalIFrame);
        driver.switchTo().frame(payPalIFrame);
        waitHelper.waitForElementToBeClickable(this.payPal);
        waitHelper.waitForSeconds(2);
        payPal.click();
        waitHelper.waitForSeconds(3);
        switchAndClosePayPalWindow();
        waitHelper.waitForSeconds(3);
        driver.switchTo().window(devWindowHandle);
    }

    private void switchAndClosePayPalWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        int index = 0;
        for (String windowHandle : windowHandles) {
            if (index == 1) {
                driver.switchTo().window(windowHandle);
                driver.close();
            }
            index++;
        }
    }

    public boolean paymentMethodsPartIsLoaded() {
        return super.pageIsLoaded(this.cvv, this.saveButton, this.cancelButton,
                this.cardNumber, this.expirationData);
    }
}
