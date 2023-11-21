package signup;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.pages.wordpress.WelcomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest1 extends BaseTest {

    WelcomePage welcomePage;

    @BeforeMethod
    public void goToUrl() {
        driver.get("https://dev.vlume.com/");
        welcomePage = new WelcomePage(driver);
    }


    @SneakyThrows
    @Test
    public void signUpTest() {
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

    @SneakyThrows
    @Test
    public void signUpTest1() {
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

}
