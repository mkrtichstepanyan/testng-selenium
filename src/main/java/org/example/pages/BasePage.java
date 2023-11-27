package org.example.pages;

import org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BasePage {
    protected WaitHelper waitHelper;
    private Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger.info("{} page initialized", this.getClass().getSimpleName());

    }

    protected void isPageOpened(WebElement... elements) {
        waitHelper.waitForElementsToBeVisible(elements);
    }
}
