package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div//p[@id = 'homeButton']")
    public WebElement homeButton;

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(homeButton);
    }
}