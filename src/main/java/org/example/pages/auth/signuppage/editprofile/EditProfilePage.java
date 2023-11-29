package org.example.pages.auth.signuppage.editprofile;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage {

    @FindBy(xpath = "//p[@class='title']")
    public WebElement editProfileTitle;
    @FindBy(xpath = "//div[@_ngcontent-lxp-c103]/img")
    public WebElement image;
    @FindBy(xpath = "//div[@class='left-container-content']//p")
    public WebElement uploadANewPhoto;
    @FindBy(xpath = "//p[@class='text-style']")
    public WebElement updateYourProfileDetails;
    @FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid']/div/div[1]/div[1]/p")
    public WebElement firstNameTitle;
    @FindBy(xpath = "//input[@id ='firstName']")
    public WebElement firstNameInput;
    @FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid']/div/div[1]/div[2]/p")
    public WebElement lastNameTitle;
    @FindBy(xpath = "//input[@id ='lastName']")
    public WebElement lastNameInput;
    @FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid']/div/div[2]/div[1]/p")
    public WebElement emailTitle;
    @FindBy(xpath = "//input[@id ='userEmail']")
    public WebElement emailInput;
    @FindBy(xpath = "//button[@id ='cancelButtonEditProfile']")
    public WebElement cancelButton;
    @FindBy(xpath = "//button[@id ='saveButtonEditProfile']")
    public WebElement saveButton;
    @FindBy(xpath = "//button[@id ='continueButton']")
    public WebElement continueButton;

    public void clickOnUploadANewPhoto() {
        uploadANewPhoto.click();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(editProfileTitle, image, uploadANewPhoto, updateYourProfileDetails,
                firstNameTitle, firstNameInput, lastNameTitle, lastNameInput, emailTitle,
                emailInput, cancelButton, saveButton, continueButton);
    }

    protected EditProfilePage(WebDriver driver) {
        super(driver);
    }
}
