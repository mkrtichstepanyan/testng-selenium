package org.example.pages.settings;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {

    private final ProfilePage profilePage;

    private final EditProfilePage editProfilePage;

    @FindBy(xpath = "//app-user-info-card")
    public WebElement userInfo;

    public SettingsPage(WebDriver driver) {
        super(driver);
        profilePage = new ProfilePage(driver);
        editProfilePage = new EditProfilePage(driver);
    }

    public ProfilePage getProfilePage() {
        return profilePage;
    }

    public EditProfilePage getEditProfilePage() {
        return editProfilePage;
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(userInfo);
    }
}


