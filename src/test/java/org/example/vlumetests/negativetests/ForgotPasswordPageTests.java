package org.example.vlumetests.negativetests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.ForgotPasswordPage;
import org.example.providers.urlproviders.UrlProvider;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class ForgotPasswordPageTests extends BaseTest {
    ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Forgot Password Page");
        driver.get(UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());
        forgotPasswordPage = new ForgotPasswordPage(driver);
        softAssert = new SoftAssert();

        log.info("Forgot Password Page is Loaded Successfully");
        boolean pageIsLoaded = forgotPasswordPage.forgotPasswordPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test
    public void validatePressOnSendButtonWithoutEnteringTheEmail() {
        log.info("Make sure field is Clear");
        inputHelper.clearField(forgotPasswordPage.emailField);
        softAssert.assertTrue(inputHelper.getValue(forgotPasswordPage.emailField).isEmpty());

        log.info("Click on 'Send' button");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.sendButton);
        forgotPasswordPage.pressOnSendButton();

        log.info("Validate Message Existence after clicking on 'Send' Button");
        String messageText = inputHelper.getValue(forgotPasswordPage.emailIsRequiredValidationMessage);
        softAssert.assertTrue(messageText.equals("Email is required"));

        softAssert.assertAll();
    }

    @Test
    public void validateResetPasswordByUsingIncorrectEmail() {
        log.info("Enter Incorrect Email");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.emailField);
        forgotPasswordPage.enterEmail("testgmail.com");
        waitHelper.waitForSeconds(2);

        log.info("Validate Value has been Successfully Entered");
        softAssert.assertTrue(forgotPasswordPage.emailField.getAttribute("value").equals("testgmail.com"));

        log.info("Click on 'Send' Button");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.sendButton);
        forgotPasswordPage.pressOnSendButton();

        log.info("Validate Message Existence after clicking on 'Send' button");
        waitHelper.waitUntilElementWillBeVisible(forgotPasswordPage.wrongEmailFormatValidationMessage);
        String messageText = inputHelper.getValue(forgotPasswordPage.wrongEmailFormatValidationMessage);
        softAssert.assertEquals(messageText, "Wrong email format");

        softAssert.assertAll();
    }

    @Test
    public void validateResetPasswordByUsingNonRegisteredEmail() {
        log.info("Enter Non-Registered Email");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.emailField);
        forgotPasswordPage.enterEmail("anitest@gmail.com");
        waitHelper.waitForSeconds(2);

        log.info("Validate Value has been Successfully Entered");
        softAssert.assertTrue(forgotPasswordPage.emailField.getAttribute("value").equals("anitest@gmail.com"));

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
        softAssert.assertEquals(messageText, "The user with specified email address not exist.");

        softAssert.assertAll();
    }
}
