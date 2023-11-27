package vlume.positivetests.application.asidepanel.gift;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.gift.GiftPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.UrlProvider;
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
        signInPage.enterEmail("samsungansuryan@gmail.com");
        signInPage.enterPassword("8663a375315");
        signInPage.pressSignInButton();
        waitHelper.waitForSeconds(3);
    }

    @BeforeMethod
    public void goToHomePage() {

        log.info("-> Open Home page");
        driver.get(UrlProvider.HOME_PAGE_URL.getUrl());
        giftPage = new GiftPage(driver);
        boolean pageIsLoaded = giftPage.giftPageIsLoaded();
        softAssert = new SoftAssert();
        softAssert.assertTrue(pageIsLoaded);
    }

    @Test
    public void validatePressOnGift() {

        log.info("-> Validate current URL before press on Gift icon");
        String urlBeforePressOnGiftIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnGiftIcon, UrlProvider.WELCOME_PAGE_URL.getUrl());

        log.info("-> Press on Gift icon from aside panel");
        waitHelper.waitForSeconds(2);
        waitHelper.waitUntilElementWillBeVisible(giftPage.giftIcon);
        giftPage.pressOnGiftIcon();

        log.info("-> Validate current URL after pressed on Gift icon");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnGiftIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnGiftIcon, UrlProvider.GIFT_PAGE_UAR.getUrl());

        log.info("-> Press on <Choose a Gift> button");
        waitHelper.waitForElementToBeClickable(giftPage.giftPart);
        giftPage.pressOnChooseAGiftButton();

        log.info("-> Validate current URL after pressed on <Choose a Gift> button");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnChooseAGiftButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnChooseAGiftButton,
                UrlProvider.CHOOSE_A_PACKAGE_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

}
