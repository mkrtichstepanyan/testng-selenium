package org.example.vlume.pages.application.asidepanel.gift;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftPage extends BasePage {

    @FindBy(id="continue-choose")
    public WebElement giftPart;

    public GiftPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnChooseAGiftButton(){
        giftPart.click();
    }

    public boolean giftPageIsLoaded() {
        return super.pageIsLoaded(this.giftPart);
    }
}
