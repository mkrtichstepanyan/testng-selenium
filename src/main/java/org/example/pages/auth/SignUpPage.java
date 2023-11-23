package org.example.pages.auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpPage extends SignInPage {
    private Logger logger = LoggerFactory.getLogger(SignUpPage.class);

    @FindBy(id = "emailIsRequired")
    public WebElement emailIsRequired;

    @FindBy(id = "wrongEmail")
    public WebElement wrongEmail;

    @FindBy(id = "passwordIsRequired")
    public WebElement passwordIsRequired;

    @FindBy(id = "passwordShouldBeAtLeast8Characters")
    public WebElement passwordRegex;


    @FindBy(id = "passwordsMustMatch1")
    public WebElement passwordsMustMatch;

    @FindBy(id = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "signUp")
    public WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnSignUpButton() {
        logger.info("Clicking on the Sign Up button");
        this.signUpButton.click();
    }

    public void sendKeysOnConfirmPasswordInput(String password) {
        logger.info("Entering password");
        this.confirmPassword.sendKeys(password);
    }


}
