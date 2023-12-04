package org.example.pages.app.userprofilepages.membership.secondsection;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkYourMembershipFirstState extends LinkMembershipDiv {
    @FindBy(id="linkMembershipButton")
    public WebElement linkMembershipButton;

    public LinkYourMembershipFirstState(WebDriver driver) {
        super(driver);
    }

    public void pressOnLinkMembershipButton(){
        linkMembershipButton.click();
    }

    public boolean linkYourMembershipFirstStateIsLoaded(){
        return super.pageIsLoaded(this.linkMembershipButton);
    }
}
