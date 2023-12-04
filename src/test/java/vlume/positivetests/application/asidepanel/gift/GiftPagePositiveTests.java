package vlume.positivetests.application.asidepanel.gift;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.gift.GiftPage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class GiftPagePositiveTests extends BaseTest {

    GiftPage giftPage;
    SignInPage signInPage;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();

        waitHelper.waitForSeconds(3);
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
    }

    @BeforeMethod
    public void goToGiftPage() {

        log.info("-> Open Gift page");
        driver.get(UrlAsidePanelProvider.GIFT_PAGE_UAR.getUrl());
        giftPage = new GiftPage(driver);
        Assert.assertTrue(giftPage.giftPageIsLoaded(), "Gift page is not loaded");
    }

    @Test
    public void validatePressOnGift() {
        softAssert = new SoftAssert();

        log.info("-> Press on <Choose a Gift> button");
        waitHelper.waitForElementToBeClickable(giftPage.giftPart);
        giftPage.pressOnChooseAGiftButton();

        log.info("-> Validate current URL after pressed on <Choose a Gift> button");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnChooseAGiftButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnChooseAGiftButton,
                UrlAsidePanelProvider.CHOOSE_A_PACKAGE_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

}
