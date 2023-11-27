package vlume.positivetests.application.asidepanel.search;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.application.asidepanel.search.SearchPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SearchPagePositiveTests extends BaseTest {

    SignInPage signInPage;
    SearchPage search;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("samsungansuryan@gmail.com");
        signInPage.enterPassword("8663a375315");
        signInPage.pressSignInButton();
        waitHelper.waitForSeconds(3);
    }

    @BeforeMethod
    public void goToHomePage(){

        log.info("-> Open Home page");
        driver.get(UrlProvider.HOME_PAGE_URL.getUrl());
        search = new SearchPage(driver);
        boolean pageIsLoaded = search.searchPageIsLoaded();
        softAssert = new SoftAssert();
        softAssert.assertTrue(pageIsLoaded);
    }

    @Test
    public void validatePressOnSearchIcon(){

        log.info("-> Validate current URL before press on Search icon");
        String urlBeforePressOnSearchIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSearchIcon, UrlProvider.WELCOME_PAGE_URL.getUrl());

        log.info("-> Press on Search icon from aside panel");
        waitHelper.waitForElementToBeClickable(search.searchIcon);
        search.pressOnSearchIconFromAsidePanel();

        log.info("-> Validate current URL after pressed on Search icon");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnSearchIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSearchIcon, UrlProvider.SEARCH_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

}
