package vlume.positivetests.footer.legal;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.footer.legal.Legal;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.example.vlume.providers.urlproviders.footer.UrlLegalProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class LegalPartPositiveTest extends BaseTest {

    Legal legal;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        legal = new Legal(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnPrivacyPolicyLink() {

        log.info("-> Verify current URL Sign in page before press on privacy policy link");
        String urlBeforePressOnPrivacyPolicyLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnPrivacyPolicyLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on privacy policy link");
        waitHelper.waitForElementToBeClickable(legal.privacyPolicy);
        legal.pressOnPrivacyPolicyLink();

        log.info("-> Verify current URL Privacy policy page after pressed on Privacy policy link");
        String urlAfterPressedOnPrivacyPolicyLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnPrivacyPolicyLink,
                UrlLegalProvider.PRIVACY_POLICY_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnTermsOfServiceLink() {

        log.info("-> Verify current URL Sign in page before press on Terms Of Service link");
        String urlBeforePressOnTermsOfServiceLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTermsOfServiceLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press On Terms of service");
        waitHelper.waitForElementToBeClickable(legal.termsOfService);
        legal.pressOnTermsOfServiceLink();

        log.info("-> Verify current URL Terms of service page after pressed on Terms of Service link");
        String urlAfterPressedOnTermsOfServiceLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTermsOfServiceLink,
                UrlLegalProvider.TERMS_OF_SERVICE_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

}
