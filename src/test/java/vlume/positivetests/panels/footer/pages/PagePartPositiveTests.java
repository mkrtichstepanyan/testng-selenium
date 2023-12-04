package vlume.positivetests.panels.footer.pages;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.panels.footer.pages.Page;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.example.vlume.providers.urlproviders.footer.UrlPageProvider;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.home.UrlHomeProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class PagePartPositiveTests extends BaseTest {

    Page page;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign in page from Footer");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        page = new Page(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnHomeLink() {

        log.info("-> Validate current URL Sign in page before press on Home link");
        String urlBeforePressOnHomeLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnHomeLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Home link ");
        waitHelper.waitForElementToBeClickable(page.home);
        page.pressOnHomeLink();

        log.info("-> Validate current URL Welcome page after pressed on Home link");
        String urlAfterPressedOnHomeLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnHomeLink, UrlProvider.WELCOME_PAGE_URL.getUrl()); //bug
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnAudiobooksLink() {

        log.info("-> Validate current URL Sign in page before press on Audiobooks link");
        String urlBeforePressOnAudiobooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAudiobooksLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press On Audiobooks link");
        waitHelper.waitForElementToBeClickable(page.audiobooks);
        page.pressOnAudiobooksLink();

        log.info("-> Validate current URL Audiobooks page after pressed Audiobooks link");
        String urlAfterPressedOnAudiobooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAudiobooksLink, UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnEbooksLink() {

        log.info("-> Validate current URL Sign in page before press on Ebooks link");
        String urlBeforePressOnEbooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnEbooksLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Ebooks link");
        waitHelper.waitForElementToBeClickable(page.ebooks);
        page.pressOnEbooksLink();

        log.info("-> Validate current URL Ebooks page after pressed on Ebooks link");
        String urlAfterPressedOnEbooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnEbooksLink, UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnAuthorsLink() {

        log.info("-> Validate current URL Sign in page before press on Authors link");
        String urlBeforePressOnAuthorsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAuthorsLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Authors link");
        waitHelper.waitForElementToBeClickable(page.authors);
        page.pressOnAuthorsLink();

        log.info("-> Validate current URL Authors page after pressed on Authors link");
        String urlAfterPressedOnAuthorsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAuthorsLink, UrlAsidePanelProvider.AUTHORS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnRecentlyAddedLink() {

        log.info("-> Validate current URL Home page before press on Recently added link ");
        String urlBeforePressOnRecentlyAddedLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnRecentlyAddedLink, UrlProvider.WELCOME_PAGE_URL.getUrl());

        log.info("-> Press on Recently Added link");
        waitHelper.waitForElementToBeClickable(page.recentlyAdded);
        page.pressOnRecentlyAddedLink();

        log.info("-> Validate current URL Recently added page after pressed on Recently added link");
        String urlAfterPressedOnRecentlyAddedLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnRecentlyAddedLink,
                UrlHomeProvider.RECENTLY_ADDED_PAGE_UPL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnTrendingLink() {

        log.info("-> Validate current URL Sign in page before press on Trending link");
        String urlBeforePressOnTrendingLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTrendingLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Trending link");
        waitHelper.waitForElementToBeClickable(page.trending);
        page.pressOnTrendingLink();

        log.info("-> Validate current URL Trending page after pressed on Trending link");
        String urlAfterPressedOnTrendingLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTrendingLink, UrlHomeProvider.TRENDING_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnCategoriesLink() {

        log.info("-> Validate current URL Sign in page before press on Categories link");
        String urlBeforePressOnCategoriesLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnCategoriesLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Categories link");
        waitHelper.waitForElementToBeClickable(page.categories);
        page.pressOnCategoriesLink();

        log.info("-> Validate current URL Categories page after pressed on Categories link");
        String urlAfterPressedOnCategoriesLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnCategoriesLink, UrlPageProvider.CATEGORIES_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
