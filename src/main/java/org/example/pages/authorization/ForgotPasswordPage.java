package org.example.pages.authorization;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    private final AuthorizationTopPanel forgotPasswordTopPanel;
    @FindBy(xpath = "//input[@id ='username']")
    public WebElement inputEmail;

    @FindBy(xpath = "//a[@id ='goToSignIn']")
    public WebElement goToSignInButton;

    @FindBy(xpath = "//button[@id = 'send']")
    public WebElement sendButton;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        forgotPasswordTopPanel = new AuthorizationTopPanel(driver);
    }

    public AuthorizationTopPanel getTopPanel() {
        return forgotPasswordTopPanel;
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(inputEmail, goToSignInButton, sendButton);
    }

}
