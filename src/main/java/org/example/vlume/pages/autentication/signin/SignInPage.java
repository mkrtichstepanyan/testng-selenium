package org.example.vlume.pages.autentication.signin;

import org.example.vlume.BasePage;
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
    public WebElement forgotPassword;

    @FindBy(xpath = "//button[@class='btn__vlume btn_login_signup btn_signup']")
    public WebElement signUpButton;

    @FindBy(id = "facebookButton")
    public WebElement continueWithFbButton;
    @FindBy(id = "googleButton")
    public WebElement signInWithGoogle;

    @FindBy(xpath = "//snack-bar-container//span")
    public WebElement messageBox;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    public void pressSignInButton() {
        this.signInButton.click();
    }

    public void pressOnForgotPassword() {
        this.forgotPassword.click();
    }

    public void pressOnSignUpButton() {
        this.signUpButton.click();
    }

    public void pressOnFbButton() {
        this.continueWithFbButton.click();
    }

    public void pressOnGoogleButton() {
        this.signInWithGoogle.click();
    }

    public boolean signInPageIsLoaded() {
        return super.pageIsLoaded(this.signUpButton, this.signInWithGoogle,
                this.continueWithFbButton, this.signUpButton, this.forgotPassword,
                this.emailField, this.passwordField);
    }

    public String getMessageBoxText() {
        return this.messageBox.getText();
    }

}
