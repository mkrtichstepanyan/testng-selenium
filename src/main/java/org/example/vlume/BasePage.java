package org.example.vlume;

import org.example.vlume.helper.InputHelper;
import org.example.vlume.helper.WaitHelper;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected InputHelper inputHelper;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
        inputHelper = new InputHelper();
    }

    public boolean pageIsLoaded(WebElement... elements) {
        try {
            waitHelper.waitForAllElementsToBeVisible(elements);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
