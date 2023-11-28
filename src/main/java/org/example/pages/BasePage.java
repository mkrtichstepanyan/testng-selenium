package org.example.pages;

import org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WaitHelper waitHelper;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper= new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(WebElement ... elements) {
        List<WebElement> webElement = waitHelper.waitForElementsToBeVisible(elements);
        return webElement.size() > 0;
    }
}
