package org.example.vlume.pages.panels.toppanel.profile.settings.profileparts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePart extends ProfilePartDiv {
    @FindBy(css = "div[class='left-bottom-container']")
    public WebElement editPhoto;

    @FindBy(id = "editProfile")
    public WebElement editProfile;

    @FindBy(css = "p[class='edit-text']")
    public WebElement uploadANewPhoto;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "userEmail")
    public WebElement email;

    @FindBy(id = "cancelButtonEditProfile")
    public WebElement cancelButton;

    @FindBy(id = "saveButtonEditProfile")
    public WebElement saveButton;

    protected ProfilePart(WebDriver driver) {
        super(driver);
    }

    public void pressOnEditPhoto() {
        editProfile.click();
    }

    public void pressOnUploadANewPhoto() {
        uploadANewPhoto.click();
    }

    public void pressOnFirstNameField() {
        firstName.click();
    }

    public void pressOnLastNameField() {
        lastName.click();
    }

    public void pressOnEmailField() {
        email.click();
    }

    public void pressOnCancelButton() {
        cancelButton.click();
    }

    public void pressOnSaveButton() {
        saveButton.click();
    }

    public boolean profilePartIsLoaded() {
        return super.pageIsLoaded(this.editProfile, this.editPhoto, this.firstName, this.lastName,
                this.email, this.cancelButton, this.saveButton, this.uploadANewPhoto);
    }
}
