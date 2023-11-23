package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


@Slf4j(topic = "Driver1")
public class DriverFactory {
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeClass
    @Parameters("browser")
    public void setupDriver(String browser) {
        WebDriver driver;
        log.trace("Setting up the driver for browser {}", browser);
        log.debug("Setting up the driver for browser {}", browser);
        log.info("Setting up the driver for browser {}", browser);
        log.warn("Setting up the driver for browser {}", browser);
        log.error("Setting up the driver for browser {}", browser);

        System.exit(0);

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
        System.out.println("AfterTest");
        WebDriver webDriver = this.driverThreadLocal.get();

        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
