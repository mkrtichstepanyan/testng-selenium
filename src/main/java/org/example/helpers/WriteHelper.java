package org.example.helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class WriteHelper {

    public void clearInput(WebElement webElement) {
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }
}
