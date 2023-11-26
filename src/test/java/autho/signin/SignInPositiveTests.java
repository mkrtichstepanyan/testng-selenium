package autho.signin;

import base.BaseTest;
import dataProvider.email.EmailsProvider;
import dataProvider.password.PasswordsProvider;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.authorization.ForgotPasswordPage;
import org.example.pages.authorization.SignInPage;
import org.example.pages.home.HomePage;
import org.example.panel.TopPanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j(topic = "AuthorizationLogger")
public class SignInPositiveTests extends BaseTest {
    SignInPage signInPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;
    TopPanel topPanel;

    @BeforeMethod
    public void goToUrl() {
        goToURL(UrlsProvider.SIGN_IN_PAGE_URL);

        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        topPanel = signInPage.getTopPanel(driver);

    }

    @Test
    public void verifyTopPanelIsVisible() {
        log.info("Assert sign in page's top panel is visible");
        Assert.assertTrue(topPanel.isTopPanelVisible());
    }

    @Test
    public void verifySignInPageIsOpened() {
//        Set<String> windowHandles = driver.getWindowHandles();
//        String firstWindow = windowHandles.iterator().next();
//
//        log.info("Switch to first window");
//        driver.switchTo().window(firstWindow);
//
//        log.info("Assert Welcome page is opened");
//        Assert.assertTrue(welcomePage.isPageOpened());
//
//        log.info("Click sign in button");
//        welcomePage.clickOnSignInButton();
//
//        log.info("Switch driver to next widow");
//        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());
    }


    @Test
    public void verifySignInWithCorrectEmailAndPassword() {
//        log.info("Assert Welcome page is opened");
//        Assert.assertTrue(welcomePage.isPageOpened());
//
//        log.info("Click sign in button");
//        welcomePage.clickOnSignInButton();
//
//        log.info("Switch driver to next window");
//        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write correct email {}", EmailsProvider.correctEmail);
        signInPage.inputEmail.sendKeys(EmailsProvider.correctEmail);

        log.info("Write correct password {}", PasswordsProvider.correctPassword);
        signInPage.inputPassword.sendKeys(PasswordsProvider.correctPassword);

        log.info("Click sign in button");
        signInPage.clickOnSignInButton();

        log.info("Assert home page is openid");
        Assert.assertTrue(homePage.isPageOpened());
    }

    @Test
    public void verifyForgotPasswordButton() {
//        log.info("Assert Welcome page is opened");
//        Assert.assertTrue(welcomePage.isPageOpened());
//
//        log.info("Click sign in button");
//        welcomePage.clickOnSignInButton();
//
//        log.info("Switch driver to next window");
//        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Click forgot password button");
        signInPage.clickOnForgotPassword();

        log.info("Assert forgot page is openid");
        Assert.assertTrue(forgotPasswordPage.isPageOpened());
    }

}
