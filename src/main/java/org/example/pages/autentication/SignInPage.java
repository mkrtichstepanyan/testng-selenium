package org.example.pages.autentication;

import org.example.models.User;
import org.example.pages.BasePage;
import org.example.providers.modelprovider.UserProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(id = "username")
    public WebElement emailField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "loginButton")
    public WebElement signInButton;
    @FindBy(id = "forgotPassword")
    public WebElement forgotPasswordLink;
    @FindBy(xpath = "//button[@class='btn__vlume btn_login_signup btn_signup']")
    public WebElement signUpButton;
    @FindBy(id = "facebookButton")
    public WebElement continueWithFbButton;
    @FindBy(id = "googleButton")
    public WebElement signInWithGoogle;
    @FindBy(xpath = "//snack-bar-container//span")
    public WebElement messageBox;
    UserProvider userProvider;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public String getMessageBoxText() {
        return this.messageBox.getText();
    }

    public void enterEmail(String email) {
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        this.signInButton.click();
    }

    public void clickOnForgotPassword() {
        this.forgotPasswordLink.click();
    }

    public void clickOnSignUpButton() {
        this.signUpButton.click();
    }

    public void clickOnFbButton() {
        this.continueWithFbButton.click();
    }

    public void clickOnGoogleButton() {
        this.signInWithGoogle.click();
    }

    public void signInWithValidData(){
        userProvider = new UserProvider();
        User validUser = userProvider.createValidUser();
        String email = validUser.getEmail();
        String password = validUser.getPassword();

        waitHelper.waitForAllElementsToBeVisible(this.emailField, this.passwordField, this.signInButton);
        inputHelper.fieldsAreEmpty(this.emailField, this.passwordField, this.signInButton);
        this.emailField.sendKeys(email);
        this.passwordField.sendKeys(password);
        this.signInButton.click();
    }


    public boolean signInPageIsLoaded() {
        return super.pageIsLoaded(
                this.signUpButton, this.signInButton,
                this.continueWithFbButton, this.signInWithGoogle,
                this.emailField, this.passwordField, this.forgotPasswordLink);
    }
}
