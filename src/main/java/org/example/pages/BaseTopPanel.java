package org.example.pages;

import org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BaseTopPanel {

    protected WebDriver driver;
    protected WaitHelper waitHelper;
    public BaseTopPanel(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isTopPanelVisible(WebElement... elements) {
        List<WebElement> webElements = waitHelper.waitForElementsToBeVisible(elements);
        return webElements.size() > 0;
    }
}
