package vlume.positivetests.autentiacation.signin;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.authentication.signup.SignUpPage;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SignInPagePositiveTest extends BaseTest {

    SignInPage signInPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validateSignInProcess() {
        waitHelper.waitForElementToBeClickable(signInPage.emailField);

        log.info("-> Write correct email");
        signInPage.enterEmail("@gmail.com");

        log.info("-> Write correct password");
        signInPage.enterPassword("0000");

        log.info("-> Press on <Sign in> button");
        signInPage.pressSignInButton();
    }

    @Test
    public void validatePressOnForgotPasswordButton() {

        log.info("-> Verify URL before press on <Forgot password> button");
        String urlBeforePressOnForgotPasswordButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnForgotPasswordButton, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on <Forgot password> button");
        waitHelper.waitForElementToBeClickable(signInPage.forgotPassword);
        signInPage.pressOnForgotPassword();

        log.info("-> Verify URL after pressed on <Forgot password> button");
        String urlAfterPressedOnForgotPasswordButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnForgotPasswordButton,
                UrlProvider.FORGOT_PASSWORD_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnSignUpButton() {

        log.info("-> Verify URL before press on <Sign Up> button");
        String urlBeforePressOnSignUpButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSignUpButton, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on <Sign up> button");
        waitHelper.waitForElementToBeClickable(signInPage.signUpButton);
        signInPage.pressOnSignUpButton();

        log.info("-> Verify Sign up page loading");
        boolean pageIsLoaded = signUpPage.signUpPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        log.info("-> Verify URL after pressed on <Sign Up> button");
        String urlAfterPressedOnSignUpButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSignUpButton, UrlProvider.SIGN_UP_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnFbButton() {
        log.info("-> Press on <Facebook> button for sign up");
        waitHelper.waitForElementToBeClickable(signInPage.continueWithFbButton);
        signInPage.pressOnFbButton();
    }

    @Test
    public void validatePressOnGoogleButton() {
        log.info("-> Press on <Google> button for sign up");
        waitHelper.waitForElementToBeClickable(signInPage.signInWithGoogle);
        signInPage.pressOnGoogleButton();
        waitHelper.waitForSeconds(10);
    }
}
