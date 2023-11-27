package vlume.positivetests.autentiacation.forgotpassword;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.helper.InputHelper;
import org.example.vlume.pages.autentication.forgotpassword.ForgotPasswordPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class ForgotPasswordPagePositiveTests extends BaseTest {
    ForgotPasswordPage forgotPassword;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open forgot password page");
        driver.get(UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());
        forgotPassword = new ForgotPasswordPage(driver);
        signInPage = new SignInPage(driver);
        inputHelper = new InputHelper();
    }

    @Test
    public void validateResetPasswordByUsingRegisteredEmail() {

        log.info("-> Enter Registered Email");
        waitHelper.waitForElementToBeClickable(forgotPassword.email);
        forgotPassword.enterEmail("samsungansuryan@gmail.com");
        waitHelper.waitForSeconds(2);

        log.info("-> Validate Value has been Successfully Entered");
        softAssert.assertTrue(forgotPassword.email.getAttribute("value")
                .equals("samsungansuryan@gmail.com"));

        log.info("-> Validate Invisibility of Message Box Before clicking on 'Sand' Button");
        try {
            forgotPassword.messageBox.isDisplayed();
            softAssert.fail("Message Box is Visible Before Clicking on 'Send' Button");
        } catch (NoSuchElementException e) {
        }

        log.info("-> Press on 'Send' Button");
        waitHelper.waitForElementToBeClickable(forgotPassword.sendButton);
        forgotPassword.pressOnSendButton();

        log.info("-> Validate Message Box Visibility after clicking on 'Send' button");
        waitHelper.waitUntilElementWillBeVisible(forgotPassword.messageBox);
        String messageText = forgotPassword.getMessageBoxText();
        softAssert.assertEquals(messageText, "Password reset link was sent to your email");

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

        @Test
        public void validatePressOnGoToSignInLink() {

            log.info("Verify Current Url Before Clicking on 'Go to sign in' Link");
            String urlBeforeClick = driver.getCurrentUrl();
            softAssert.assertEquals(urlBeforeClick, UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());

            log.info("Click on 'Forgot Password' link");
            waitHelper.waitUntilElementWillBeVisible(forgotPassword.goToSignIn);
            forgotPassword.pressOnGoToSignIn();

            log.info("Verify Current Url After Clicking on 'Go to sign in' Link");
            String urlAfterClick = driver.getCurrentUrl();
            softAssert.assertEquals(urlAfterClick, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

            log.info("Sign In Page is Loaded Successfully");
            boolean pageIsLoaded = signInPage.signInPageIsLoaded();
            softAssert.assertTrue(pageIsLoaded);

            log.info("-> Test succeeded");
            softAssert.assertAll();
        }

        @Test

        public void validatePressOnEnterEmail () {
            log.info("-> Press on email field");
            waitHelper.waitForElementToBeClickable(forgotPassword.email);
            waitHelper.waitForSeconds(2);
            forgotPassword.pressOnEnterEmail();
        }

        @Test
        public void validatePressOnGoToSignIn () {
            log.info("-> Verify URL before press on <Go to sign in> link");
            String urlBeforePressOnForgotPasswordButton = driver.getCurrentUrl();
            softAssert.assertEquals(urlBeforePressOnForgotPasswordButton,
                    UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());

            log.info("-> Press on <Go to sign in> link");
            waitHelper.waitForElementToBeClickable(forgotPassword.goToSignIn);
            forgotPassword.pressOnGoToSignIn();

            log.info("-> Verify URL after pressed on <Go to sign in> button");
            String urlAfterPressedOnForgotPasswordButton = driver.getCurrentUrl();
            softAssert.assertEquals(urlAfterPressedOnForgotPasswordButton,
                    UrlProvider.SIGN_IN_PAGE_URL.getUrl());

            log.info("-> Test succeeded");
            softAssert.assertAll();
        }
    }
