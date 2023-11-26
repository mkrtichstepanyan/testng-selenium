package org.example.pages.auth.signinpage;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@id='facebookButton']")
    public WebElement signInWithFacebookButton;

    @FindBy(xpath = "//div[@id='appleButton']")
    public WebElement signInWithAppleButton;

    @FindBy(xpath = "//div[@id='googleButton']")
    public WebElement signInWithGoogleButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='loginButton']")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@class='btn__vlume btn_login_signup btn_signup']")
    public WebElement signUpButton;

    @FindBy(xpath = "//a[@id='forgotPassword']")
    public WebElement forgotPasswordButton;

    @FindBy(xpath = "//simple-snack-bar//span")
    public WebElement errorMessage;


    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(signInWithFacebookButton, signInWithAppleButton,
                signInWithGoogleButton, emailInput, passwordInput,
                signInButton, signUpButton, forgotPasswordButton);
    }

    public void clickOnSignInWithFacebook() {
        this.signInWithFacebookButton.click();
    }

    public void clickOnSignInWithApple() {
        signInWithAppleButton.click();
    }

    public void clickOnSignInWithGoogle() {
        signInWithGoogleButton.click();
    }

    public void clickOnSignInButton() {
       signInButton.click();
    }

    public void clickOnSignUpButton() {
        signUpButton.click();
    }

    public void clickOnForgotPassword() {
        forgotPasswordButton.click();
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }
}
