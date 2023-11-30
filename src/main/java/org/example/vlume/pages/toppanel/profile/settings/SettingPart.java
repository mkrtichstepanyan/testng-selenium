package org.example.vlume.pages.toppanel.profile.settings;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingPart extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(css = "div[class='mat-menu-content ng-tns-c76-2']")
    public WebElement menuUserProfile;
    @FindBy(id = "settingsPage")
    public WebElement settingPage;

    public SettingPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSettingPart(){
        settingPage.click();
    }

    public boolean settingPartIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.menuUserProfile,
                this.settingPage);
    }
}
