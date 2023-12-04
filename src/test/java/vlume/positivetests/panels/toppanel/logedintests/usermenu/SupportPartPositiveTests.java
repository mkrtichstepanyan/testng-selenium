package vlume.positivetests.panels.toppanel.logedintests.usermenu;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserMenu;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.toppanel.menuuser.support.UrlSupportProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SupportPartPositiveTests extends BaseTest {

    SignInPage signInPage;

    UserMenu userMenu;
    UserProfileIcon userProfileIcon;
    HomePage homePage;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();
        waitHelper.waitForSeconds(3);
    }

    @BeforeMethod
    public void goToHomePage() {

        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        userMenu = new UserMenu(driver);
        userProfileIcon = new UserProfileIcon(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    @Test
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitUntilElementWillBeVisible(userProfileIcon.userProfile);
        userProfileIcon.pressOnUserProfileIcon();
        Assert.assertTrue(userMenu.userMenuIsLoaded(), "User menu part is not loaded");
    }

    @Test
    public void validatePressOnSupportPage() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Support page from menu user profile");
        String urlBeforePressOnSupportPage = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSupportPage,
                UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Support part");
        waitHelper.waitUntilElementWillBeVisible(userMenu.supportPart);
        userMenu.pressOnSupportPart();

        log.info("-> Validate current URL after press on Support page");
        String urlAfterPressedOnSupportPage = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSupportPage,
                UrlSupportProvider.SUPPORT_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

}
