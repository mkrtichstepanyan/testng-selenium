package signup;

import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {

    WebDriver driver;
    WelcomePage welcomePage = new WelcomePage();

    @BeforeMethod
    public void goToUrl() {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();
        driver.get("https://dev.vlume.com/");
        WaitHelper.waitUntilElementWillBeVisible(welcomePage.signInButton);
    }


    @Test
    public void signUpTest() {
        welcomePage.clickOnSignInButton();
    }

    @Test
    public void signUpTest1() {
        welcomePage.clickOnSignInButton();
    }


    @AfterMethod
    public void closeDriver() {
        DriverFactory.closeDriver();
    }
}
