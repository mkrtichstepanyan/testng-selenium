package org.example.vlume.pages.toppanel.profile.signout;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignOutPart extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(css = "div[class='mat-menu-content ng-tns-c76-2']")
    public WebElement menuUserProfile;
    @FindBy(id="signOut")
    public WebElement signOut;
    public SignOutPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSignOutPart(){
        signOut.click();
    }

    public boolean signOutPartIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.menuUserProfile,
                this.signOut);
    }
}
