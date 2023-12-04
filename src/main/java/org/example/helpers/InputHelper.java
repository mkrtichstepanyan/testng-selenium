package org.example.helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class InputHelper {

    public boolean fieldsAreEmpty(WebElement... elements) {
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                clearField(element);
            }
        }
        return true;
    }

    public void clearField(WebElement element) {
        element.sendKeys(Keys.chord(Keys.CONTROL), Keys.BACK_SPACE);
//        element.sendKeys("");
//        element.clear();
    }

    public String getValue(WebElement element) {
        return element.getText();
    }
}
