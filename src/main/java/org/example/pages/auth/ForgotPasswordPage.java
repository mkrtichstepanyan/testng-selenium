package org.example.pages.auth;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForgotPasswordPage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(ForgotPasswordPage.class);

    @FindBy(xpath = "//div[@id='cdk-overlay-0']//span")
    public WebElement errorMassage;

    @FindBy(xpath = "//simple-snack-bar/span")
    public WebElement passwordResetLink;


    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "emailIsRequired")
    public WebElement emailIsRequired;

    @FindBy(id = "wrongEmailFormat")
    public WebElement wrongEmailFormat;

    @FindBy(id = "goToSignIn")
    public WebElement goToSignInButton;

    @FindBy(id = "send")
    public WebElement sendButton;


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

    public void sendKeysOnUsernameInput(String username) {
        logger.info("Entering username: {}", username);
        this.username.sendKeys(username);
    }

    public void clearUsernameInput() {
        logger.info("Clearing the Username Input field");
        this.username.clear();

    }


}
