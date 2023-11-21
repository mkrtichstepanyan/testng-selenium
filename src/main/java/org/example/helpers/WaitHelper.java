package org.example.helpers;


import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.example.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private Wait<WebDriver> wait;

    private final int DEFAULT_TIME_OUT = 10;

    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
    }

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    @SneakyThrows
    void waitForSeconds(int seconds) {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
