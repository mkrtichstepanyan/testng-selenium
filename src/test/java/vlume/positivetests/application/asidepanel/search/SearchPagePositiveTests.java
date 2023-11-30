package vlume.positivetests.application.asidepanel.search;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.search.SearchPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
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

        log.info("-> Write email information");
        signInPage.enterEmail("@gmail.com");

        log.info("-> Write password information");
        signInPage.enterPassword("0000");

        log.info("-> Press on <Sign in> button");
        signInPage.pressSignInButton();
        waitHelper.waitForSeconds(3);
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
    }

   @Test
    public void goToSearchPage() {

        log.info("-> Open Search page");
        driver.get(UrlAsidePanelProvider.SEARCH_PAGE_URL.getUrl());
        search = new SearchPage(driver);
        Assert.assertTrue(search.searchPageIsLoaded(), "Search page is not poaded");
    }
}
