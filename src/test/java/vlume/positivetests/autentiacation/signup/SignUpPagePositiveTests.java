package vlume.positivetests.autentiacation.signup;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.autentication.signup.SignUpPage;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SignUpPagePositiveTests extends BaseTest {
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open sign up page");
        driver.get(UrlProvider.SIGN_UP_PAGE_URL.getUrl());
        signUpPage = new SignUpPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnFbButton() {
        log.info("-> Press on <Facebook> button for sign up");
        waitHelper.waitForElementToBeClickable(signUpPage.continueWithFbButton);
        signUpPage.pressOnFbButton();
    }

    @Test
    public void validatePressOnGoogleButton() {
        log.info("-> Press on <Google> button for sign up");
        waitHelper.waitForElementToBeClickable(signUpPage.signInWithGoogle);
        signUpPage.pressOnGoogleButton();
    }

    @Test
    public void validateSignUpProcess() {
        waitHelper.waitForElementToBeClickable(signUpPage.emailField);

        log.info("-> Write current email");
        signUpPage.enterEmail("@gmail.com");

        log.info("-> Create password");
        signUpPage.enterPassword("0000");

        log.info("-> Confirm password");
        signUpPage.enterConfirmPassword("0000");

        log.info("-> Press on <Sign up> button");
        signUpPage.pressOnSignUpButton();
    }

    @Test
    public void validatePressOnForgotPasswordButton() {
        log.info("-> Verify URL before press on <Forgot password> button");
        String urlBeforePressOnForgotPasswordButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnForgotPasswordButton, UrlProvider.SIGN_UP_PAGE_URL.getUrl());

        log.info("-> Press on <Forgot password> button");
        waitHelper.waitForElementToBeClickable(signUpPage.forgotPasswordLink);
        signUpPage.pressOnForgotPassword();

        log.info("-> Verify URL after pressed on <Forgot password> button");
        String urlAfterPressedOnForgotPasswordButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnForgotPasswordButton,
                UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
