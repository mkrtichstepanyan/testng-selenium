package org.example.pages.auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpPage extends SignInPage {
    private Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    @FindBy(className = "with-email")
    public WebElement signUpWithYourEmailText;

    @FindBy(xpath = "//label[@for='username']")
    public WebElement emailText;

    @FindBy(xpath = "//label[@for='password']")
    public WebElement passwordText;

    @FindBy(xpath = "//label[@for='confirmPassword']")
    public WebElement confirmPasswordText;

    @FindBy(id = "emailIsRequired")
    public WebElement emailIsRequired;

    @FindBy(id = "wrongEmail")
    public WebElement wrongEmail;

    @FindBy(id = "passwordIsRequired")
    public WebElement passwordIsRequired;

    @FindBy(id = "passwordShouldBeAtLeast8Characters")
    public WebElement passwordRegex;


    @FindBy(id = "passwordsMustMatch1")
    public WebElement passwordsMustMatch;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "signUp")
    public WebElement signUpButton;

    @FindBy(id = "signIn")
    public WebElement signInButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnSignUpButton() {
        logger.info("Clicking on the Sign Up button");
        this.signUpButton.click();
    }

    public void enterTheConfirmPassword(String password) {
        logger.info("Entering password");
        this.confirmPassword.sendKeys(password);
    }

    public void isPageOpened() {
        isPageOpened(getStarted, facebookButton, appleButton, googleButton, orText, emailText, signUpWithYourEmailText, email, passwordText, password, confirmPasswordText, confirmPassword, signInButton, signUpButton, forgotPasswordButton);
    }
}
