package vlume.positivetests.footer.getourfreeapps;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.footer.getourfreeapps.AppPart;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class AppPartTests extends BaseTest {

    AppPart app;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open sign in page from top panel");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        app = new AppPart(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnAppStoreLogo() {

        log.info("-> Validate current URL before press on App Store logo");
        String urlBeforePressOnAppStoreLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAppStoreLogo, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on App Store logo");
        waitHelper.waitForElementToBeClickable(app.appStore);
        app.pressOnAppStoreLogo();

        log.info("-> Validate current URL after pressed on App Store logo");
        String urlAfterPressedOnAppStoreLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAppStoreLogo, UrlProvider.APP_STORE_LOGO_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnGooglePlayLogo() {

        log.info("-> Validate current URL before press on Google Play logo");
        String urlBeforePressOnGooglePlayLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnGooglePlayLogo, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Google Play logo");
        waitHelper.waitForElementToBeClickable(app.googlePlay);
        app.pressOnGooglePlayLogo();

        log.info("-> validate current URL after pressed on Google Play logo");
        String urlAfterPressedOnGooglePlyLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnGooglePlyLogo, UrlProvider.GOOGLE_PLAY_LOGO_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
