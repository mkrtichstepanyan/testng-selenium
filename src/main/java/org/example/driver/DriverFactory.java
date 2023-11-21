package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

public class DriverFactory {

    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeClass
    @Parameters(value = "browser")
    public void setupDriver(String browserName) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("start-maximized");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("start-maximized");

        WebDriver driver;
        switch (browserName.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
            }
            default -> throw new IllegalArgumentException("There isn't such browser ");
        }

        driverThreadLocal.set(driver);

    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @AfterClass
    public void closeDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
        }
    }
}
