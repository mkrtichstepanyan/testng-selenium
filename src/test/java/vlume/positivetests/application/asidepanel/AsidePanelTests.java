package vlume.positivetests.application.asidepanel;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.AsidePanel;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class AsidePanelTests extends BaseTest {

    SignInPage signInPage;
    AsidePanel aside;
    @BeforeClass
    public void signIn() {
        aside = new AsidePanel(driver);
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        log.info("-> Write email information");
        signInPage.enterEmail("@gmail.com");

        log.info("-> Write password information");
        signInPage.enterPassword("0000");

        log.info("-> Press on <Sign in> button");
        signInPage.pressSignInButton();
    }
   @Test
    public void validatePressOnAudiobooksIcon() {
        softAssert = new SoftAssert();
        log.info("-> Press on Audiobooks icon from aside panel");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(aside.audiobooksIcon);
        aside.pressOnAudiobooksIconFromAsidePanel();

        log.info("-> Validate current URL after pressed on Audiobooks icon");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnAudiobooksIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAudiobooksIcon,
                UrlAsidePanelProvider.AUDIOBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
    @Test
    public void validatePressOnAuthorsIcon() {
        softAssert = new SoftAssert();
        log.info("-> Press on Authors icon from aside panel");
        waitHelper.waitForElementToBeClickable(aside.authorsIcon);
        aside.pressOnAuthorsIconFromAsidePanel();
        log.info("-> Validate current URL after pressed on Authors icon");
        String urlAfterPressedOnAuthorsIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAuthorsIcon,
               UrlAsidePanelProvider.AUTHORS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test()
    public void validatePressOnEbooksIcon() {
        softAssert = new SoftAssert();
        log.info("-> Press on Ebooks icon from aside panel");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(aside.ebooksIcon);
        aside.pressOnEbooksIconFromAsidePanel();
        log.info("-> Validate current URL after pressed on Ebooks icon");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnEbooksIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnEbooksIcon,
               UrlAsidePanelProvider.EBOOKS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
    @Test()
    public void validatePressOnGiftButton() {
        softAssert = new SoftAssert();

        log.info("-> Press on Gift icon from aside panel");
        waitHelper.waitForSeconds(2);
        waitHelper.waitUntilElementWillBeVisible(aside.giftIcon);
        aside.pressOnGiftIcon();
        log.info("-> Validate current URL after pressed on Gift icon");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnGiftIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnGiftIcon,
                UrlAsidePanelProvider.GIFT_PAGE_UAR.getUrl());
        softAssert.assertAll();
    }
    @Test()
    public void validatePressOnHomeButton() {
        softAssert = new SoftAssert();

        log.info("-> Press on Home icon from aside panel");
        waitHelper.waitForSeconds(3);
        waitHelper.waitUntilElementWillBeVisible(aside.homeIcon);
        aside.pressOnHomeIconFromAsidePanel();
        log.info("-> Validate current URL after pressed on Home icon");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnGiftIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnGiftIcon,
                UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
    @Test
    public void validatePressOnMyListIcon() {
        softAssert = new SoftAssert();
        log.info("-> Press on My list icon from aside panel");
        waitHelper.waitForElementToBeClickable(aside.myListIcon);
        aside.pressOnMyListIconFromAsidePanel();

        String urlAfterPressedOnMyListIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnMyListIcon,
                UrlAsidePanelProvider.MY_LIST_PAGE_URL.getUrl());

        softAssert.assertAll();
    }
    @Test
    public void validatePressOnSearchIcon() {
        softAssert = new SoftAssert();
        log.info("-> Press on Search icon from aside panel");
        waitHelper.waitForElementToBeClickable(aside.searchIcon);
        aside.pressOnSearchIconFromAsidePanel();
        log.info("-> Validate current URL after pressed on Search icon");

        String urlAfterPressedOnSearchIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSearchIcon,
                UrlAsidePanelProvider.SEARCH_PAGE_URL.getUrl());

        softAssert.assertAll();
    }
}
