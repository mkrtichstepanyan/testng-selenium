package org.example.pages.panel;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPageWithoutLogIn extends BasePage {
    @FindBy(xpath = "//div[@class='ng-star-inserted']/a[@href='/']")
    public WebElement vlumeHomePage;

    @FindBy(id = "global")
    public WebElement global;

    @FindBy(xpath = "//span[@id='selectLanguage']")
    public WebElement language;

    @FindBy(xpath = "//a[@class='sign-in-button ng-star-inserted']")
    public WebElement signIn;


    public HeaderPageWithoutLogIn(WebDriver driver) {
        super(driver);
    }
}
