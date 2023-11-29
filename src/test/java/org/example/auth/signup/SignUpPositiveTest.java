package org.example.auth.signup;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.helpers.WaitHelper;
import org.example.pages.auth.signinpage.SignInPage;
import org.example.pages.auth.signuppage.SignUpPage;
import org.example.pages.wordpress.welcomepage.WelcomePage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Slf4j
public class SignUpPositiveTest extends BaseTest {

    WelcomePage welcomePage;
    WaitHelper waitHelper;
    SignInPage signInPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        waitHelper = new WaitHelper(driver);
        signUpPage = new SignUpPage(driver);
        log.info("Go to welcome page");
        driver.get(WELCOME_PAGE_URL);
    }

    @Test
    public void validateVisibilityOfSignUpPage() {

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();

        driver.switchTo().window(theNewWindow());
        Assert.assertEquals(driver.getCurrentUrl(), SIGN_IN_PAGE_URL);
        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Click on Sign up button");
        waitHelper.waitForElementToBeClickable(signInPage.signUpButton);
        signInPage.clickOnSignUpButton();

        driver.switchTo().window(theNewWindow());
        Assert.assertEquals(driver.getCurrentUrl(), SIGN_UP_PAGE_URL);
        log.info("Assert sign up page is opened");
        Assert.assertTrue(signUpPage.isPageOpened());
    }

    @Test
    public void validateSignUpWithEmail() {

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();

        driver.switchTo().window(theNewWindow());
        Assert.assertEquals(driver.getCurrentUrl(), SIGN_IN_PAGE_URL);
        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Click on Sign up button");
        waitHelper.waitForElementToBeClickable(signInPage.signUpButton);
        signInPage.clickOnSignUpButton();

        driver.switchTo().window(theNewWindow());
        Assert.assertEquals(driver.getCurrentUrl(), SIGN_UP_PAGE_URL);
        log.info("Assert sign up page is opened");
        Assert.assertTrue(signUpPage.isPageOpened());

        log.info("Write correct email address");
        signUpPage.emailInput.sendKeys("test1257@gmail.com");

        log.info("Write password");
        signUpPage.passwordInput.sendKeys("12345678");

        log.info("Confirm password");
        signUpPage.confirmPasswordInput.sendKeys("12345678");

        log.info("Click on Sign up button");
        waitHelper.waitForElementToBeClickable(signUpPage.signUpButton);
        signUpPage.clickOnSignUpButton();

        driver.switchTo().window(theNewWindow());
        waitHelper.waitForSeconds(10);
        log.info("Assert Edit profile page url");
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, AFTER_SIGN_UP_PAGE_URL);
    }
}

