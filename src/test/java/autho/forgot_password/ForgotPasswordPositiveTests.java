package autho.forgot_password;

import base.BaseTest;
import org.example.pages.authorization.ForgotPasswordPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordPositiveTests extends BaseTest {

    Logger logger = LoggerFactory.getLogger("AuthorizationLogger");
    private final String FORGOT_PASSWORD_PAGE_URL = "https://dev.vlume.com/forgot-password";
    ForgotPasswordPage forgotPassword;

    @BeforeMethod
    public void goToUrl() {
        logger.info("driver go to url {}", FORGOT_PASSWORD_PAGE_URL);
        driver.get(FORGOT_PASSWORD_PAGE_URL);
        forgotPassword = new ForgotPasswordPage(driver);
    }

    @Test
    public void IsPageViewsVisible() {
        waitHelper.waitForElementToBeClickable(forgotPassword.sendButton);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), FORGOT_PASSWORD_PAGE_URL);
        softAssert.assertTrue(forgotPassword.inputEmail.isDisplayed());
        softAssert.assertTrue(forgotPassword.goToSignInButton.isDisplayed());
        softAssert.assertTrue(forgotPassword.sendButton.isDisplayed());

        softAssert.assertAll();
    }
}
