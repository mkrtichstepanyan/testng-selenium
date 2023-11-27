package org.example.vlumetests.positivetests.panels.footer;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.footer.PagesSection;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class PagesSectionTests extends BaseTest {

    PagesSection pagesSection;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign in page from Footer");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        pagesSection = new PagesSection(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnHomeLink() {

        log.info("-> Validate current URL Sign in page before press on Home link");
        String urlBeforePressOnHomeLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnHomeLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Home link ");
        waitHelper.waitForElementToBeClickable(pagesSection.home);
        pagesSection.pressOnHomeLink();
        log.info("-> Validate current URL Welcome page after pressed on Home link");
        String urlAfterPressedOnHomeLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnHomeLink, UrlProvider.WELCOME_PAGE_URL.getUrl()); //bug

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnAudiobooksLink() {

        log.info("-> Validate current URL Sign in page before press on Audiobooks link");
        String urlBeforePressOnAudiobooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAudiobooksLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press On Audiobooks link");
        waitHelper.waitForElementToBeClickable(pagesSection.audiobooks);
        pagesSection.pressOnAudiobooksLink();
        log.info("-> Validate current URL Audiobooks page after pressed Audiobooks link");
        String urlAfterPressedOnAudiobooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAudiobooksLink, UrlProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnEbooksLink() {

        log.info("Validate current URL before pressing on Ebooks link");
        String urlBeforePressOnEbooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnEbooksLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Ebooks link");
        waitHelper.waitForElementToBeClickable(pagesSection.ebooks);
        pagesSection.pressOnEbooksLink();

        log.info("Validate current URL after pressing on Ebooks link");
        String urlAfterPressedOnEbooksLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnEbooksLink, UrlProvider.EBOOKS_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnAuthorsLink() {

        log.info("Validate current URL page before pressing on Authors link");
        String urlBeforePressOnAuthorsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAuthorsLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Authors link");
        waitHelper.waitForElementToBeClickable(pagesSection.authors);
        pagesSection.pressOnAuthorsLink();

        log.info("Validate current URL Authors page after pressing on Authors link");
        String urlAfterPressedOnAuthorsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAuthorsLink, UrlProvider.AUTHORS_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnRecentlyAddedLink() {
        log.info("Validate current URL before pressing on Recently added link ");
        String urlBeforePressOnRecentlyAddedLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnRecentlyAddedLink, UrlProvider.WELCOME_PAGE_URL.getUrl());

        log.info("Press on Recently Added link");
        waitHelper.waitForElementToBeClickable(pagesSection.recentlyAdded);
        pagesSection.pressOnRecentlyAddedLink();

        log.info("Validate current URL Recently added page after pressing on Recently added link");
        String urlAfterPressedOnRecentlyAddedLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnRecentlyAddedLink, UrlProvider.RECENTLY_ADDED_PAGE_UPL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnTrendingLink() {
        log.info("Validate current URL page before pressing on Trending link");
        String urlBeforePressOnTrendingLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTrendingLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Trending link");
        waitHelper.waitForElementToBeClickable(pagesSection.trending);
        pagesSection.pressOnTrendingLink();

        log.info("Validate current URL after pressing on Trending link");
        String urlAfterPressedOnTrendingLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTrendingLink, UrlProvider.TRENDING_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnCategoriesLink() {

        log.info("Validate current URL before pressing on Categories link");
        String urlBeforePressOnCategoriesLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnCategoriesLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Categories link");
        waitHelper.waitForElementToBeClickable(pagesSection.categories);
        pagesSection.pressOnCategoriesLink();

        log.info("Validate current URL after pressing on Categories link");
        String urlAfterPressedOnCategoriesLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnCategoriesLink, UrlProvider.CATEGORIES_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

}
