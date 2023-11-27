package org.example.vlumetests.positivetests.panels.footer;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.footer.AboutSection;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class AboutSectionTests extends BaseTest {
    AboutSection aboutSection;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Home page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        aboutSection = new AboutSection(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnSupportLink() {

        log.info("Verify current URL page before pressing on Support link");
        String urlBeforePressOnSupportLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSupportLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Support link");
        waitHelper.waitUntilElementWillBeVisible(aboutSection.support);
        aboutSection.pressOnSupportLink();

        log.info("Verify current URL after pressing on Support link");
        String urlAfterPressedOnSupportLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSupportLink, UrlProvider.SUPPORT_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnAccountsAndSubscriptionsLink() {
        log.info("Verify current URL before pressing on Accounts and subscriptions link");
        String urlBeforePressOnAccountsAndSubscriptionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAccountsAndSubscriptionsLink,
                UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on accounts and subscriptions link");
        waitHelper.waitUntilElementWillBeVisible(aboutSection.accountsAndSubscriptions);
        aboutSection.pressOnAccountsAndSubscriptionsLink();

        log.info("Verify current URL after pressing on Accounts and subscriptions link");
        String urlAfterPressedOnAccountsAndSubscriptionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAccountsAndSubscriptionsLink,
                UrlProvider.ACCOUNTS_SUBSCRIPTIONS_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnVlumeForInstitutionsLink() {
        log.info("Verify current URL before pressing on Vlume for institutions link");
        String urlBeforePressOnVlumeForInstitutionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnVlumeForInstitutionsLink,
                UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Vlume for institutions link");
        waitHelper.waitUntilElementWillBeVisible(aboutSection.vlumeForInstitutions);
        aboutSection.pressOnVlumeForInstitutionsLink();

        log.info("Verify current URL after pressing on Vlume for institutions link");
        String urlAfterPressedOnVlumeForInstitutionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnVlumeForInstitutionsLink,
                UrlProvider.VLUME_FOR_INSTITUTIONS_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnVlomeKeyboardLink() {
        log.info("Verify current URL before pressing on Vlume keyboard link");
        String urlBeforePressOnVlumeKeyboardLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnVlumeKeyboardLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Press on Vlume keyboard link");
        waitHelper.waitUntilElementWillBeVisible(aboutSection.vlumeKeyboard);
        aboutSection.pressOnVlomeKeyboardLink();

        log.info("Verify current URL after pressing on Vlume keyboard link");
        String urlAfterPressedOnVlumeKeyboardLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnVlumeKeyboardLink, UrlProvider.VLUME_KEYBOARD_PAGE_URL.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnGiftLink() {
        log.info("Press on gift link");
        waitHelper.waitUntilElementWillBeVisible(aboutSection.gift);
        aboutSection.pressOnGiftLink();

        log.info("Verify current URL before pressing on gift link");
        String urlBeforePressOnGiftLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnGiftLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Verify current URL after pressing on Gift link");
        String urlAfterPressedOnGiftLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnGiftLink, UrlProvider.GIFT_PAGE_UAR.getUrl());

        log.info("Test passed successfully");
        softAssert.assertAll();
    }
}
