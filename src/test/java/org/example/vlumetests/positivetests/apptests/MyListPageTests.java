package org.example.vlumetests.positivetests.apptests;

import com.google.errorprone.annotations.MustBeClosed;
import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.GiftPage;
import org.example.pages.app.MyListPage;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class MyListPageTests extends BaseTest {
    MyListPage myListPage;
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
        log.info("Open My List Page");
        driver.get(UrlProvider.GIFT_PAGE_UAR.getUrl());
        myListPage = new MyListPage(driver);
        softAssert = new SoftAssert();

        log.info("My List Page is Loaded Successfully");
        boolean pageIsLoaded = myListPage.myListPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

}
