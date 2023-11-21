package auto.signin;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.helpers.WaitHelper;
import org.example.pages.autorotation.SignInPage;
import org.example.pages.wordpress.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeTests extends BaseTest {

    WelcomePage welcomePage;
    SignInPage signInPage;
    WaitHelper waitHelper;
    @BeforeMethod
    public void goToUrl(){
        driver.get("https://dev.vlume.com/");
        waitHelper = new WaitHelper(driver);
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @SneakyThrows
    @Test
    public void signIn(){
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();
        driver.switchTo().window(nextWidow());
        waitHelper.waitForElementToBeClickable(signInPage.signInButton);
        signInPage.inputEmail.sendKeys("lklk");
        signInPage.inputPassword.sendKeys("lklk");
        Thread.sleep(2000);
        signInPage.clickSignInButton();
        Thread.sleep(500);
        Assert.assertTrue(signInPage.errorMessage.isDisplayed());
        Thread.sleep(500);

    }

}
