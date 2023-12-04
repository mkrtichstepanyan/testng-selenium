package org.example.pages.app.userprofilepages.membership.thirdsection;

import org.example.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class PaymentMethodsFirstState extends PaymentDiv {
    @FindBy(id = "addPaymentMethod")
    public WebElement debitOrCreditCard;
    @FindBy(xpath = "//div[@aria-label='PayPal']")
    public WebElement payPal;

    @FindBy(xpath = "//iframe[@title='PayPal']")
    private WebElement iframePayPal;

    public PaymentMethodsFirstState(WebDriver driver) {
        super(driver);
    }


    public void pressOnPayPalButton() {
        String devWindowHandle = driver.getWindowHandle();
        waitHelper.waitForAllElementsToBeVisible(this.iframePayPal);
        driver.switchTo().frame(this.iframePayPal);
        waitHelper.waitUntilElementWillBeVisible(this.payPal);
        payPal.click();
        switchAndClosePayPalWindow();
        driver.switchTo().window(devWindowHandle);
    }

    private void switchAndClosePayPalWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        int index = 0;
        for (String windowHandle : windowHandles) {
            if (index == 1) driver.switchTo().window(windowHandle);
            index++;
        }
    }

    public void pressOnDebitOrCreditCardButton() {
        waitHelper.waitUntilElementWillBeVisible(this.debitOrCreditCard);
        debitOrCreditCard.click();
    }

    public boolean paymentMethodsPartIsLoaded() {
        try {
            waitHelper.waitUntilElementWillBeVisible(this.debitOrCreditCard, 30);
            waitHelper.waitUntilElementWillBeVisible(this.iframePayPal, 30);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
