package org.example.pages.auth;

import org.example.helpers.WaitHelper;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignInPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(SignInPage.class);

    @FindBy(xpath = "//div[@id='cdk-overlay-0']//span")
    public WebElement errorMassage;

    @FindBy(tagName = "h2")
    public WebElement getStarted;

    @FindBy(id = "facebookButtonText")
    public WebElement facebookButton;

    @FindBy(id = "appleButtonText")
    public WebElement appleButton;

    @FindBy(id = "googleButtonText")
    public WebElement googleButton;

    @FindBy(className = "or")
    public WebElement orText;

    @FindBy(id = "username")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "loginButton")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@tabindex='0']")
    public WebElement signUpButton;

    @FindBy(id = "forgotPassword")
    public WebElement forgotPasswordButton;

    public SignInPage(WebDriver driver) {
        super(driver);
        waitHelper = new WaitHelper(driver);
    }

    public void clickOnFacebookButton() {
        logger.info("Clicking on the Facebook button");
        this.facebookButton.click();
    }

    public void clickOnAppleButton() {
        logger.info("Clicking on the Apple button");
        this.appleButton.click();
    }

    public void clickOnGoogleButton() {
        logger.info("Clicking on the Google button");
        this.googleButton.click();
    }

    public void clickOnSignInButton() {
        logger.info("Clicking on the Sign In button");
        this.signInButton.click();
    }

    public void clickOnSignUpButton() {
        logger.info("Clicking on the Sign Up button");
        this.signUpButton.click();
    }

    public void clickOnForgotPasswordButton() {
        logger.info("Clicking on the Forgot Password button");
        this.forgotPasswordButton.click();
    }

    public void enterThePassword(String password) {
        logger.info("Entering password");
        this.password.sendKeys(password);
    }

    public void enterTheEmail(String email) {
        logger.info("Entering email: {}", email);
        this.email.sendKeys(email);
    }


    public void isPageOpened() {
        isPageOpened(getStarted, facebookButton, appleButton, googleButton, orText, email, password, signInButton, signUpButton, forgotPasswordButton);
    }
}
