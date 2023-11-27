package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class DriverFactory {

    private final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    Logger logger = LoggerFactory.getLogger("FileLogger");

    @BeforeClass
    @Parameters(value = "browser")
    public void setupDriver(String browserName) {
        WebDriver driver;
        logger.info("Create driver for browser {}", browserName);
        switch (browserName.toLowerCase()) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--incognito");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
            }
            default -> throw new IllegalArgumentException("There isn't such browser ");
        }
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        logger.debug("get driver {}", driverThreadLocal.get().toString());
        return driverThreadLocal.get();
    }

    @AfterClass
    public void closeDriver() {
        logger.debug("close driver {}", driverThreadLocal.get().toString());
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
        }
    }
}
