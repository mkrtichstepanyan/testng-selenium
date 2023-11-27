package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.example.BaseTest;
import org.example.pages.app.AudiobooksPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class AudiobooksPageTests extends BaseTest {
    AudiobooksPage audiobooksPage;
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
        log.info("Open Audiobooks Page");
        driver.get(UrlProvider.AUDIOBOOKS_PAGE_URL.getUrl());
        audiobooksPage = new AudiobooksPage(driver);
        softAssert = new SoftAssert();


        log.info("Audiobooks Page is Loaded Successfully");
        boolean pageIsLoaded = audiobooksPage.audiobooksPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }
}
