package org.example.pages.wordpress;

import org.example.helpers.WaitHelper;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class WelcomePage extends BasePage {
    private Logger logger = LoggerFactory.getLogger(WelcomePage.class);

    WaitHelper waitHelper;

    @FindBy(xpath = "//a[@href = 'https://dev.vlume.com/sign-in']")
    public WebElement signInButton;


    public WelcomePage(WebDriver driver) {
        super(driver);
        waitHelper = new WaitHelper(driver);
    }

    public void clickOnSignInButton() {
        logger.info("Clicking on the Sign In button");
        this.signInButton.click();
    }


    public void goToSignInPage() {
        logger.info("Navigating to the Sign In page");
        waitHelper.waitForElementToBeClickable(this.signInButton);
        this.clickOnSignInButton();
        swipeSignInWindow();
    }


    private void swipeSignInWindow() {
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (windowHandle != driver.getWindowHandle()) {
                driver.switchTo().window(windowHandle);
                logger.info("Switched to Sign In window");
            }
        }
    }


}
