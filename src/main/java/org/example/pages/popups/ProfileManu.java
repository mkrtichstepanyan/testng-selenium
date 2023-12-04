package org.example.pages.popups;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileManu extends BasePage {

    @FindBy(id = "membershipPage")
    public WebElement membershipPage;
    @FindBy(id = "settingsPage")
    public WebElement settingsPage;

    public ProfileManu(WebDriver driver) {
        super(driver);
    }

    public void pressOnMembership() {
        this.membershipPage.click();
    }

    public void pressOnSettings() {
        this.settingsPage.click();
    }

    public boolean profileManuIsLoaded() {
        return super.pageIsLoaded(this.membershipPage, this.settingsPage);
    }

}
