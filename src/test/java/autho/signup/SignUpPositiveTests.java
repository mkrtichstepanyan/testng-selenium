package autho.signup;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.helpers.WaitHelper;
import org.example.pages.authorization.SignInPage;
import org.example.pages.authorization.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j(topic = "AuthorizationLogger")
public class SignUpPositiveTests extends BaseTest {
    SignUpPage signUpPage;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        goToURL(SIGN_IN_PAGE_URL);
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void verifySignUpPageUrl() {
        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write incorrect email: {}", "dsd");
        signInPage.inputEmail.sendKeys("dsd");

        log.info("Write incorrect password: {}", "dsd");
        signInPage.inputPassword.sendKeys("dsd");

        log.info("Click sign uo button");
        signInPage.clickSignUpButton();

        log.info("Assert sign up page is opened");
        Assert.assertTrue(signUpPage.isPageOpened());

        Assert.assertEquals(driver.getCurrentUrl(), SIGN_UP_PAGE_URL);
    }

    @Test
    public void verifySingUpPageIsOpened() {
        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write incorrect email: {}", "dsd");
        signInPage.inputEmail.sendKeys("dsd");

        log.info("Write incorrect password: {}", "dsd");
        signInPage.inputPassword.sendKeys("dsd");

        log.info("Click sign uo button");
        signInPage.clickSignUpButton();

        log.info("Assert sign up page is opened");
        Assert.assertTrue(signUpPage.isPageOpened());

    }
}
