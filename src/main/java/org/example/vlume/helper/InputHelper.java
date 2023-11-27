package org.example.vlume.helper;

import org.openqa.selenium.WebElement;

public class InputHelper {

    public boolean fieldIsEmpty(WebElement element) {
        return element.getText().isEmpty();
    }

    public void clearField(WebElement element) {
        element.sendKeys("");
    }

    public void enterValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    public boolean fieldsAreEmpty(WebElement... elements) {
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                clearField(element);
            }
        }
        return true;
    }

    public String getValue(WebElement element) {
        return element.getText();
    }
}
