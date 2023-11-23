package signup;

import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.example.pages.BasePage;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    WelcomePage welcomePage;

    @BeforeMethod(onlyForGroups = "bla")
    public void goToUrl() {
        System.out.println("bla BeforeMethod ");
        driver.get("https://dev.vlume.com/");
        welcomePage = new WelcomePage(driver);
    }

    @Test(groups = {"bla"})
    public void signUpTest() {
        System.out.println("bla");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

    @Test(groups = "bla")
    public void signUpTest1() {
        System.out.println("not bla");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

}
