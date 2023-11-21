package org.example.pages.autorotation;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver){
        super(driver);
    }

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

    public void clickSignInButton(){
        signInButton.click();
    }
    public void clickAppleButton(){
        appleButton.click();
    }
    public void clickGoogleButton(){
        googleButton.click();
    }
    public void clickLoginButton(){
        facebookButton.click();
    }
    public void clickSignUpButton(){
        facebookButton.click();
    }
}
