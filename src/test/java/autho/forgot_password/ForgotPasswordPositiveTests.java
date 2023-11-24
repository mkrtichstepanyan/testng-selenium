package autho.forgot_password;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.authorization.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j(topic = "AuthorizationLogger")
public class ForgotPasswordPositiveTests extends BaseTest {
    ForgotPasswordPage forgotPassword;

    @BeforeMethod
    public void goToUrl() {
        log.info("driver go to url {}", FORGOT_PASSWORD_PAGE_URL);
        goToURL(FORGOT_PASSWORD_PAGE_URL);
        forgotPassword = new ForgotPasswordPage(driver);
    }

    @Test
    public void verifyForgotPasswordPageIsOpened() {
        log.info("Assert forgot password page is opened");
        Assert.assertTrue(forgotPassword.isPageOpened());
    }

    @Test
    public void verifyForgotPasswordPageUrl() {
        log.info("Assert forgot password page is opened");
        Assert.assertTrue(forgotPassword.isPageOpened());

        log.info("Assert forgot password page is: {}", FORGOT_PASSWORD_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(),FORGOT_PASSWORD_PAGE_URL);
    }
}
