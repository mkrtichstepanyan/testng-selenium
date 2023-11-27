package signup;

import base.BaseTest;
import org.example.pages.auth.SignInPage;
import org.example.pages.auth.SignUpPage;
import org.testng.annotations.BeforeMethod;

public class SignUpBaseTest extends BaseTest {
    SignInPage signInPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        driver.get("https://dev.vlume.com/");
        welcomePage.isPageOpened();
        welcomePage.goToSignInPage();
        signInPage.isPageOpened();
        signInPage.clickOnSignUpButton();
        signUpPage.isPageOpened();
    }

    protected void setUsernameAndPasswordsAndClickSignUpButton(String username, String password, String confirmPassword) {
        signUpPage.enterTheEmail(username);
        signUpPage.enterThePassword(password);
        signUpPage.enterTheConfirmPassword(confirmPassword);
        signUpPage.clickOnSignUpButton();
    }

}
