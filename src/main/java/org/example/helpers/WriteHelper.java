package org.example.helpers;

import dataProvider.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

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
}
