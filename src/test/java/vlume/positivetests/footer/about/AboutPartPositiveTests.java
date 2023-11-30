package vlume.positivetests.footer.about;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.footer.about.About;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.example.vlume.providers.urlproviders.footer.UrlAboutProvider;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class AboutPartPositiveTests extends BaseTest {

    About about;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        about = new About(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnSupportLink() {

        log.info("-> Verify current URL Sign in page before press on Support link");
        String urlBeforePressOnSupportLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSupportLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Support link");
        waitHelper.waitForElementToBeClickable(about.support);
        about.pressOnSupportLink();

        log.info("->  Verify current URL Support page after pressed on Support link");
        String urlAfterPressedOnSupportLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSupportLink, UrlAboutProvider.SUPPORT_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnAccountsAndSubscriptionsLink() {

        log.info("-> Verify current URL Sign in page before press on Accounts and subscriptions link");
        String urlBeforePressOnAccountsAndSubscriptionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAccountsAndSubscriptionsLink,
                UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on accounts and subscriptions link");
        waitHelper.waitForElementToBeClickable(about.accountsAndSubscriptions);
        about.pressOnAccountsAndSubscriptionsLink();

        log.info("-> Verify current URL Accounts and subscriptions page after pressed on " +
                "Accounts and subscriptions link");
        String urlAfterPressedOnAccountsAndSubscriptionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAccountsAndSubscriptionsLink,
                UrlAboutProvider.ACCOUNTS_SUBSCRIPTIONS_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnVlumeForInstitutionsLink() {

        log.info("-> Verify current URL Sign in page before press on Vlume for institutions link");
        String urlBeforePressOnVlumeForInstitutionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnVlumeForInstitutionsLink,
                UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Vlume for institutions link");
        waitHelper.waitForElementToBeClickable(about.vlumeForInstitutions);
        about.pressOnVlumeForInstitutionsLink();

        log.info("-> Verify current URL Vlume for institutions page after pressed on Vlume for institutions link");
        String urlAfterPressedOnVlumeForInstitutionsLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnVlumeForInstitutionsLink,
                UrlAboutProvider.VLUME_FOR_INSTITUTIONS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnVlomeKeyboardLink() {

        log.info("-> Verify current URL Sign in page before press on Vlume keyboard link");
        String urlBeforePressOnVlumeKeyboardLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnVlumeKeyboardLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on Vlume keyboard link");
        waitHelper.waitUntilElementWillBeVisible(about.vlumeKeyboard);
        about.pressOnVlomeKeyboardLink();

        log.info("-> Verify current URL Vlume keyboard page after pressed on Vlume keyboard link");
        String urlAfterPressedOnVlumeKeyboardLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnVlumeKeyboardLink,
                UrlAboutProvider.VLUME_KEYBOARD_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnGiftLink() {

        log.info("-> Press on gift link");
        waitHelper.waitForElementToBeClickable(about.gift);
        about.pressOnGiftLink();

        log.info("-> Verify current URL Sign in page before press on gift link");
        String urlBeforePressOnGiftLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnGiftLink, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Verify current URL Gift page after pressed on Gift link");
        String urlAfterPressedOnGiftLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnGiftLink, UrlAsidePanelProvider.GIFT_PAGE_UAR.getUrl());
        softAssert.assertAll();
    }
}
