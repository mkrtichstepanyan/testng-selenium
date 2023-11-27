package org.example.vlumetests.positivetests.apptests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.EbooksPage;
import org.example.pages.app.HomePage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class HomePageTests extends BaseTest {

    HomePage homePage;
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
        log.info("Open Home Page");
        driver.get(UrlProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();

        log.info("Home Page is Loaded Successfully");
        boolean pageIsLoaded = homePage.homePageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }
}
