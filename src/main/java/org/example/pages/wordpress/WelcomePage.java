package org.example.pages.wordpress;

import org.example.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(xpath = "//a[@href = 'https://dev.vlume.com/sign-in']")
    public WebElement signInButton;


    public void clickOnSignInButton() {
        this.signInButton.click();
    }

}
