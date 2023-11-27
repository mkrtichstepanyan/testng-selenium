package org.example.vlumetests.positivetests.panels.footer;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.footer.LegalSection;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class LegalSectionTests extends BaseTest {

    LegalSection legalSection;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        legalSection = new LegalSection(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnPrivacyPolicyLink() {

        log.info("Verify current URL before pressing on privacy policy link");
        String urlBeforePressOnPrivacyPolicyLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnPrivacyPolicyLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on privacy policy link");
        waitHelper.waitUntilElementWillBeVisible(legalSection.privacyPolicy);
        legalSection.pressOnPrivacyPolicyLink();

        log.info("Verify current URL after pressing on Privacy policy link");
        String urlAfterPressedOnPrivacyPolicyLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnPrivacyPolicyLink, UrlProvider.PRIVACY_POLICY_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnTermsOfServiceLink() {
        log.info("Verify current URL before pressing on Terms Of Service link");
        String urlBeforePressOnTermsOfServiceLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnTermsOfServiceLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press On Terms of service");
        waitHelper.waitUntilElementWillBeVisible(legalSection.termsOfService);
        legalSection.pressOnTermsOfServiceLink();

        log.info("Verify current URL after pressing on Terms of Service link");
        String urlAfterPressedOnTermsOfServiceLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnTermsOfServiceLink, UrlProvider.TERMS_OF_SERVICE_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

}
