package autho.signin;

import base.BaseTest;
import dataProvider.email.EmailsProvider;
import dataProvider.password.PasswordsProvider;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.authorization.SignInPage;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.By;
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

    @Test
    public void verifySignInWithInValidEmail() {

        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next window");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write invalid Email {} ", EmailsProvider.inValidEmail);
        signInPage.inputEmail.sendKeys(EmailsProvider.inValidEmail);

        log.info("Write correct password {} ", PasswordsProvider.correctPassword);
        signInPage.inputPassword.sendKeys(PasswordsProvider.correctPassword);

        log.info("Click on Sign in button");
        signInPage.clickSignInButton();

        log.info("Wait for error message is visible");
        waitHelper.waitForElementToVisible(By.xpath("//snack-bar-container//span"));

        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        String actualErrorMessage = signInPage.errorMessage.getText();

        log.info("Assert error message is correct");
        Assert.assertEquals(actualErrorMessage, "Wrong credentials");
    }

    @Test
    public void verifySignInWithStartWithSnikEmail() {

        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next window");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write inCorrect email start with @ {} ", EmailsProvider.inCorrectEmailStartWithShnik);
        signInPage.inputEmail.sendKeys(EmailsProvider.inCorrectEmailStartWithShnik);

        log.info("Write correct password {} ", PasswordsProvider.correctPassword);
        signInPage.inputPassword.sendKeys(PasswordsProvider.correctPassword);

        log.info("Click on Sign in button");
        signInPage.clickSignInButton();

        log.info("Wait for error message is visible");
        waitHelper.waitForElementToVisible(By.xpath("//snack-bar-container//span"));

        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        String actualErrorMessage = signInPage.errorMessage.getText();

        log.info("Assert error message is correct");
        Assert.assertEquals(actualErrorMessage, "Wrong credentials");
    }

    @Test
    public void verifySignInWithWithoutShnikEmail() {

        log.info("Assert Welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Click on Sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch driver to next window");
        driver.switchTo().window(nextWidow());

        log.info("Assert Sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write incorrect email without @ {} ", EmailsProvider.inCorrectEmailWithoutShnik);
        signInPage.inputEmail.sendKeys(EmailsProvider.inCorrectEmailWithoutShnik);

        log.info("Write correct password {} ", PasswordsProvider.correctPassword);
        signInPage.inputPassword.sendKeys(PasswordsProvider.correctPassword);

        log.info("Click on Sign in button");
        signInPage.clickSignInButton();

        log.info("Wait for error message is visible");
        waitHelper.waitForElementToVisible(By.xpath("//snack-bar-container//span"));

        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        String actualErrorMessage = signInPage.errorMessage.getText();

        log.info("Assert error message is correct");
        Assert.assertEquals(actualErrorMessage, "Wrong credentials");
    }
}
