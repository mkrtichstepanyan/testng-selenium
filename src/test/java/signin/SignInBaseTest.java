package signin;

import base.BaseTest;
import org.example.pages.auth.SignInPage;
import org.testng.annotations.BeforeMethod;

public class SignInBaseTest extends BaseTest {
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        signInPage = new SignInPage(driver);
        driver.get("https://dev.vlume.com/");
        welcomePage.isPageOpened();
        welcomePage.goToSignInPage();
        signInPage.isPageOpened();
    }

    protected void setUsernameAndPasswordAndClickLogInButton(String username, String password) {
        signInPage.enterTheEmail(username);
        signInPage.enterThePassword(password);
        signInPage.clickOnSignInButton();
    }
}
