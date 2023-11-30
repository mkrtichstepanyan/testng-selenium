package vlume.positivetests.application.asidepanel.mylist;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.mylist.MyListPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class MyListPagePositiveTests extends BaseTest {

    SignInPage signInPage;

    MyListPage myListPage;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Write email information");
        signInPage.enterEmail("@gmail.com");

        log.info("-> Write password information");
        signInPage.enterPassword("0000");

        log.info("-> Press on <Sign in> button");
        signInPage.pressSignInButton();
        waitHelper.waitForSeconds(3);
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
    }

    @BeforeMethod
    public void goToMyListPage() {

        log.info("-> Open My list page");
        driver.get(UrlAsidePanelProvider.MY_LIST_PAGE_URL.getUrl());
        myListPage = new MyListPage(driver);
        Assert.assertTrue(myListPage.myListPageIsLoaded(), "My list page is not loaded");
    }

    @Test
    public void validatePressOnPlusButton() {
        softAssert = new SoftAssert();

        log.info("-> Press on <Plus> button");
        waitHelper.waitForElementToBeClickable(myListPage.plusIcon);
        myListPage.pressOnPlusIcon();

        log.info("-> Validate current URL after pressed on <Plus> button");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnPlusButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnPlusButton, UrlAsidePanelProvider.NEW_LIST_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
