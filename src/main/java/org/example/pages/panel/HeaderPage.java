package org.example.pages.panel;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {
    @FindBy(xpath = "//div[@class='ng-star-inserted']/a[@href='/']")
    public WebElement vlumeHomePage;

    @FindBy(id = "global")
    public WebElement global;

    @FindBy(xpath = "//span[@id='selectLanguage']")
    public WebElement language;

    @FindBy(xpath = "//img[@src='../../assets/img/profile_image.png']")
    public WebElement profilePicture;

    @FindBy(xpath = "//img[@src='https://img.icons8.com/material-rounded/24/000000/sort-down.png']")
    public WebElement profileProperties;


    public HeaderPage(WebDriver driver) {
        super(driver);
    }
}
