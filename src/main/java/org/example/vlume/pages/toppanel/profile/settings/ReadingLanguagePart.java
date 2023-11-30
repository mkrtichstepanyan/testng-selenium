package org.example.vlume.pages.toppanel.profile.settings;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadingLanguagePart extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;
    @FindBy(id = "settingsPage")
    public WebElement settingPart;

    @FindBy(id="languageButton0")
    public WebElement iCanReadEnglishButton;

    @FindBy(id="languageButton1")
    public WebElement iCanReadArmenianButton;


    protected ReadingLanguagePart(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSettingPart(){
        settingPart.click();
    }

    public void pressOnICanReadEnglishButton(){
        iCanReadEnglishButton.click();
    }

    public void pressOnICanReadArmenianButton(){
        iCanReadArmenianButton.click();
    }

    public boolean readingLanguagePartIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.settingPart,
                this.iCanReadEnglishButton, this.iCanReadArmenianButton);
    }
}
