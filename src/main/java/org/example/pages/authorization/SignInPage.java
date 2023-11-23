package org.example.pages.authorization;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//div[@id = 'facebookButton']")
    public WebElement facebookButton;

    @FindBy(xpath = "//div[@id = 'appleButton']")
    public WebElement appleButton;

    @FindBy(xpath = "//div[@id = 'googleButton']")
    public WebElement googleButton;

    @FindBy(xpath = "//button[@id = 'loginButton']")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@class= 'btn__vlume btn_login_signup btn_signup']")
    public WebElement signUpButton;

    @FindBy(xpath = "//a[@id = 'forgotPassword']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//input[@id ='username']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id ='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//snack-bar-container//span")
    public WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(facebookButton, appleButton, googleButton, signInButton, forgotPassword, inputEmail, inputPassword);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickAppleButton() {
        appleButton.click();
    }

    public void clickGoogleButton() {
        googleButton.click();
    }

    public void clickLoginButton() {
        facebookButton.click();
    }

    public void clickSignUpButton() {
        facebookButton.click();
    }

    public void clickForgotPassword() {
        forgotPassword.click();
    }
}
