package signin;

import base.BaseTest;
import org.example.pages.auth.SignInPage;
import org.testng.annotations.BeforeMethod;

public class SignInBaseTest extends BaseTest {
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        driver.get("https://dev.vlume.com/");
        signInPage = new SignInPage(driver);
        welcomePage.goToSignInPage();
    }

    protected void setUsernameAndPasswordAndClickLogInButton(String username, String password) {
        signInPage.sendKeysOnUsernameInput(username);
        signInPage.sendKeysOnPasswordInput(password);
        signInPage.clickOnLogInButton();
    }
}
