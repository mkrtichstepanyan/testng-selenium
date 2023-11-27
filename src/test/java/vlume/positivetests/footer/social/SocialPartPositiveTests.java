package vlume.positivetests.footer.social;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.footer.social.Social;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SocialPartPositiveTests extends BaseTest {

    Social social;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        social = new Social(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnFacebookLink() {

        log.info("-> Validate current URL Sign in page before press on Facebook link");
        String urlBeforePressOnFacebookLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnFacebookLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Facebook link");
        waitHelper.waitForElementToBeClickable(social.facebook);
        social.pressOnFacebookLink();

        log.info("-> Validate current URL Facebook after pressed on Facebook link");
        String urlAfterPressedOnFacebookLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnFacebookLink, UrlProvider.FACEBOOK_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnTwitterLink() {

        log.info("-> Validate current URL Sign in page before press on Twitter link");
        String urlBeforePressOnTwitterLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTwitterLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Twitter link");
        waitHelper.waitForElementToBeClickable(social.twitter);
        social.pressOnTwitterLink();

        log.info("-> Validate current URL Twitter after pressed on Twitter link");
        String urlAfterPressedOnTwitterLink = driver.getCurrentUrl();
        waitHelper.waitForSeconds(5);
        softAssert.assertTrue(urlAfterPressedOnTwitterLink.contains("twitter.com"));

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
