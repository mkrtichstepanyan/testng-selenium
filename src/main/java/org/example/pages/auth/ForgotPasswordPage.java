package org.example.pages.auth;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForgotPasswordPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(ForgotPasswordPage.class);


    @FindBy(tagName = "h2")
    public WebElement forgotPasswordText;

    @FindBy(className = "with-email")
    public WebElement enterYourEmailText;

    @FindBy(xpath = "//label[@for='username']")
    public WebElement emailText;

    @FindBy(xpath = "//div[@id='cdk-overlay-0']//span")
    public WebElement errorMassage;

    @FindBy(xpath = "//simple-snack-bar/span")
    public WebElement passwordResetLink;


    @FindBy(id = "username")
    public WebElement email;

    @FindBy(id = "emailIsRequired")
    public WebElement emailIsRequired;

    @FindBy(id = "wrongEmailFormat")
    public WebElement wrongEmailFormat;

    @FindBy(id = "goToSignIn")
    public WebElement goToSignInButton;

    @FindBy(id = "send")
    public WebElement sendButton;

    public WebElement[] webElements = {
            forgotPasswordText, emailText, enterYourEmailText,
            email, goToSignInButton, sendButton
    };

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSendButton() {
        logger.info("Clicking on the Send button");
        this.sendButton.click();
    }

    public void clickGoToSignInPageButton() {
        logger.info("Clicking on the Go To Sign In Page button");
        this.goToSignInButton.click();
    }

    public void enterTheEmail(String email) {
        logger.info("Entering email: {}", email);
        this.email.sendKeys(email);
    }

    public void clearEmailInput() {
        logger.info("Clearing the Email Input field");
        this.email.clear();

    }

    public void isPageOpened() {
        isPageOpened(forgotPasswordText, emailText, enterYourEmailText, email, goToSignInButton, sendButton);
    }

}
