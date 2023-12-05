package signup;

import io.qameta.allure.*;
import org.example.pages.wordpress.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class SignUpTest extends BaseTest {

    WelcomePage welcomePage;

    @BeforeMethod
    public void goToUrl() {
        System.out.println("bla BeforeMethod ");
        driver.get("https://dev.vlume.com/");
        welcomePage = new WelcomePage(driver);
    }

    @Test
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void signUpTest() {
        System.out.println("bla");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }

    @Test
    public void signUpTest1() {
        System.out.println("not bla");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
    }



    @Test
    @Description("This tes a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(BLOCKER)
    @Owner("John")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void signUpTest2() {
        System.out.println("bla");
    }

    @Test
    @Description("This tes a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(SeverityLevel.MINOR)
    @Owner("John")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void signUpTest3() {
        Assert.assertTrue(false);
    }

}
