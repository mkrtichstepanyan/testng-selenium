package org.example.vlumetests.positivetests.auth;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.SignInPage;
import org.example.pages.autentication.SignUpPage;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SignInPageTests extends BaseTest {
    SignInPage signInPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Sign In Page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        softAssert = new SoftAssert();

        log.info("Sign In Page is Loaded Successfully");
        boolean pageIsLoaded = signInPage.signInPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test
    public void validateSignInProcessWithValidData() {
        log.info("Enter correct email");
        waitHelper.waitUntilElementWillBeVisible(signInPage.emailField);
        signInPage.enterEmail("ani.kovalenko97@gmail.com");

        log.info("Enter correct password");
        waitHelper.waitUntilElementWillBeVisible(signInPage.passwordField);
        signInPage.enterPassword("");

        log.info("Click on Sign In Button");
        signInPage.clickOnSignInButton();
    }

    @Test
    public void validateForgotPasswordLink() {
        log.info("Verify Current Url Before Clicking on 'Forgot Password' Button");
        String urlBeforeClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforeClick, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Click on 'Forgot Password' link");
        waitHelper.waitUntilElementWillBeVisible(signInPage.forgotPasswordLink);
        signInPage.clickOnForgotPassword();

        log.info("Verify Current Url After Clicking on 'Forgot Password' Button");
        String urlAfterClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterClick, UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());

        softAssert.assertAll();
    }

    @Test
    public void validateSignUpButton() {
        log.info("Verify Current Url Before Clicking on 'SignUp' Button");
        String urlBeforeClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforeClick, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Click On 'Sign Up' button");
        waitHelper.waitUntilElementWillBeVisible(signInPage.signUpButton);
        signInPage.clickOnSignUpButton();

        log.info("Verify Sign Up page loading");
        boolean pageIsLoaded = signUpPage.signUpPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        log.info("Verify Current Url After Clicking on 'SignUp' Button");
        String urlAfterClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterClick, UrlProvider.SIGN_UP_PAGE_URL.getUrl());

        softAssert.assertAll();
    }

    @Test
    public void validatePressOnFbButton() {
        log.info("Click on 'Continue with Facebook' button");
        waitHelper.waitForElementToBeClickable(signInPage.continueWithFbButton);
        signInPage.clickOnFbButton();
    }
}
