package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyListPage extends BasePage {

    @FindBy(tagName = "h1")
    public WebElement myListText;

    @FindBy(xpath = "//div[@class='item-style']")
    public WebElement plus;

    @FindBy(xpath = "//p[@class='ellipsis-text reading-list-title-text']")
    public WebElement newListsText;

    public WebElement[] webElements = {
            myListText, plus, newListsText
    };

    public MyListPage(WebDriver driver) {
        super(driver);
    }
}
