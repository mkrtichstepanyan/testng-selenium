package org.example.pages.authorization;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage {

    private final AuthorizationTopPanel signUnTopPanel;
    @FindBy(xpath = "//div//h2[@id = 'title']")
    public WebElement title;
    @FindBy(xpath = "//div[@id = 'facebookButton']")
    public WebElement facebookButton;

    @FindBy(xpath = "//div[@id = 'appleButton']")
    public WebElement appleButton;

    @FindBy(xpath = "//div[@id = 'googleButton']")
    public WebElement googleButton;

    @FindBy(xpath = "//div//p[@id = 'signUpWithYourEmail']")
    public WebElement title2;

    @FindBy(xpath = "//input[@id = 'username']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id = 'password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//input[@id = 'confirmPassword']")
    public WebElement confirmPassword;

    @FindBy(xpath = "//a[@id = 'signIn']")
    public WebElement signInButton;

    @FindBy(xpath = "//button[@id = 'signUp']")
    public WebElement signUpButton;

    @FindBy(xpath = "//a[@id = 'forgotPassword']")
    public WebElement forgotPassword;

    public SignUpPage(WebDriver driver) {
        super(driver);
        signUnTopPanel = new AuthorizationTopPanel(driver);
    }

    public AuthorizationTopPanel getTopPanel() {
        return signUnTopPanel;
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(title, facebookButton, appleButton, googleButton, title2, inputEmail, inputPassword, confirmPassword, signInButton, signUpButton, forgotPassword);
    }
}
