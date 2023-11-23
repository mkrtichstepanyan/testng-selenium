package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DriverFactory {
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    @BeforeMethod
    @Parameters("browser")
    public void setupDriver(String browser) {
        WebDriver driver;
        logger.info("Setting up the driver for {}", browser);
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "safari" -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            default -> {
                logger.error("Invalid browser specified: {}", browser);
                throw new IllegalArgumentException("Please specify browser name");
            }
        }
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);

        logger.info("{} driver setup successfully", browser);
    }

    public WebDriver getDriver() {
        return this.driverThreadLocal.get();
    }

    @AfterMethod
    public void quitDriver() {
        logger.info("Quitting the driver");
        WebDriver webDriver = this.driverThreadLocal.get();

        if (webDriver != null) {
            webDriver.quit();
            logger.info("Driver quit successfully");
        }
    }
}
