package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorsPage extends BasePage {

    @FindBy(tagName = "h1")
    public WebElement authorsText;

    @FindBy(xpath = "//div[@class='list-header']//a[@href='/authors?mode=tail']")
    public WebElement firstType;


    @FindBy(xpath = "//div[@class='list-header']//a[@href='/authors?mode=list']")
    public WebElement secondType;


    public WebElement[] webElements = {
            authorsText, firstType, secondType
    };

    public AuthorsPage(WebDriver driver) {
        super(driver);
    }
}
