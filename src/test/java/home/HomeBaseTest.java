package home;

import base.BaseTest;
import lombok.SneakyThrows;
import org.example.pages.auth.SignInPage;
import org.example.pages.home.HomePage;
import org.example.pages.panel.LeftBar;
import org.testng.annotations.BeforeMethod;

public class HomeBaseTest extends BaseTest {
    SignInPage signInPage;
    HomePage homePage;
    LeftBar leftBar;

    @BeforeMethod
    @SneakyThrows
    public void goToUrl() {
        signInPage = new SignInPage(driver);
        leftBar = new LeftBar(driver);
        driver.get("https://dev.vlume.com/");
        welcomePage.isPageOpened();
        welcomePage.goToSignInPage();
        signInPage.isPageOpened();
        signInPage.enterTheEmail("zara.avetyan.2004@mail.ru");
        signInPage.enterThePassword("correctPassword");
        signInPage.clickOnSignInButton();
        signInPage.isPageOpened();
        waitHelper.waitForElementsToBeVisible(leftBar.webElements);
    }
}
