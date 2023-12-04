package org.example.vlumetests.positivetests.panels.footer;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.footer.SocialSection;
import org.example.providers.urlproviders.footer.UrlSocialMediaProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SocialSectionTests extends BaseTest {
    SocialSection socialSection;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        socialSection = new SocialSection(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnFacebookLink() {

        log.info("Validate current URL before pressing on Facebook link");
        String urlBeforePressOnFacebookLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnFacebookLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Facebook link");
        waitHelper.waitForElementToBeClickable(socialSection.facebook);
        socialSection.pressOnFacebookLink();

        log.info("Validate current URL after pressing on Facebook link");
        String urlAfterPressedOnFacebookLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnFacebookLink, UrlSocialMediaProvider.FACEBOOK_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnTwitterLink() {
        log.info("Validate current URL before pressing on Twitter link");
        String urlBeforePressOnTwitterLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTwitterLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Twitter link");
        waitHelper.waitForElementToBeClickable(socialSection.twitter);
        socialSection.pressOnTwitterLink();

        log.info("Validate current URL after pressing on Twitter link");
        String urlAfterPressedOnTwitterLink = driver.getCurrentUrl();
        System.out.println(urlAfterPressedOnTwitterLink);
        softAssert.assertTrue(urlAfterPressedOnTwitterLink.contains("twitter.com"));

        log.info("Test passed successfully");
        softAssert.assertAll();
    }
}
