package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.driver.DriverFactory;
import org.example.helpers.InputHelper;
import org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

@Slf4j
public class BaseTest {
    protected WaitHelper waitHelper;
    protected DriverFactory driverFactory;
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected InputHelper inputHelper;

    @BeforeClass
    public void setUp() {
        log.info("***************************");
        log.info("Class Name: {}", this.getClass().getName());
        driverFactory = new DriverFactory();
        driverFactory.setUpDriver("chrome");
        driver = driverFactory.getDriver();
        waitHelper = new WaitHelper(driver);
        inputHelper = new InputHelper();
    }

    @AfterClass
    public void callQuit() {
        waitHelper.waitForSeconds(10);
        driverFactory.closeDriver();
    }
}
