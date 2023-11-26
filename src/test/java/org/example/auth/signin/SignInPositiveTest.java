package org.example.auth.signin;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.helpers.WaitHelper;
import org.example.pages.auth.signinpage.SignInPage;
import org.example.pages.wordpress.welcomepage.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Slf4j
public class SignInPositiveTest extends BaseTest {

    WelcomePage welcomePage;
    WaitHelper waitHelper;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        waitHelper = new WaitHelper(driver);
        log.info("Go to welcome page");
        driver.get(WELCOME_PAGE_URL);
    }

    @Test
    public void validateVisibilityOfSignInPage() {

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        waitHelper.waitForSeconds(3);
        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        driver.switchTo().window(newWindow());
        Assert.assertEquals(driver.getCurrentUrl(), SIGN_IN_PAGE_URL);

        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());
    }

    @Test
    public void validateSignInWithFacebook() {

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        waitHelper.waitForSeconds(3);
        log.info("Clicking on Sign in button");
        welcomePage.clickOnSignInButton();

        waitHelper.waitForSeconds(3);
        log.info("Clicking on Sign in with Facebook button");
        signInPage.clickOnSignInWithFacebook();
    }
}

