package org.example.vlumetests.positivetests.auth;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.ForgotPasswordPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.UrlProvider;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class ForgotPasswordPageTests extends BaseTest {
    ForgotPasswordPage forgotPasswordPage;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Forgot Password Page");
        driver.get(UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());
        forgotPasswordPage = new ForgotPasswordPage(driver);
        softAssert = new SoftAssert();
        signInPage = new SignInPage(driver);

        log.info("Forgot Password Page is Loaded Successfully");
        boolean pageIsLoaded = forgotPasswordPage.forgotPasswordPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test
    public void validateResetPasswordByUsingRegisteredEmail() {
        log.info("Enter Registered Email");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.emailField);
        forgotPasswordPage.enterEmail("ani.kovalenko97@gmail.com");
        waitHelper.waitForSeconds(2);
        log.info("Validate Value has been Successfully Entered");
        softAssert.assertTrue(forgotPasswordPage.emailField.getAttribute("value").equals("ani.kovalenko97@gmail.com"));

        log.info("Validate Invisibility of Message Box Before clicking on 'Sand' Button");
        try {
            forgotPasswordPage.messageBox.isDisplayed();
            softAssert.fail("Message Box is Visible Before Clicking on 'Send' Button");
        } catch (NoSuchElementException e) {
        }

        log.info("Click on 'Send' Button");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.sendButton);
        forgotPasswordPage.pressOnSendButton();

        log.info("Validate Message Box Visibility after clicking on 'Send' button");
        waitHelper.waitUntilElementWillBeVisible(forgotPasswordPage.messageBox);
        String messageText = forgotPasswordPage.getMessageBoxText();
        softAssert.assertEquals(messageText, "Password reset link was sent to your email");

        softAssert.assertAll();
    }

    @Test
    public void validatePressOnGoToSignInLink() {
        log.info("Verify Current Url Before Clicking on 'Go to sign in' Link");
        String urlBeforeClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforeClick, UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());

        log.info("Click on 'Forgot Password' link");
        waitHelper.waitUntilElementWillBeVisible(forgotPasswordPage.goToSignIn);
        forgotPasswordPage.pressOnGoToSignIn();

        log.info("Verify Current Url After Clicking on 'Go to sign in' Link");
        String urlAfterClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterClick, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Sign In Page is Loaded Successfully");
        boolean pageIsLoaded = signInPage.signInPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }
}
