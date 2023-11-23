package org.example.helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WaitHelper {
    private final Logger logger = LoggerFactory.getLogger(WaitHelper.class);

    private WebDriver driver;

    private WebDriverWait wait;

    private final int DEFAULT_TIME_OUT = 10;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.DEFAULT_TIME_OUT));
    }

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        logger.info("Waiting for element to be clickable: {}", webElement);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        logger.info("Waiting for element to be clickable: {}", locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForElementToBeVisibility(WebElement webElement) {
        logger.info("Waiting for element to be visible: {}", webElement);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForElementToBeVisibility(By locator) {
        logger.info("Waiting for element to be visible: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
