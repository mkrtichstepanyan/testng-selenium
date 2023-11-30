package org.example.vlume.pages.toppanel.profile.settings;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePart extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;
    @FindBy(id = "settingsPage")
    public WebElement settingPart;

    @FindBy(css = "div[class='left-bottom-container']")
    public WebElement editPhoto;

    @FindBy(id="editProfile")
    public WebElement editProfile;

    @FindBy(css = "p[class='edit-text']")
    public WebElement uploadANewPhoto;

    @FindBy(id="firstName")
    public WebElement firstName;

    @FindBy(id="lastName")
    public WebElement lastName;

    @FindBy(id="userEmail")
    public WebElement email;

    @FindBy(id="cancelButtonEditProfile")
    public WebElement cancelButton;

    @FindBy(id="saveButtonEditProfile")
    public WebElement saveButton;

    protected ProfilePart(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSettingPart(){
        settingPart.click();
    }

    public void pressOnEditPhoto(){
        editProfile.click();
    }

    public void pressOnUploadANewPhoto(){
        uploadANewPhoto.click();
    }

    public void pressOnFirstNameField(){
        firstName.click();
    }

    public void pressOnLastNameField(){
        lastName.click();
    }

    public void pressOnEmailField(){
        email.click();
    }

    public void pressOnCancelButton(){
        cancelButton.click();
    }

    public void pressOnSaveButton(){
        saveButton.click();
    }

    public boolean profilePartIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.settingPart,
                this.editProfile, this.editPhoto, this.firstName, this.lastName,
                this.email, this.cancelButton, this.saveButton, this.uploadANewPhoto);
    }
}
