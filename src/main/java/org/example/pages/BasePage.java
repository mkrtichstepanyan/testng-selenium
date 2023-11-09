package org.example.pages;

import org.example.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    protected BasePage() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
