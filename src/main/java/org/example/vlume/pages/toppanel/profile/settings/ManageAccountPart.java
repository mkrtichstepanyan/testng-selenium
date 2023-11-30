package org.example.vlume.pages.toppanel.profile.settings;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAccountPart extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;
    @FindBy(id = "settingsPage")
    public WebElement settingPart;

    @FindBy(css = "p[class='delete-text']")
    public WebElement deleteAccount;

    protected ManageAccountPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSettingPart(){
        settingPart.click();
    }

    public void pressOnDeleteAccountLink(){
        deleteAccount.click();
    }

    public boolean manageAccountPartIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.settingPart,
                this.deleteAccount);
    }
}
