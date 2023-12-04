package org.example.vlume.pages.panels.toppanel.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInButton extends AuthenticationElement {

    @FindBy(xpath = "//a[@class='sign-in-button ng-star-inserted']")
    public WebElement signInButton;

    protected SignInButton(WebDriver driver) {
        super(driver);
    }

    public void pressOnSignInButton() {
        this.signInButton.click();
    }
}
