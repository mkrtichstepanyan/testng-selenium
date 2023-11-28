package org.example.auth.signin;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.helpers.WaitHelper;
import org.example.pages.auth.signinpage.SignInPage;
import org.example.pages.wordpress.welcomepage.WelcomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class SignInNegativeTest extends BaseTest {

    WelcomePage welcomePage;
    WaitHelper waitHelper;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        waitHelper = new WaitHelper(driver);
        goToURL(WELCOME_PAGE_URL);
    }

    @Test
    public void validateSignInWithIncorrectEmailAndPassword() {

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        driver.switchTo().window(newWindow());

        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write incorrect Email {}", "test@gmail.com");
        signInPage.emailInput.sendKeys("test@gmail.com");

        log.info("Write incorrect password {}", "12345");
        signInPage.passwordInput.sendKeys("12345");

        log.info("Click on Sign in button");
        signInPage.clickOnSignInButton();

        log.info("Assert error message is displayed");
        WebElement errorMessageElement = waitHelper.waitForElementToBeVisible(signInPage.errorMessage);
        Assert.assertTrue(errorMessageElement.isDisplayed());
        String actualErrorMessage = errorMessageElement.getText();

        log.info("Assert error message is correct");
        Assert.assertEquals(actualErrorMessage, "Wrong credentials");

        log.info("Assert error message is closed");
        Assert.assertFalse(newWindow().isEmpty());
    }

    @Test
    public void validateSignInWithCorrectEmailAndIncorrectPassword() {

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        driver.switchTo().window(newWindow());

        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write incorrect Email {}", "anush.ananyanv@gmail.com");
        signInPage.emailInput.sendKeys("anush.ananyanv@gmail.com");

        log.info("Write incorrect password {}", "12345");
        signInPage.passwordInput.sendKeys("12345");

        log.info("Click on Sign in button");
        signInPage.clickOnSignInButton();

        log.info("Assert error message is displayed");
        WebElement errorMessageElement = waitHelper.waitForElementToBeVisible(signInPage.errorMessage);
        Assert.assertTrue(errorMessageElement.isDisplayed());
        String actualErrorMessage = errorMessageElement.getText();

        log.info("Assert error message is correct");
        Assert.assertEquals(actualErrorMessage, "Wrong credentials");

        log.info("Assert error message is closed");
        Assert.assertFalse(newWindow().isEmpty());
    }
}

