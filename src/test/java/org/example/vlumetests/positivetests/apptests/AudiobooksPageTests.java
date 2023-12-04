package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.AudiobooksPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.providers.urlproviders.home.UrlAudiobooksProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class AudiobooksPageTests extends BaseTest {
    AudiobooksPage audiobooksPage;
    SignInPage signInPage;


    @BeforeClass
    public void signIn() {
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("ani.kovalenko97@gmail.com");
        signInPage.enterPassword("NewPassword");
        signInPage.clickOnSignInButton();
    }

    @Test
    public void validatePageLoading() {
        softAssert = new SoftAssert();
        log.info("Open Audiobooks Page");
        driver.get(UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());
        audiobooksPage = new AudiobooksPage(driver);
        softAssert = new SoftAssert();


        log.info("Audiobooks Page is Loaded Successfully");
        boolean pageIsLoaded = audiobooksPage.audiobooksPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void validatePressOnRecentlyAddedPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Recently Added part");
        String urlBeforePressOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnRecentlyAddedPart, UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Recently Added part");
        waitHelper.waitForSeconds(5);
        waitHelper.waitForElementToBeClickable(audiobooksPage.recentlyAddedPart);
        audiobooksPage.pressOnRecentlyAddedPart();

        log.info("-> Validate current URL after pressed on Recently Added part");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnRecentlyAddedPart,
                UrlAudiobooksProvider.RECENTLY_ADDED_AUDIOBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void validatePressOnTrendingNowPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Trending now part");
        String urlBeforePressOnTrendingNowPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTrendingNowPart, UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Trending now part");
        waitHelper.waitForSeconds(5);
        waitHelper.waitUntilElementWillBeVisible(audiobooksPage.trendingNowPart);
        audiobooksPage.pressOnTrendingNowPart();

        log.info("-> Validate current URL after pressed on Trending noe part");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnTrendingNoePart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTrendingNoePart,
                UrlAudiobooksProvider.TRENDING_NOW_AUDIOBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void validatePressOnOurTopPicksPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Our top Picks part");
        String urlBeforePressOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnOurTopPicksPart, UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Our top picks part");
        waitHelper.waitForSeconds(5);
        waitHelper.waitForElementToBeClickable(audiobooksPage.ourTopPicksPart);
        audiobooksPage.pressOnOurTopPicks();

        log.info("-> Validate current URL after pressed on Our top picks part");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnOurTopPicksPart,
                UrlAudiobooksProvider.OUR_TOP_PICKS_AUDIOBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void validatePressOnMostReadPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Most read part");
        String urlBeforePressOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnMostReadPart, UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Most Read part");
        waitHelper.waitForSeconds(5);
        waitHelper.waitForElementToBeClickable(audiobooksPage.mostReadPart);
        audiobooksPage.pressOnMostReadPart();

        log.info("-> Validate current URL after pressed on Most Read part");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnMostReadPart,
                UrlAudiobooksProvider.MOST_READ_AUDIOBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void validatePressOnTopFictionPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Top fiction part");
        String urlBeforePressOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopFictionPart, UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Top Fiction part");
        waitHelper.waitForSeconds(5);
        waitHelper.waitForElementToBeClickable(audiobooksPage.topFictionPart);
        audiobooksPage.pressOnTopFictionPart();

        log.info("-> Validate current URL after pressed on Top fiction part");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopFictionPart,
                UrlAudiobooksProvider.TOP_FICTION_AUDIOBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void validatePressOnTopNonFictionPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Top non fiction part");
        String urlBeforePressOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopNonFictionPart, UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Top non Fiction part");
        waitHelper.waitForSeconds(5);
        waitHelper.waitForElementToBeClickable(audiobooksPage.topNonFiction);
        audiobooksPage.pressOnTopNonFictionPart();

        log.info("-> Validate current URL after pressed on Top non fiction part");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopNonFictionPart,
                UrlAudiobooksProvider.TOP_NON_FICTION_AUDIOBOOKS_URL.getUrl());
        softAssert.assertAll();
    }

}
