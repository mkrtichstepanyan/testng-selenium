package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    private ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    //    @Parameters("browser")
    public void setUpDriver(String browser) {
        logger.error("printed");
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Please specify browser name");
        }
        driver.manage().window().maximize();
        threadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return this.threadLocal.get();
    }

    public void closeDriver() {
        WebDriver driver = this.threadLocal.get();
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
