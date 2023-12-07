package org.example.helpers;

import dataProvider.User;
import dataProvider.cart.CartsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.membership.PaymentDetailsEditPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class WriteHelper {
    private final Wait<WebDriver> wait;

    private static final int DEFAULT_TIME_OUT = 10; //s

    private WebDriver driver;

    public WriteHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
    }

    public void clearInput(WebElement webElement) {
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    public void returnLoginedUserFirstName(WebElement webElement) {
        clearInput(webElement);
        webElement.sendKeys(User.loginedUser.getFirstName());
    }

    public void returnLoginedUserLastName(WebElement webElement) {
        clearInput(webElement);
        webElement.sendKeys(User.loginedUser.getLastName());
    }

    public void changeValidSecondCardNumber(PaymentDetailsEditPage paymentDetailsEditPage) {
        log.info("Change cart number");
        driver.switchTo().frame(paymentDetailsEditPage.frameCardNumber);
        paymentDetailsEditPage.inputCardNumber.sendKeys(CartsProvider.validSecondCart.getNumber());
        driver.switchTo().defaultContent();

        log.info("Change cart expiration");
        driver.switchTo().frame(paymentDetailsEditPage.frameExpiration);
        paymentDetailsEditPage.inputExpiration.sendKeys(CartsProvider.validSecondCart.getExpiration());
        driver.switchTo().defaultContent();

        log.info("Change cart cvv");
        driver.switchTo().frame(paymentDetailsEditPage.frameCvv);
        paymentDetailsEditPage.inputCvv.sendKeys(CartsProvider.validSecondCart.getCvv());
        driver.switchTo().defaultContent();
    }

    public void changeValidFirstCardNumber(PaymentDetailsEditPage paymentDetailsEditPage) {
        log.info("Change cart number");
        driver.switchTo().frame(paymentDetailsEditPage.frameCardNumber);
        paymentDetailsEditPage.inputCardNumber.sendKeys(CartsProvider.validFirstCart.getNumber());
        driver.switchTo().defaultContent();

        log.info("Change cart expiration");
        driver.switchTo().frame(paymentDetailsEditPage.frameExpiration);
        paymentDetailsEditPage.inputExpiration.sendKeys(CartsProvider.validFirstCart.getExpiration());
        driver.switchTo().defaultContent();

        log.info("Change cart cvv");
        driver.switchTo().frame(paymentDetailsEditPage.frameCvv);
        paymentDetailsEditPage.inputCvv.sendKeys(CartsProvider.validFirstCart.getCvv());
        driver.switchTo().defaultContent();
    }

}
