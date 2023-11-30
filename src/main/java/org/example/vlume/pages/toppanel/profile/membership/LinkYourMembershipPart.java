package org.example.vlume.pages.toppanel.profile.membership;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkYourMembershipPart extends BasePage {

    @FindBy(id = "linkMembershipButton")
    public WebElement linkMembershipButton;

    public LinkYourMembershipPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnLinkMembershipButton() {
        linkMembershipButton.click();
    }

    public boolean linkYourMembershipPartIsLoaded() {
        return super.pageIsLoaded(this.linkMembershipButton);
    }
}
