package org.example.pages.settings;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage {
    @FindBy(xpath = "//p[@class = 'edit-text']")
    public WebElement userPhoto;

    @FindBy(xpath = "//mat-card//img[@class = 'image-style']")
    public WebElement uploadANewPhoto;

    @FindBy(xpath = "//input[@id = 'firstName']")
    public WebElement inputUserFirstName;

    @FindBy(xpath = "//input[@id ='lastName']")
    public WebElement inputUserLastName;

    @FindBy(xpath = "//input[@id ='userEmail']")
    public WebElement userEmail;

    @FindBy(xpath = "//button[@id = 'saveButtonEditProfile']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@id = 'cancelButtonEditProfile']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@id = 'lastNameErrorMessage']")
    public WebElement lastNameErrorMessage;

    @FindBy(xpath = "//div[@id = 'firstNameErrorMessage']")
    public WebElement firstNameErrorMessage;

    protected EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(userPhoto, uploadANewPhoto, inputUserFirstName, inputUserLastName, userEmail, cancelButton, saveButton);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
