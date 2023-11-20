package signup;

import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest1 extends BaseTest {

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
    public void signUpTest1() {
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

}
