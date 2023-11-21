package signin;

import base.BaseTest;
import dev.failsafe.internal.util.Assert;
import org.apache.hc.core5.util.Asserts;
import org.asynchttpclient.util.Assertions;
import org.example.helpers.WaitHelper;
import org.example.pages.autorotation.SignInPage;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.Set;

public class SignInTests extends BaseTest {

    WelcomePage welcomePage;
    SignInPage signInPage;
    WaitHelper waitHelper;
    @BeforeMethod
    public void goToUrl(){
        driver.get("https://dev.vlume.com/");
        waitHelper = new WaitHelper(driver);
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void IsPageViewsVisible(){
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
        driver.switchTo().window(nextWidow(driver));
        waitHelper.waitForElementToBeClickable(signInPage.facebookButton);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(signInPage.facebookButton.isDisplayed());
        softAssert.assertTrue(signInPage.googleButton.isDisplayed());
        softAssert.assertTrue(signInPage.appleButton.isDisplayed());

        softAssert.assertTrue(signInPage.signInButton.isDisplayed());
        softAssert.assertTrue(signInPage.signUpButton.isDisplayed());
        softAssert.assertEquals(driver.getCurrentUrl(),"https://dev.vlume.com/sign-in");

        softAssert.assertAll();
    }




    private String nextWidow(WebDriver driver) {
        Set<String> setWidows = driver.getWindowHandles();
        Iterator<String> iterator = setWidows.iterator();
        String currentWindow = iterator.next();
        for (int i = 1; i <= 2; i++) {
            if (iterator.hasNext()) {
                currentWindow = iterator.next();
            }
        }
        return currentWindow;
    }
}
