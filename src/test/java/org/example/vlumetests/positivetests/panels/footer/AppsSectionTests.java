package org.example.vlumetests.positivetests.panels.footer;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.footer.AppsSection;
import org.example.providers.urlproviders.footer.UrlAppProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

@Slf4j
public class AppsSectionTests extends BaseTest {
    AppsSection appsSection;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open sign in page from top panel");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        appsSection = new AppsSection(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnAppStoreLogo() {
        log.info("Validate current URL before pressing on App Store logo");
        String urlBeforePressOnAppStoreLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAppStoreLogo, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on App Store logo");
        waitHelper.waitForElementToBeClickable(appsSection.appStore);
        appsSection.pressOnAppStoreLogo();

        log.info("Validate current URL after pressing on App Store logo");
        String urlAfterPressedOnAppStoreLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAppStoreLogo, UrlAppProvider.APP_STORE_LOGO_URL.getUrl());

        log.info("Test succeeded");
        softAssert.assertAll();
    }


    @Test
    public void validatePressOnGooglePlayLogo() {

        log.info("Validate current URL before pressing on Google Play logo");
        String urlBeforePressOnGooglePlayLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnGooglePlayLogo, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Google Play logo");
        waitHelper.waitForElementToBeClickable(appsSection.googlePlay);
        appsSection.pressOnGooglePlayLogo();

        log.info("validate current URL after pressing on Google Play logo");
        String urlAfterPressedOnGooglePlyLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnGooglePlyLogo, UrlAppProvider.GOOGLE_PLAY_LOGO_URL.getUrl());

        log.info("Test succeeded");
        softAssert.assertAll();
    }
}
