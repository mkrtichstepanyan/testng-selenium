package home;

import base.BaseTest;
import dataProvider.email.EmailsProvider;
import dataProvider.password.PasswordsProvider;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.authorization.SignInPage;
import org.example.pages.home.HomeLeftPage;
import org.example.pages.home.HomePage;
import org.example.pages.wordpress.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class HomePositiveTest extends BaseTest {

    WelcomePage welcomePage;
    SignInPage signInPage;
    HomePage homePage;
    HomeLeftPage homeLeftPage;

    @BeforeMethod
    public void createPages(){
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        homeLeftPage = new HomeLeftPage(driver);
    }

    @Test(priority = 1)
    public void verifyHomePageIsOpened() {
        goToURL(UrlsProvider.WELCOME_PAGE_URL);

        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Clock on sign in button");
        welcomePage.clickOnSignInButton();

        log.info("Switch to nest window");
        driver.switchTo().window(nextWidow());

        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write correct email {}", EmailsProvider.correctEmail);
        signInPage.inputEmail.sendKeys(EmailsProvider.correctEmail);

        log.info("Write correct password {}", PasswordsProvider.correctPassword);
        signInPage.inputPassword.sendKeys(PasswordsProvider.correctPassword);

        log.info("Clock on sign in button");
        signInPage.clickOnSignInButton();

        log.info("Assert home page is openid");
        Assert.assertTrue(homePage.isPageOpened());

    }

    @Test(priority = 2)
    public void verifyHomePagesTopPanelIsOpened() {
        goToURL(UrlsProvider.HOME_PAGE_URL);

        log.info("Assert home top panel is visible");
        Assert.assertTrue(homePage.getTopPanel().isTopPanelVisible());
    }

    @Test(priority = 3)
    public void verifyHomeLeftPageIsOpened() {
        goToURL(UrlsProvider.HOME_PAGE_URL);

        log.info("Assert home top panel is visible");
        Assert.assertTrue(homeLeftPage.isPageOpened());
    }

}