package org.example.vlume.pages.panels.toppanel.header.signedin;

import org.example.vlume.pages.panels.toppanel.header.AuthenticationElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfileIcon extends AuthenticationElement {

    public UserMenu userMenu;

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    public UserProfileIcon(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon() {
        userProfile.click();
        userMenu = new UserMenu(driver);
        this.userMenu.userMenuIsLoaded();
    }
}
