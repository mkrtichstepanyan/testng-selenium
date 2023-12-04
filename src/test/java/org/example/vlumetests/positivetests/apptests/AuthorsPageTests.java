package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.AuthorsPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class AuthorsPageTests extends BaseTest {
    AuthorsPage authorsPage;
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
        log.info("Open Authors Page");
        driver.get(UrlAsidePanelProvider.AUTHORS_PAGE_URL.getUrl());
        authorsPage = new AuthorsPage(driver);
        softAssert = new SoftAssert();

        log.info("Authors Page is Loaded Successfully");
        boolean pageIsLoaded = authorsPage.authorsPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }
}
