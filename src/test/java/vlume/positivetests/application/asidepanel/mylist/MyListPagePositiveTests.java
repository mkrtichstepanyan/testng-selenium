package vlume.positivetests.application.asidepanel.mylist;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.mylist.MyListPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.UrlProvider;
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
        signInPage.enterEmail("samsungansuryan@gmail.com");
        signInPage.enterPassword("8663a375315");
        signInPage.pressSignInButton();
        waitHelper.waitForSeconds(3);
    }

    @BeforeMethod
    public void goToHomePage() {

        log.info("-> Open Home page");
        driver.get(UrlProvider.HOME_PAGE_URL.getUrl());
        myListPage = new MyListPage(driver);
        boolean pageIsLoaded = myListPage.myListPageIsLoaded();
        softAssert = new SoftAssert();
        softAssert.assertTrue(pageIsLoaded);
    }

    @Test
    public void validatePressOnMyList() {

        log.info("-> Validate current URL before press on My list icon");
        String urlBeforePressOnMyListIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnMyListIcon, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on My list icon from aside panel");
        waitHelper.waitForElementToBeClickable(myListPage.myListIcon);
        myListPage.pressOnMyListIconFromAsidePanel();

        log.info("-> Validate current URL after pressed on My list icon");
        waitHelper.waitForSeconds(3);
        String urlAfterPressedOnMyListIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnMyListIcon, UrlProvider.MY_LIST_PAGE_URL.getUrl());

        log.info("-> Press on <Plus> button");
        waitHelper.waitForElementToBeClickable(myListPage.plusIcon);
        myListPage.pressOnPlusIcon();

        log.info("-> Validate current URL after pressed on <Plus> button");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnPlusButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnPlusButton, UrlProvider.NEW_LIST_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
