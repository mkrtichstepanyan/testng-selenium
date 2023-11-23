package autho.signin;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.example.helpers.WaitHelper;
import org.example.pages.authorization.SignInPage;
import org.example.pages.wordpress.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class SignInNegativeTests extends BaseTest {

    WelcomePage welcomePage;
    SignInPage signInPage;
    WaitHelper waitHelper;

    @BeforeMethod
    public void goToUrl() {
        goToURL(WELCOME_PAGE_URL);

        waitHelper = new WaitHelper(driver);
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void signIn() {

        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next window");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write incorrect Email {} ", "lklk");
        signInPage.inputEmail.sendKeys("lklk");

        log.info("Write incorrect password {} ", "lklk");
        signInPage.inputPassword.sendKeys("lklk");

        log.info("Click on Sign in button");
        signInPage.clickSignInButton();

        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        String actualErrorMessage = signInPage.errorMessage.getText();

        log.info("Assert error message is correct");
        Assert.assertEquals(actualErrorMessage, "Wrong credentials");
    }
}
