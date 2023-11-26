package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

@Slf4j
public class DriverFactory {

    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeClass
    @Parameters("browser")
    public void setupDriver(String browser) {
        WebDriver driver;
        log.info("Setting up the driver for browser {}", browser);

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
        driverThreadLocal.set(driver);
    }

    public WebDriver getDriver() {
        return this.driverThreadLocal.get();
    }

    @AfterClass
    public void quitDriver() {
        log.info("Quite the driver");
        System.out.println("After class");
        WebDriver webDriver = this.driverThreadLocal.get();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}


