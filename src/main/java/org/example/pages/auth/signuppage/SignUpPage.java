package org.example.pages.auth.signuppage;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    @FindBy(xpath = "//h2[@_ngcontent-pyh-c129]")
    public WebElement GetStartedText;

    @FindBy(xpath = "//div[@id='facebookButton']")
    public WebElement signUpWithFacebookButton;

    @FindBy(xpath = "//div[@id='appleButton']")
    public WebElement signUpWithAppleButton;

    @FindBy(xpath = "//div[@id='googleButton']")
    public WebElement signUpWithGoogleButton;

    @FindBy(xpath = "//p[@id='signUpWithYourEmail']")
    public WebElement signUpWithYourEmailText;

    @FindBy(xpath = "//label[@for='username']")
    public WebElement emailText;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailInput;

    @FindBy(xpath = "//label[@for='password']")
    public WebElement passwordText;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//label[@for='confirmPassword']")
    public WebElement confirmPasswordText;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//a[@id='forgotPassword']")
    public WebElement forgotPasswordButton;

    @FindBy(xpath = "//button[@id='signUp']")
    public WebElement signUpButton;

    @FindBy(xpath = "//a[@id='signIn']")
    public WebElement signInButton;

    public void clickOnSignInWithFacebook() {
        this.signUpWithFacebookButton.click();
    }

    public void clickOnSignInWithApple() {
        this.signUpWithAppleButton.click();
    }

    public void clickOnSignInWithGoogle() {
        this.signUpWithGoogleButton.click();
    }

    public void clickOnForgotPassword() {
        this.forgotPasswordButton.click();
    }

    public void clickOnSignUpButton() {
        this.signUpButton.click();
    }

    public void clickOnSignInButtonInSignInPage() {
        this.signInButton.click();
    }

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

}
