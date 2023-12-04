package org.example.pages.panels.toppanel.signedIn;

import org.example.pages.panels.toppanel.AuthElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfile extends AuthElement {

    public UserMenu userMenu;
    @FindBy(css = "img[id='userProfile'")
    public WebElement userProfile;

    public UserProfile(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon() {
        userProfile.click();
        userMenu = new UserMenu(driver);
        this.userMenu.userMenuIsLoaded();
    }

    public boolean userProfileIsLoaded(){
       return super.pageIsLoaded(this.userProfile);
    }
}
