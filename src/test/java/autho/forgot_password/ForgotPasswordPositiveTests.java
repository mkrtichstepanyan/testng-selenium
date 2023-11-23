package autho.forgot_password;

import base.BaseTest;
import org.example.pages.authorization.ForgotPasswordPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordPositiveTests extends BaseTest {
    ForgotPasswordPage forgotPassword;

    @BeforeMethod
    public void goToUrl() {
         driver.get("https://dev.vlume.com/forgot-password");
         forgotPassword = new ForgotPasswordPage(driver);
    }

    @Test
    public void IsPageViewsVisible(){
        waitHelper.waitForElementToBeClickable(forgotPassword.sendButton);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://dev.vlume.com/forgot-password");
        softAssert.assertTrue(forgotPassword.inputEmail.isDisplayed());
        softAssert.assertTrue(forgotPassword.doToSignInButton.isDisplayed());
        softAssert.assertTrue(forgotPassword.sendButton.isDisplayed());

        softAssert.assertAll();
    }
}
