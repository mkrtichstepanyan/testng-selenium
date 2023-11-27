package org.example.pages.wordpress;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    private final WelcomeTopPanel welcomeTopPanel;

    @FindBy(xpath = "//a[@href = 'https://dev.vlume.com/sign-in']")
    public WebElement signInButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
        welcomeTopPanel = new WelcomeTopPanel(driver);
    }

    public WelcomeTopPanel getTopPanel() {
        return welcomeTopPanel;
    }

    public void clickOnSignInButton() {
        this.signInButton.click();
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(signInButton);
    }

}
