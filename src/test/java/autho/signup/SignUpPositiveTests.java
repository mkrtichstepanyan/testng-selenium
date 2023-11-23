package autho.signup;

import base.BaseTest;
import org.example.helpers.WaitHelper;
import org.example.pages.authorization.SignUpPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignUpPositiveTests extends BaseTest {

    WaitHelper waitHelper;

    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl(){
        driver.get("https://dev.vlume.com/sign-up");
        waitHelper = new WaitHelper(driver);
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void IsPageViewsVisible(){
        waitHelper.waitForElementToBeClickable(signUpPage.signUpButton);
        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(signUpPage.title.isDisplayed());
        softAssert.assertTrue(signUpPage.facebookButton.isDisplayed());
        softAssert.assertTrue(signUpPage.appleButton.isDisplayed());
        softAssert.assertTrue(signUpPage.googleButton.isDisplayed());

        softAssert.assertTrue(signUpPage.title2.isDisplayed());
        softAssert.assertTrue(signUpPage.inputEmail.isDisplayed());
        softAssert.assertTrue(signUpPage.inputPassword.isDisplayed());
        softAssert.assertTrue(signUpPage.confirmPassword.isDisplayed());

        softAssert.assertTrue(signUpPage.forgotPassword.isDisplayed());
        softAssert.assertTrue(signUpPage.signUpButton.isDisplayed());
        softAssert.assertTrue(signUpPage.signInButton.isDisplayed());

        softAssert.assertAll();
    }

}
