package org.example.helpers;


import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.example.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@UtilityClass
public class WaitHelper {

    Wait<WebDriver> wait;

    private final int DEFAULT_TIME_OUT = 10;

    public WebDriver driver = DriverFactory.getDriver();

    public WebElement waitUntilElementWillBeVisible(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIME_OUT));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitUntilElementWillBeVisible(WebElement webElement, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }


    @SneakyThrows
    void waitForSeconds(int seconds) {
        TimeUnit.SECONDS.sleep(seconds);
    }
}
