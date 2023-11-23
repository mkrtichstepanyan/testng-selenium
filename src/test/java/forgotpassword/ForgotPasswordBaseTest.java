package forgotpassword;

import base.BaseTest;
import org.example.pages.auth.ForgotPasswordPage;
import org.example.pages.auth.SignInPage;
import org.testng.annotations.BeforeMethod;

public class ForgotPasswordBaseTest extends BaseTest {
    protected SignInPage signInPage;
    protected ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void goToUrl() {
        driver.get("https://dev.vlume.com/");
        signInPage = new SignInPage(driver);
        welcomePage.goToSignInPage();
        signInPage.clickOnForgotPasswordButton();
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }


}
