package org.example.vlume.helper;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper {
    private WebDriver driver;
    public WebDriverWait wait;
    private final int DEFAULT_TIME_OUT = 10;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.DEFAULT_TIME_OUT));
    }

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForAllElementsToBeVisible(WebElement... elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitUntilElementWillBeVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    @SneakyThrows
    public void waitForSeconds(int seconds) {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
