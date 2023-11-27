package org.example.pages;

import org.example.driver.DriverFactory;
import org.example.helpers.InputHelper;
import org.example.helpers.WaitHelper;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
