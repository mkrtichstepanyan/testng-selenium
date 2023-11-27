package org.example.vlume.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverFactory {

    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
//    Logger logger = LoggerFactory.getLogger(DriverFactory.class);


    @BeforeClass
    @Parameters("browser")
    public void setupDriver(@Optional("Chrome") String browser) {
        WebDriver driver;
//        logger.info("setting up the driver for browser {}", browser);

        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
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
        WebDriver webDriver = this.driverThreadLocal.get();
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
