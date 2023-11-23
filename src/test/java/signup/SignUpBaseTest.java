package signup;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.pages.auth.SignInPage;
import org.example.pages.auth.SignUpPage;
import org.testng.annotations.BeforeMethod;

public class SignUpBaseTest extends BaseTest {
    SignInPage signInPage;
    SignUpPage signUpPage;

    @BeforeMethod
    @SneakyThrows
    public void goToUrl() {
        driver.get("https://dev.vlume.com/");
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        welcomePage.goToSignInPage();
        signInPage.clickOnSignUpButton();
     //   Thread.sleep(2000);
    }

    protected void setUsernameAndPasswordAndClickLogInButton(String username, String password) {
        signInPage.sendKeysOnUsernameInput(username);
        signInPage.sendKeysOnPasswordInput(password);
        signInPage.clickOnLogInButton();
    }

}
