package autho.signin;

import base.BaseTest;
import dataProvider.email.EmailsProvider;
import dataProvider.password.PasswordsProvider;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.authorization.SignInPage;
import org.example.pages.wordpress.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class SignInNegativeTests extends BaseTest {

    WelcomePage welcomePage;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        goToURL(UrlsProvider.WELCOME_PAGE_URL);

        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void verifySignInWithIncorrectEmailAndPassword() {

        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next window");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write incorrect Email {} ", EmailsProvider.inCorrectEmail);
        signInPage.inputEmail.sendKeys(EmailsProvider.inCorrectEmail);

        log.info("Write incorrect password {} ", PasswordsProvider.inCorrectPassword);
        signInPage.inputPassword.sendKeys(PasswordsProvider.inCorrectPassword);

        log.info("Click on Sign in button");
        signInPage.clickSignInButton();

        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        String actualErrorMessage = signInPage.errorMessage.getText();

        log.info("Assert error message is correct");
        Assert.assertEquals(actualErrorMessage, "Wrong credentials");
    }
}
