package signup;

import io.qameta.allure.*;
import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
//        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
//        welcomePage.clickOnSignInButton();
    }

    @Test
    public void signUpTest1() {
//        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
//        welcomePage.clickOnSignInButton();
    }


    @Test
    public void testAuthentication() {
        step1();
        step2();
    }

    @Step("Step 1")
    public void step1() {
        subStep1();
        subStep2();
    }

    @Step("Sub-step 1")
    public void subStep1() {
        // ...
    }

    @Step("Sub-step 2")
    public void subStep2() {
        // ...
    }

    @Step("Step 2")
    public void step2() {
        // ...
    }

    @Test
    @Description("This tes a password not test 2-Factor Authentication.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Bla")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void signUpTest3() {
        Assert.assertTrue(false);
    }

    @Test
    @Description("This tes a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(SeverityLevel.MINOR)
    @Owner("Delta")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void signUpTest4() {
        Assert.assertTrue(true);
    }

}
