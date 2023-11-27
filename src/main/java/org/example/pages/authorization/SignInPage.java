package org.example.pages.authorization;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    private final AuthorizationTopPanel signInTopPanel;

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
        signInTopPanel = new AuthorizationTopPanel(driver);
    }

    public AuthorizationTopPanel getTopPanel() {
        return signInTopPanel;
    }

    public void clickOnAppleButton() {
        appleButton.click();
    }

    public void clickOnGoogleButton() {
        googleButton.click();
    }

    public void clickOnSignUpButton() {
        signUpButton.click();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void clickOnForgotPassword() {
        forgotPassword.click();
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(facebookButton, appleButton, googleButton, signInButton, signUpButton, forgotPassword, inputEmail, inputPassword);
    }
}
