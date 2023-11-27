package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftPage extends BasePage {

    @FindBy(tagName = "h1")
    public WebElement giveAGiftText;

    @FindBy(id = "description")
    public WebElement descriptionText;

    @FindBy(id = "continue-choose")
    public WebElement chooseAGiftButton;

    public WebElement[] webElements = {
            giveAGiftText, descriptionText, chooseAGiftButton
    };

    public GiftPage(WebDriver driver) {
        super(driver);
    }
}
