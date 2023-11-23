package autho.signin;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.helpers.WaitHelper;
import org.example.pages.authorization.ForgotPasswordPage;
import org.example.pages.authorization.SignInPage;
import org.example.pages.home.HomePage;
import org.example.pages.wordpress.WelcomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignInPositiveTests extends BaseTest {

    private final String SIGN_IN_PAGE_URL = "https://dev.vlume.com/";
    Logger logger = LoggerFactory.getLogger("AuthorizationLogger");
    WelcomePage welcomePage;
    SignInPage signInPage;
    HomePage homePage;

    ForgotPasswordPage forgotPasswordPage;
    WaitHelper waitHelper;
    @BeforeMethod
    public void goToUrl(){
        logger.info("driver go to url {}", SIGN_IN_PAGE_URL);
        driver.get(SIGN_IN_PAGE_URL);
        waitHelper = new WaitHelper(driver);
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);

    }

    @Test
    public void IsPageViewsVisible(){
        logger.info("validate all views on the sign in page");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
        driver.switchTo().window(nextWidow());
        waitHelper.waitForElementToBeClickable(signInPage.facebookButton);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://dev.vlume.com/sign-in");
        softAssert.assertTrue(signInPage.facebookButton.isDisplayed());
        softAssert.assertTrue(signInPage.appleButton.isDisplayed());
        softAssert.assertTrue(signInPage.googleButton.isDisplayed());

        softAssert.assertTrue(signInPage.inputEmail.isDisplayed());
        softAssert.assertTrue(signInPage.inputPassword.isDisplayed());

        softAssert.assertTrue(signInPage.signInButton.isDisplayed());
        softAssert.assertTrue(signInPage.signUpButton.isDisplayed());
        softAssert.assertTrue(signInPage.forgotPassword.isDisplayed());

//        softAssert.assertFalse(signInPage.errorMessage.isDisplayed());

        softAssert.assertAll();
    }


    @SneakyThrows
    @Test
    @Parameters({"email","password"})
    public void clickSignIn(String e,String p){
        logger.info("validate sign in button when email and password are valid");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
        driver.switchTo().window(nextWidow());
        waitHelper.waitForElementToBeClickable(signInPage.inputEmail);
        signInPage.inputEmail.sendKeys(e);
        signInPage.inputPassword.sendKeys(p);
        signInPage.clickSignInButton();
        waitHelper.waitForElementToBeClickable(homePage.homeButton);

        Assert.assertTrue(homePage.homeButton.isDisplayed());
    }
    @Test
    public void clickForgotPassword(){
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
        driver.switchTo().window(nextWidow());
        waitHelper.waitForElementToBeClickable(signInPage.signInButton);
        signInPage.clickForgotPassword();
        waitHelper.waitForElementToBeClickable(forgotPasswordPage.sendButton);

        Assert.assertTrue(forgotPasswordPage.sendButton.isDisplayed());
    }

}
