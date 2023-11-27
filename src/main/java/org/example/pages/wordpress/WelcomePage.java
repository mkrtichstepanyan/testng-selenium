package org.example.pages.wordpress;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WelcomePage extends BasePage {

    @FindBy(xpath = "//a[@href = 'https://dev.vlume.com/sign-in']")
    public WebElement signInButton;

    public WelcomePage(WebDriver driver){
        super(driver);
    }

    public void clickOnSignInButton() {
        this.signInButton.click();
    }
}
