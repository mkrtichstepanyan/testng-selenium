package vlume.positivetests.welcomepage;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.pages.wordpress.WelcomePage;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class WelcomePagePositiveTests extends BaseTest {
    WelcomePage welcomePage;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open welcome page");
        driver.get(UrlProvider.WELCOME_PAGE_URL.getUrl());
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validateGoToSignInPage() {
        log.info("-> Verify current URL before press on <Sign in> button");
        String urlBeforePressOnSignInButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSignInButton, UrlProvider.WELCOME_PAGE_URL.getUrl());

        log.info("-> Press on <Sign in> button");
        waitHelper.waitForElementToBeClickable(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();

        log.info("-> Verify page is loaded");
        waitHelper.waitForSeconds(3);
        boolean pageIsLoaded = signInPage.signInPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        log.info("-> Verify  current URL after pressed on <Sign in> button");
        waitHelper.waitForSeconds(2);
        String urlAfterPressedOnSignInButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSignInButton, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
