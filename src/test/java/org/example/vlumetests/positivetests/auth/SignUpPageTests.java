package org.example.vlumetests.positivetests.auth;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.SignUpPage;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SignUpPageTests extends BaseTest {
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Sign Up Page");
        driver.get(UrlProvider.SIGN_UP_PAGE_URL.getUrl());
        signUpPage = new SignUpPage(driver);
        softAssert = new SoftAssert();

        log.info("Sign Up Page is Loaded Successfully");
        boolean pageIsLoaded = signUpPage.signUpPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test
    public void validatePressOnFbButton() {
        log.info("Click on 'Continue with Facebook' button");
        waitHelper.waitForElementToBeClickable(signUpPage.continueWithFbButton);
        signUpPage.clickOnFbButton();
    }

    @Test
    public void validatePressOnGoogleButton() {
        log.info("Click on 'Continue with Google' button");
        waitHelper.waitForElementToBeClickable(signUpPage.signInWithGoogle);
        signUpPage.clickOnGoogleButton();
    }

    @Test
    public void validateSignUpProcess() {
        log.info("Enter valid email");
        waitHelper.waitForElementToBeClickable(signUpPage.emailField);
        signUpPage.enterEmail("");

        log.info("Enter valid password");
        waitHelper.waitUntilElementWillBeVisible(signUpPage.passwordField);
        signUpPage.enterPassword("");

        log.info("Confirm entered password");
        signUpPage.enterConfirmPassword("");
        signUpPage.clickOnSignUpButton();
    }

    @Test
    public void validatePressOnForgotPasswordButton() {
        log.info("Verify Current Url Before Clicking on 'Forgot Password' Button");
        String urlBeforeClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforeClick, UrlProvider.SIGN_UP_PAGE_URL.getUrl());

        log.info("Click on 'Forgot Password' link");
        waitHelper.waitUntilElementWillBeVisible(signUpPage.forgotPasswordLink);
        signUpPage.clickOnForgotPassword();

        log.info("Verify Current Url After Clicking on 'Forgot Password' Button");
        String urlAfterClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterClick, UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());

        softAssert.assertAll();
    }
}
