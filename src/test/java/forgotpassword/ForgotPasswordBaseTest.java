package forgotpassword;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.pages.auth.ForgotPasswordPage;
import org.example.pages.auth.SignInPage;
import org.testng.annotations.BeforeMethod;

public class ForgotPasswordBaseTest extends BaseTest {
    protected SignInPage signInPage;
    protected ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    @SneakyThrows
    public void goToUrl() {
        signInPage = new SignInPage(driver);
        driver.get("https://dev.vlume.com/");
        welcomePage.isPageOpened();
        forgotPasswordPage = new ForgotPasswordPage(driver);
        welcomePage.goToSignInPage();
        signInPage.isPageOpened();
        signInPage.clickOnForgotPasswordButton();
        waitHelper.waitForElementsToBeVisible(forgotPasswordPage.webElements);
    }


}
