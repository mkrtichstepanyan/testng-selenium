package org.example.helpers;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private final int DEFAULT_TIME_OUT = 15;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.DEFAULT_TIME_OUT));
    }

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public List<WebElement> waitForElementsToBeVisible(WebElement... elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @SneakyThrows
    public void waitForSeconds(int seconds) {
        TimeUnit.SECONDS.sleep(seconds);
    }
}