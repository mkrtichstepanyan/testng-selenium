package org.example.pages.auth.forgotpasswordpage;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//h2[@id='title']")
    public WebElement forgotPasswordTitle;

    @FindBy(xpath = "//div[@_ngcontent-our-c114]//p['Enter your email']")
    public WebElement enterYourEmailText;

    @FindBy(xpath = "//form['_ngcontent-mat-c114']//div['_ngcontent-mat-c114']//label['_ngcontent-mat-c114']")
    public WebElement emailInputFieldTitle;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailInputForForgottenPassword;

    @FindBy(xpath = "//a[@id='goToSignIn']")
    public WebElement goToSignInButton;

    @FindBy(xpath = "//button[@id='send']")
    public WebElement sendButton;


    public void clickOnSignInButton() {
        this.goToSignInButton.click();
    }

    public void clickOnSendButton() {
        this.sendButton.click();
    }

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(emailInputForForgottenPassword, goToSignInButton, sendButton);
        //forgotPasswordTitle, enterYourEmailText, emailInputFieldTitle,
    }
}
