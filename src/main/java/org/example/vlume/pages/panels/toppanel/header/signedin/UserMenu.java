package org.example.vlume.pages.panels.toppanel.header.signedin;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMenu extends BasePage {
    @FindBy(css = "div[class='mat-menu-content ng-tns-c76-2']")
    public WebElement menuUserProfile;
    @FindBy(id = "settingsPage")
    public WebElement settingPart;
    @FindBy(id = "membershipPage")
    public WebElement membershipPart;
    @FindBy(id = "signOut")
    public WebElement signOut;
    @FindBy(id = "supportPage")
    public WebElement supportPart;

    public UserMenu(WebDriver driver) {
        super(driver);
    }

    public void pressOnSettingPart() {
        this.settingPart.click();
    }

    public void pressOnSignOutPart() {
        this.signOut.click();
    }

    public void pressOnSupportPart() {
        supportPart.click();
    }

    public void pressOnMembershipPart(){
        membershipPart.click();
    }

    public boolean userMenuIsLoaded() {
        return super.pageIsLoaded(this.menuUserProfile, this.membershipPart, this.settingPart,
                this.supportPart, this.signOut);
    }
}
