package org.example.pages.panels.toppanel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInElement extends AuthElement {

    @FindBy(xpath = "//a[@class='sign-in-button ng-star-inserted']")
    public WebElement signInButton;

    protected SignInElement(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignInButton() {
        this.signInButton.click();
    }
}
