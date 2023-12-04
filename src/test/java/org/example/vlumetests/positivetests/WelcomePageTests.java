package org.example.vlumetests.positivetests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.SignInPage;
import org.example.pages.wordpress.WelcomePage;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class WelcomePageTests extends BaseTest {
    WelcomePage welcomePage;
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Welcome Page");
        driver.get(UrlProvider.WELCOME_PAGE_URL.getUrl());
        welcomePage = new WelcomePage(driver);
        signInPage = new SignInPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validateNavigationToSignInPage() {
        log.info("Verify Current Url Before Clicking on 'SignIn' Button");
        String urlBeforeClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforeClick, UrlProvider.WELCOME_PAGE_URL.getUrl());

        log.info("Click on 'Sign In' Button");
        waitHelper.waitUntilElementWillBeVisible(welcomePage.signInButton);
        welcomePage.clickOnSignInButton();

        log.info("Verify Page Is Loaded");
        waitHelper.waitForSeconds(2);
        boolean pageIsLoaded = signInPage.signInPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        log.info("Verify Current Url After Clicking on 'SignIn' Button");
        String urlAfterClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterClick, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        softAssert.assertAll();
    }
}
