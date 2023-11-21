package auto.signup;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.pages.autorotation.SignInPage;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    WelcomePage welcomePage;

    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        driver.get("https://dev.vlume.com/");
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
    }

//    @SneakyThrows
//    @Test
//    public void signUpTest() {
//        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
//        welcomePage.clickOnSignInButton();
//    }
//
//    @SneakyThrows
//    @Test
//    public void signUpTest1() {
//        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
//        welcomePage.clickOnSignInButton();
//    }

    @SneakyThrows
    @Test
    public void findFacebookButton() {
        Thread.sleep(2000);
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
        Thread.sleep(3000);

//        waitHelper.waitForElementToBeClickable(signInPage.facebookButton);
//        signInPage.clickFacebookButton();

        System.out.println(driver.findElement(By.xpath("//div//div//button[@id = 'loginButton']")).getText());
    }

}
