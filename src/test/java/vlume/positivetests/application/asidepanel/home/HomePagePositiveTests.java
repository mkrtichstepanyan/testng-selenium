package vlume.positivetests.application.asidepanel.home;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class HomePagePositiveTests extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;


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
        homePage = new HomePage(driver);
        boolean pageIsLoaded = homePage.homePageIsLoaded();
        softAssert = new SoftAssert();
        softAssert.assertTrue(pageIsLoaded);
    }

    @Test(priority = 0)
    public void validatePressOnRecentlyAddedPart() {

        log.info("-> Validate current URL before press on Recently Added part");
        String urlBeforePressOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnRecentlyAddedPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Recently Added part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.recentlyAddedPart);
        homePage.pressOnRecentlyAddedPart();

        log.info("-> Validate current URL after pressed on Recently Added part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnRecentlyAddedPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnRecentlyAddedPart,
                UrlProvider.RECENTLY_ADDED_PAGE_UPL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void validatePressOnFreeThisMonthPart() {

        log.info("-> Validate current URL before press on Free this month part");
        String urlBeforePressOnFreeThisMonthPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnFreeThisMonthPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Free this month part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.freeThisMonthPart);
        homePage.pressOnFreeThisMonthPart();

        log.info("-> Validate current URL after pressed on Free this month part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnFreeThisMonthPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnFreeThisMonthPart,
                UrlProvider.FREE_THIS_MONTH_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void validatePressOnTrendingNowPart() {

        log.info("-> Validate current URL before press on Trending now part");
        String urlBeforePressOnTrendingNowPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTrendingNowPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Trending now part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.trendingNowPart);
        homePage.pressOnTrendingNowPart();

        log.info("-> Validate current URL after pressed on Trending noe part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnTrendingNoePart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTrendingNoePart, UrlProvider.TRENDING_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void validatePressOnOurTopPicksPart() {

        log.info("-> Validate current URL before press on Our top Picks part");
        String urlBeforePressOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnOurTopPicksPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Our top picks part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.ourTopPicks);
        homePage.pressOnOurTopPicks();

        log.info("-> Validate current URL after pressed on Our top picks part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnOurTopPicksPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnOurTopPicksPart, UrlProvider.OUR_TOP_PICKS_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void validatePressOnNewReleasesPart() {

        log.info("-> Validate current URL before press on New Releases part");
        String urlBeforePressOnNewReleasesPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnNewReleasesPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on New releases part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.newReleasesPart);
        homePage.pressOnNewReleasesPart();

        log.info("-> Validate current URL after pressed on New Releases part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnNewReleasesPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnNewReleasesPart, UrlProvider.NEW_RELEASES_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void validatePressOnMostReadPart() {

        log.info("-> Validate current URL before press on Most read part");
        String urlBeforePressOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnMostReadPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Most Read part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.mostReadPart);
        homePage.pressOnMostReadPart();

        log.info("-> Validate current URL after pressed on Most Read part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnMostReadPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnMostReadPart, UrlProvider.MOST_READ_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void validatePressOnTopFictionPart() {

        log.info("-> Validate current URL before press on Top fiction part");
        String urlBeforePressOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopFictionPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Top Fiction part");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(homePage.topFictionPart);
        homePage.pressOnTopFictionPart();

        log.info("-> Validate current URL after pressed on Top fiction part");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnTopFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopFictionPart, UrlProvider.TOP_FICTION_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void validatePressOnTopNonFictionPart() {

        log.info("-> Validate current URL before press on Top non fiction part");
        String urlBeforePressOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTopNonFictionPart, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Top non Fiction part");
        waitHelper.waitForSeconds(4);
        waitHelper.waitForElementToBeClickable(homePage.topNonFictionPart);
        homePage.pressOnTopNonFictionPart();

        log.info("-> Validate current URL after pressed on Top non fiction part");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnTopNonFictionPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTopNonFictionPart,
                UrlProvider.TOP_NON_FICTION_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
