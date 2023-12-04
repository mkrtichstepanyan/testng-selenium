package vlume.negativetests.autentiacation.forgotpassword;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.authentication.forgotpassword.ForgotPasswordPage;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class ForgotPasswordPageNegativeTests extends BaseTest {
    ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Forgot Password Page");
        driver.get(UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());
        forgotPasswordPage = new ForgotPasswordPage(driver);
        softAssert = new SoftAssert();

        log.info("-> Forgot Password Page is Loaded Successfully");
        boolean pageIsLoaded = forgotPasswordPage.forgotPasswordPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnSendButtonWithoutEnteringTheEmail() {
        log.info("-> Make sure field is Clear");
        inputHelper.clearField(forgotPasswordPage.email);
        softAssert.assertTrue(inputHelper.getValue(forgotPasswordPage.email).isEmpty());

        log.info("-> Press on <Send> button");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.sendButton);
        forgotPasswordPage.pressOnSendButton();

        log.info("-> Validate Message Existence after pressing on <Send> Button");
        String messageText = inputHelper.getValue(forgotPasswordPage.emailIsRequiredValidationMessage);
        softAssert.assertTrue(messageText.equals("Email is required"));

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test
    public void validateResetPasswordByUsingIncorrectEmail() {
        log.info("-> Enter Incorrect Email");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.email);
        forgotPasswordPage.enterEmail("samsungansuryangmail.com");
        waitHelper.waitForSeconds(2);

        log.info("-> Validate Value has been Successfully Entered");
        softAssert.assertTrue(forgotPasswordPage.email.getAttribute("value")
                .equals("samsungansuryangmail.com"));

        log.info("-> Press on <Send> Button");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.sendButton);
        forgotPasswordPage.pressOnSendButton();

        log.info("-> Validate Message Existence after pressing on <Send> button");
        waitHelper.waitUntilElementWillBeVisible(forgotPasswordPage.wrongEmailFormatValidationMessage);
        String messageText = inputHelper.getValue(forgotPasswordPage.wrongEmailFormatValidationMessage);
        softAssert.assertEquals(messageText, "Wrong email format");

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test
    public void validateResetPasswordByUsingNonRegisteredEmail() {
        log.info("-> Enter Non-Registered Email");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.email);
        forgotPasswordPage.enterEmail("anitest@gmail.com");
        waitHelper.waitForSeconds(2);

        log.info("-> Validate Value has been Successfully Entered");
        softAssert.assertTrue(forgotPasswordPage.email.getAttribute("value")
                .equals("yeghiatest@gmail.com"));

        log.info("-> Validate Invisibility of Message Box Before pressing on <Sand> Button");
        try {
            forgotPasswordPage.messageBox.isDisplayed();
            softAssert.fail("Message Box is Visible Before pressing on <Send> Button");
        } catch (NoSuchElementException e) {
        }
        log.info("-> Press on <Send> Button");
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.sendButton);
        forgotPasswordPage.pressOnSendButton();

        log.info("-> Validate Message Box Visibility after pressing on <Send> button");
        waitHelper.waitUntilElementWillBeVisible(forgotPasswordPage.messageBox);
        String messageText = forgotPasswordPage.getMessageBoxText();
        softAssert.assertEquals(messageText, "The user with specified email address not exist.");

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
