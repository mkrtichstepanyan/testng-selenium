package org.example.pages.autentication;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    @FindBy(id = "facebookButton")
    public WebElement continueWithFbButton;
    @FindBy(id = "googleButton")
    public WebElement signInWithGoogle;
    @FindBy(id = "username")
    public WebElement emailField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordField;
    @FindBy(id = "signUp")
    public WebElement signUpButton;
    @FindBy(id = "signIn")
    public WebElement signInButton;
    @FindBy(id = "forgotPassword")
    public WebElement forgotPasswordLink;
    @FindBy(id = "passwordIsRequired")
    public WebElement passwordIsRequiredValidationMessage;
    @FindBy(id = "emailIsRequired")
    public WebElement emailIsRequiredValidationMessage;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFbButton() {
        this.continueWithFbButton.click();
    }

    public void clickOnGoogleButton() {
        this.signInWithGoogle.click();
    }

    public void enterEmail(String email) {
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        this.passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        this.confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickOnSignUpButton() {
        this.signUpButton.click();
    }

    public void clickOnSignInButton() {
        this.signInButton.click();
    }

    public void clickOnForgotPassword() {
        this.forgotPasswordLink.click();
    }

    public boolean signUpPageIsLoaded() {
        return super.pageIsLoaded(this.signUpButton, this.signInButton, this.forgotPasswordLink,
                this.signInWithGoogle, this.continueWithFbButton,
                this.emailField, this.passwordField, this.confirmPasswordField);
    }

}
