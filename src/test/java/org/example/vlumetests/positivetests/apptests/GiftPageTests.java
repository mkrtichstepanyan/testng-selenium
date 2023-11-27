package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.EbooksPage;
import org.example.pages.app.GiftPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.UrlProvider;
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

    @Test
    public void validatePageLoading() {
        log.info("Open Gift Page");
        driver.get(UrlProvider.GIFT_PAGE_UAR.getUrl());
        giftPage = new GiftPage(driver);
        softAssert = new SoftAssert();

        waitHelper.waitForSeconds(3);
        log.info("Gift Page is Loaded Successfully");
        boolean pageIsLoaded = giftPage.giftPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }
}
