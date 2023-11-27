package org.example.vlume.pages.autentication.signup;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {
    @FindBy(id = "username")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "confirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(id = "facebookButton")
    public WebElement continueWithFbButton;
    @FindBy(id = "googleButton")
    public WebElement signInWithGoogle;

    @FindBy(id = "signUp")
    public WebElement signUpButton;

    @FindBy(id = "forgotPassword")
    public WebElement forgotPasswordLink;

    @FindBy(id = "passwordIsRequired")
    public WebElement passwordIsRequiredValidationMessage;
    @FindBy(id = "emailIsRequired")
    public WebElement emailIsRequiredValidationMessage;

    public SignUpPage(WebDriver driver) {
        super(driver);
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

    public void pressOnFbButton() {
        this.continueWithFbButton.click();
    }

    public void pressOnGoogleButton() {
        this.signInWithGoogle.click();
    }

    public void pressOnSignUpButton() {
        this.signUpButton.click();
    }

    public void pressOnForgotPassword() {
        this.forgotPasswordLink.click();
    }

    public boolean signUpPageIsLoaded(){
       return super.pageIsLoaded(
                this.continueWithFbButton, this.signUpButton,
                this.signInWithGoogle, this.emailField,
                this.forgotPasswordLink, this.passwordField,
                this.confirmPasswordField
        );
    }

}
