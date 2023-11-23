package autho.signin;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.helpers.WaitHelper;
import org.example.pages.authorization.ForgotPasswordPage;
import org.example.pages.authorization.SignInPage;
import org.example.pages.home.HomePage;
import org.example.pages.wordpress.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

@Slf4j(topic = "AuthorizationLogger")
public class SignInPositiveTests extends BaseTest {
    WelcomePage welcomePage;
    SignInPage signInPage;
    HomePage homePage;
    ForgotPasswordPage forgotPasswordPage;
    WaitHelper waitHelper;

    @BeforeMethod
    public void goToUrl() {

        goToURL(WELCOME_PAGE_URL);

        waitHelper = new WaitHelper(driver);
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);

    }

    @Test
    public void verifySignInPageIsOpened() {
        Set<String> windowHandles = driver.getWindowHandles();
        String firstWindow = windowHandles.iterator().next();

        log.info("Switch to first window");
        driver.switchTo().window(firstWindow);

        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next widow");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());
    }


    @Test
    @Parameters({"email", "password"})
    public void verifySignInButtonWithCorrectEmailAndPassword(String e, String p) {
        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next window");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write correct email {}", e);
        signInPage.inputEmail.sendKeys(e);

        log.info("Write correct password {}", p);
        signInPage.inputPassword.sendKeys(p);

        log.info("Click sign in button");
        signInPage.clickSignInButton();

        log.info("Assert home page is openid");
        Assert.assertTrue(homePage.isPageOpened());
    }

    @Test
    public void verifyForgotPasswordButton() {
        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next window");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Click forgot password button");
        signInPage.clickForgotPassword();

        log.info("Assert forgot page is openid");
        Assert.assertTrue(forgotPasswordPage.isPageOpened());
    }

}
