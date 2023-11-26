package autho.forgot_password;

import base.BaseTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.authorization.ForgotPasswordPage;
import org.example.panel.TopPanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j(topic = "AuthorizationLogger")
public class ForgotPasswordPositiveTests extends BaseTest {
    ForgotPasswordPage forgotPassword;
    TopPanel topPanel;

    @BeforeMethod
    public void goToUrl() {
        log.info("driver go to url {}", UrlsProvider.FORGOT_PASSWORD_PAGE_URL);
        goToURL(UrlsProvider.FORGOT_PASSWORD_PAGE_URL);
        forgotPassword = new ForgotPasswordPage(driver);
        topPanel = forgotPassword.getTopPanel(driver);
    }

    @Test
    public void verifyTopPanelIsVisible() {
        log.info("Assert forgot password page's top panel is visible");
        Assert.assertTrue(topPanel.isTopPanelVisible());
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

        log.info("Assert forgot password page is: {}", UrlsProvider.FORGOT_PASSWORD_PAGE_URL);
        Assert.assertEquals(driver.getCurrentUrl(), UrlsProvider.FORGOT_PASSWORD_PAGE_URL);
    }
}
