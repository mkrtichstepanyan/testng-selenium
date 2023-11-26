package org.example.auth.forgotpassword;

import lombok.extern.slf4j.Slf4j;
import org.example.helpers.WaitHelper;
import org.example.pages.auth.forgotpasswordpage.ForgotPasswordPage;
import org.example.BaseTest;
import org.example.pages.auth.signinpage.SignInPage;
import org.example.pages.wordpress.welcomepage.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class ForgotPasswordPositiveTest extends BaseTest {
    WelcomePage welcomePage;
    ForgotPasswordPage forgotPasswordPage;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        waitHelper = new WaitHelper(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        goToURL(WELCOME_PAGE_URL);
    }

    @Test
    public void validateVisibilityOfForgotPasswordPage() {

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        waitHelper.waitForSeconds(3);
        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        driver.switchTo().window(newWindow());
        Assert.assertEquals(driver.getCurrentUrl(), SIGN_IN_PAGE_URL);

        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        waitHelper.waitForSeconds(3);
        log.info("Click on Forgot Password button");
        signInPage.clickOnForgotPassword();

        driver.switchTo().window(newWindow());
        Assert.assertEquals(driver.getCurrentUrl(), FORGOT_PASSWORD_PAGE_URL );

        log.info("Assert Forgot Password page is opened");
        Assert.assertTrue(forgotPasswordPage.isPageOpened());
    }
}

