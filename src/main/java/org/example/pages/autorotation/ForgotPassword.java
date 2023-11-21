package org.example.pages.autorotation;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword extends BasePage {

    public ForgotPassword(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id ='username']")
    public WebElement inputEmail;

    @FindBy(xpath = "//a[@id ='goToSignIn']")
    public WebElement doToSignInButton;

    @FindBy(xpath = "//button[@id = 'send']")
    public WebElement sendButton;
}
