package auto.signin;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.helpers.WaitHelper;
import org.example.pages.autorotation.ForgotPassword;
import org.example.pages.autorotation.SignInPage;
import org.example.pages.home.HomePage;
import org.example.pages.wordpress.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTests extends BaseTest {

    WelcomePage welcomePage;
    SignInPage signInPage;
    HomePage homePage;

    ForgotPassword forgotPassword;
    WaitHelper waitHelper;
    @BeforeMethod
    public void goToUrl(){
        driver.get("https://dev.vlume.com/");
        waitHelper = new WaitHelper(driver);
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        forgotPassword = new ForgotPassword(driver);

    }

    @Test
    public void IsPageViewsVisible(){
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
        Thread.sleep(1000);
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
        driver.switchTo().window(nextWidow());
        Thread.sleep(1000);

        signInPage.inputEmail.sendKeys(e);
        signInPage.inputPassword.sendKeys(p);
        Thread.sleep(1000);

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
        waitHelper.waitForElementToBeClickable(forgotPassword.sendButton);

        Assert.assertTrue(forgotPassword.sendButton.isDisplayed());
    }

}
