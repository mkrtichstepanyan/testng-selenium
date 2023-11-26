package org.example.signup;

import org.example.BaseTest;
import org.example.pages.wordpress.welcomepage.WelcomePage;
import org.testng.annotations.*;

public class SignUpTest extends BaseTest {

    WelcomePage welcomePage;

    @BeforeMethod
    public void goToUrl() {
        driver.get(WELCOME_PAGE_URL);
        welcomePage = new WelcomePage(driver);
    }

    @Test
    public void signUpTest() {
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

    @Test
    public void signUpTest1() {
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }
}
