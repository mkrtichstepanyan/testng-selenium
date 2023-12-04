package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.GiftPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.providers.urlproviders.home.UrlHomeProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class GiftPageTests extends BaseTest {
    GiftPage giftPage;
    SignInPage signInPage;

    @BeforeMethod
    public void signIn() {
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("ani.kovalenko97@gmail.com");
        signInPage.enterPassword("NewPassword");
        signInPage.clickOnSignInButton();
    }

    @Test(priority = 0)
    public void validatePageLoading() {
        log.info("Open Gift Page");
        driver.get(UrlAsidePanelProvider.GIFT_PAGE_UAR.getUrl());
        giftPage = new GiftPage(driver);
        softAssert = new SoftAssert();

        waitHelper.waitForSeconds(3);
        log.info("Gift Page is Loaded Successfully");
        boolean pageIsLoaded = giftPage.giftPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test(priority = 1)
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
