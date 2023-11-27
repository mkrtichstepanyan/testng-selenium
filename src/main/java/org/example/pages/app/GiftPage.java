package org.example.pages.app;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftPage extends BasePage {

    @FindBy(xpath = "//mat-card[@class='mat-card boxSize card-style']")
    public WebElement giftPart;

    public GiftPage(WebDriver driver) {
        super(driver);
    }

    public boolean giftPageIsLoaded() {
        return super.pageIsLoaded(this.giftPart);
    }
}
