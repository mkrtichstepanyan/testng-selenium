package vlume.positivetests.welcomepage;

import org.example.vlume.pages.wordpress.WelcomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vlume.BaseTest;

public class WelcomePageTests2 extends BaseTest {
    WelcomePage welcomePage;

    @BeforeMethod
    public void goToUrl() {
        driver.get("https://dev.vlume.com/");
        welcomePage = new WelcomePage(driver);
    }

    @Test
    public void signUpTest() {
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

    @Test
    public void signUpTest2() {
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }
}


