package org.example.pages.settings.mat_card;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//p[@class = 'title'][text() = 'Profile']")
    public WebElement profileTitle;

    @FindBy(xpath = "//app-user-info-card//img[@class = 'image-style']")
    public WebElement userPhoto;

    @FindBy(xpath = "//p[@class = 'edit-text']")
    public WebElement editText;

    @FindBy(xpath = "//app-user-info-card//p[text() = 'FULL NAME']")
    public WebElement fullNameTitle;

    @FindBy(xpath = "//app-user-info-card//p[@id = 'userFullName']")
    public WebElement userFullName;

    @FindBy(xpath = "//app-user-info-card//p[text() = 'EMAIL']")
    public WebElement emailTitle;

    @FindBy(xpath = "//app-user-info-card//p[@id = 'userEmail']")
    public WebElement userEmail;

    @FindBy(xpath = "//p[@id= 'editProfile']")
    public WebElement editProfile;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(profileTitle, userPhoto, editText, fullNameTitle, userFullName, emailTitle, userEmail, editProfile);
    }

    public void clickEditProfileButton() {
        editProfile.click();
    }
}
