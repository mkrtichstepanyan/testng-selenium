package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.EbooksPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.providers.urlproviders.home.UrlEbooksProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class EbookPageTests extends BaseTest {
    EbooksPage ebooksPage;
    SignInPage signInPage;

    @BeforeMethod
    public void signIn() {
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("ani.kovalenko97@gmail.com");
        signInPage.enterPassword("NewPassword");
        signInPage.clickOnSignInButton();
    }

    @Test
    public void validatePageLoading() {
        log.info("Open Ebooks Page");
        driver.get(UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());
        ebooksPage = new EbooksPage(driver);
        softAssert = new SoftAssert();

        log.info("Ebooks Page is Loaded Successfully");
        boolean pageIsLoaded = ebooksPage.ebooksPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void validatePressOnRecentlyAddedPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Recently Added part");
        String urlBeforePressOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnRecentlyAddedPart, UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Recently Added part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(ebooksPage.recentlyAddedPart);
        ebooksPage.pressOnRecentlyAddedPart();

        log.info("-> Validate current URL after pressed on Recently Added part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnRecentlyAddedPart,
                UrlEbooksProvider.RECENTLY_ADDED_EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void validatePressOnTrendingNowPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Trending now part");
        String urlBeforePressOnTrendingNowPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTrendingNowPart, UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Trending now part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(ebooksPage.trendingNowPart);
        ebooksPage.pressOnTrendingNowPart();

        log.info("-> Validate current URL after pressed on Trending noe part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnTrendingNoePart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTrendingNoePart,
                UrlEbooksProvider.TRENDING_NOW_EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void validatePressOnOurTopPicksPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Our top Picks part");
        String urlBeforePressOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnOurTopPicksPart, UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Our top picks part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(ebooksPage.ourTopPicksPart);
        ebooksPage.pressOnOurTopPicks();

        log.info("-> Validate current URL after pressed on Our top picks part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnOurTopPicksPart,
                UrlEbooksProvider.OUR_TOP_PICKS_EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void validatePressOnMostReadPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Most read part");
        String urlBeforePressOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnMostReadPart, UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Most Read part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(ebooksPage.mostReadPart);
        ebooksPage.pressOnMostReadPart();

        log.info("-> Validate current URL after pressed on Most Read part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnMostReadPart,
                UrlEbooksProvider.MOST_READ_EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void validatePressOnTopFictionPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Top fiction part");
        String urlBeforePressOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopFictionPart, UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Top Fiction part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(ebooksPage.topFictionPart);
        ebooksPage.pressOnTopFictionPart();

        log.info("-> Validate current URL after pressed on Top fiction part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopFictionPart,
                UrlEbooksProvider.TOP_FICTION_EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void validatePressOnTopNonFictionPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Top non fiction part");
        String urlBeforePressOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopNonFictionPart, UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Top non Fiction part");
        waitHelper.waitForSeconds(4);
        waitHelper.waitForElementToBeClickable(ebooksPage.topNonFiction);
        ebooksPage.pressOnTopNonFictionPart();

        log.info("-> Validate current URL after pressed on Top non fiction part");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopNonFictionPart,
                UrlEbooksProvider.TOP_NON_FICTION_EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
