package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.SearchPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SearchPageTests extends BaseTest {

    SearchPage searchPage;
    SignInPage signInPage;

    @BeforeClass
    public void signIn() {
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("ani.kovalenko97@gmail.com");
        signInPage.enterPassword("NewPassword");
        signInPage.clickOnSignInButton();
    }

    @Test
    public void validatePageLoading() {
        log.info("Open Search Page");
        driver.get(UrlAsidePanelProvider.SEARCH_PAGE_URL.getUrl());
        searchPage = new SearchPage(driver);
        softAssert = new SoftAssert();

        log.info("Search Page is Loaded Successfully");
        boolean pageIsLoaded = searchPage.searchPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }
}
