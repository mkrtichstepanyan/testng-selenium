package org.example.helpers;

import dataProvider.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@Slf4j
public class WriteHelper {
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

    @SneakyThrows
    public void writeValidSecondCardNumber(WebElement cartNumber, WebElement expiration, WebElement cvv) {
        log.info("Change cart number");
        cartNumber.click();
        cartNumber.click();
        cartNumber.sendKeys(
                Keys.NUMPAD5, Keys.NUMPAD5, Keys.NUMPAD5, Keys.NUMPAD5,
                Keys.NUMPAD5, Keys.NUMPAD5, Keys.NUMPAD5, Keys.NUMPAD5,
                Keys.NUMPAD5, Keys.NUMPAD5, Keys.NUMPAD5, Keys.NUMPAD5,
                Keys.NUMPAD4, Keys.NUMPAD4, Keys.NUMPAD4, Keys.NUMPAD4);

        log.info("Change cart expiration");
        expiration.click();
        expiration.click();
        expiration.click();
        expiration.sendKeys(Keys.NUMPAD9);

        log.info("Change cart cvv");
        cvv.click();
        cvv.click();
        cvv.click();
        cvv.sendKeys(Keys.NUMPAD1, Keys.NUMPAD2, Keys.NUMPAD3);
    }

    public void writeValidFirstCardNumber(WebElement cartNumber, WebElement expiration, WebElement cvv) {
        log.info("Change cart number");
        cartNumber.sendKeys(
                Keys.NUMPAD4, Keys.NUMPAD1, Keys.NUMPAD1, Keys.NUMPAD1,
                Keys.NUMPAD1, Keys.NUMPAD1, Keys.NUMPAD1, Keys.NUMPAD1,
                Keys.NUMPAD1, Keys.NUMPAD1, Keys.NUMPAD1, Keys.NUMPAD1,
                Keys.NUMPAD1, Keys.NUMPAD1, Keys.NUMPAD1, Keys.NUMPAD1);

        log.info("Change cart expiration");
        expiration.sendKeys(Keys.NUMPAD1, Keys.NUMPAD2, Keys.NUMPAD3, Keys.NUMPAD0);

        log.info("Change cart cvv");
        cvv.sendKeys(Keys.NUMPAD1, Keys.NUMPAD2, Keys.NUMPAD3);
    }

}
