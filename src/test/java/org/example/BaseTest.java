package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;

import java.util.Set;

@Slf4j
public class BaseTest extends DriverFactory {
    protected final String WELCOME_PAGE_URL = "https://dev.vlume.com/";
    protected final String SIGN_IN_PAGE_URL = "https://dev.vlume.com/sign-in";
    protected final String FORGOT_PASSWORD_PAGE_URL = "https://dev.vlume.com/forgot-password";
    protected final String SIGN_UP_PAGE_URL = "https://dev.vlume.com/sign-up";
    protected final String AFTER_SIGN_UP_PAGE_URL = "https://dev.vlume.com/onboarding";

    public WebDriver driver;
    public WaitHelper waitHelper;
    public String currentUrl;

    @BeforeClass
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
    }

    public String theNewWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            currentUrl = handle;
        }
        return currentUrl;
    }

    public void goToURL(String url) {
        log.info("Go to URL {}", url);
        driver.get(url);
    }
}