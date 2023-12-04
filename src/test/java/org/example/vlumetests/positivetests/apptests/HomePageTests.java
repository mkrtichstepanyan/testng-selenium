package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.HomePage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.providers.urlproviders.home.UrlHomeProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class HomePageTests extends BaseTest {

    HomePage homePage;
    SignInPage signInPage;

    @BeforeClass
    public void signIn() {
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("ani.kovalenko97@gmail.com");
        signInPage.enterPassword("NewPassword");
        signInPage.clickOnSignInButton();
    }

    @BeforeMethod
    public void goToHomePage() {
        softAssert = new SoftAssert();
        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @Test
    public void validatePageLoading() {
        log.info("Open Home Page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();

        log.info("Home Page is Loaded Successfully");
        boolean pageIsLoaded = homePage.homePageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test(priority = 0)
    public void validatePressOnRecentlyAddedPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Recently Added part");
        String urlBeforePressOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnRecentlyAddedPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Recently Added part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.recentlyAddedPart);
        homePage.pressOnRecentlyAddedPart();

        log.info("-> Validate current URL after pressed on Recently Added part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnRecentlyAddedPart,
                UrlHomeProvider.RECENTLY_ADDED_PAGE_UPL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void validatePressOnFreeThisMonthPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Free this month part");
        String urlBeforePressOnFreeThisMonthPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnFreeThisMonthPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Free this month part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.freeThisMonthPart);
        homePage.pressOnFreeThisMonthPart();

        log.info("-> Validate current URL after pressed on Free this month part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnFreeThisMonthPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnFreeThisMonthPart,
                UrlHomeProvider.FREE_THIS_MONTH_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void validatePressOnTrendingNowPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Trending now part");
        String urlBeforePressOnTrendingNowPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTrendingNowPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Trending now part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.trendingNowPart);
        homePage.pressOnTrendingNowPart();

        log.info("-> Validate current URL after pressed on Trending noe part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnTrendingNoePart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTrendingNoePart, UrlHomeProvider.TRENDING_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void validatePressOnOurTopPicksPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Our top Picks part");
        String urlBeforePressOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnOurTopPicksPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Our top picks part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.ourTopPicks);
        homePage.pressOnOurTopPicks();

        log.info("-> Validate current URL after pressed on Our top picks part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnOurTopPicksPart, UrlHomeProvider.OUR_TOP_PICKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void validatePressOnNewReleasesPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on New Releases part");
        String urlBeforePressOnNewReleasesPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnNewReleasesPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on New releases part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.newReleasesPart);
        homePage.pressOnNewReleasesPart();

        log.info("-> Validate current URL after pressed on New Releases part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnNewReleasesPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnNewReleasesPart, UrlHomeProvider.NEW_RELEASES_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void validatePressOnMostReadPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Most read part");
        String urlBeforePressOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnMostReadPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Most Read part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.mostReadPart);
        homePage.pressOnMostReadPart();

        log.info("-> Validate current URL after pressed on Most Read part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnMostReadPart, UrlHomeProvider.MOST_READ_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void validatePressOnTopFictionPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Top fiction part");
        String urlBeforePressOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopFictionPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Top Fiction part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.topFictionPart);
        homePage.pressOnTopFictionPart();

        log.info("-> Validate current URL after pressed on Top fiction part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopFictionPart, UrlHomeProvider.TOP_FICTION_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void validatePressOnTopNonFictionPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Top non fiction part");
        String urlBeforePressOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopNonFictionPart, UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Top non Fiction part");
        waitHelper.waitForSeconds(4);
        waitHelper.waitForElementToBeClickable(homePage.topNonFictionPart);
        homePage.pressOnTopNonFictionPart();

        log.info("-> Validate current URL after pressed on Top non fiction part");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopNonFictionPart,
                UrlHomeProvider.TOP_NON_FICTION_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
