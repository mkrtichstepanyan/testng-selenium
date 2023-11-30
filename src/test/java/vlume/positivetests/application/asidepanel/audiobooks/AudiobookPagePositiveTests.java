package vlume.positivetests.application.asidepanel.audiobooks;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.audiobooks.AudiobooksPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.home.UrlAudiobooksProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class AudiobookPagePositiveTests extends BaseTest {

    SignInPage signInPage;
    AudiobooksPage audiobooks;

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

    @BeforeMethod
    public void goToAudiobooksPage() {

        log.info("-> Open Audiobooks page");
        driver.get(UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());
        audiobooks = new AudiobooksPage(driver);
        Assert.assertTrue(audiobooks.audiobooksPageIsLoaded(), "Audiobooks page is not loaded");
    }

    @Test(priority = 1)
    public void validatePressOnRecentlyAddedPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Recently Added part");
        String urlBeforePressOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnRecentlyAddedPart,
                UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Press on Recently Added part");
        waitHelper.waitForSeconds(5);
        waitHelper.waitForElementToBeClickable(audiobooks.recentlyAddedPart);
        audiobooks.pressOnRecentlyAddedPart();

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
        waitHelper.waitUntilElementWillBeVisible(audiobooks.trendingNowPart);
        audiobooks.pressOnTrendingNowPart();

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
        waitHelper.waitForElementToBeClickable(audiobooks.ourTopPicksPart);
        audiobooks.pressOnOurTopPicks();

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
        waitHelper.waitForElementToBeClickable(audiobooks.mostReadPart);
        audiobooks.pressOnMostReadPart();

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
        waitHelper.waitForElementToBeClickable(audiobooks.topFictionPart);
        audiobooks.pressOnTopFictionPart();

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
        waitHelper.waitForElementToBeClickable(audiobooks.topNonFiction);
        audiobooks.pressOnTopNonFictionPart();

        log.info("-> Validate current URL after pressed on Top non fiction part");
        waitHelper.waitForSeconds(5);
        String urlAfterPressedOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopNonFictionPart,
                UrlAudiobooksProvider.TOP_NON_FICTION_AUDIOBOOKS_URL.getUrl());
        softAssert.assertAll();
    }

}
