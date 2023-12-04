package vlume.positivetests.panels.toppanel.profile.support;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserMenu;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.pages.panels.toppanel.profile.support.aboutvlumepages.AboutVlumePage;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.toppanel.menuuser.support.UrlAboutVlumeProvider;
import org.example.vlume.providers.urlproviders.toppanel.menuuser.support.UrlSupportProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class AboutVlumePagePositiveTests extends BaseTest {

    SignInPage signInPage;
    UserMenu userMenu;
    UserProfileIcon userProfileIcon;
    HomePage homePage;
    AboutVlumePage aboutVlumePage;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();
        Assert.assertTrue(signInPage.signInPageIsLoaded(), "Sign in page is not loaded");
        waitHelper.waitForSeconds(3);

        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        userMenu = new UserMenu(driver);
        userProfileIcon = new UserProfileIcon(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitForElementToBeClickable(userProfileIcon.userProfile);
        userProfileIcon.pressOnUserProfileIcon();
        aboutVlumePage = new AboutVlumePage(driver);
        Assert.assertTrue(userMenu.userMenuIsLoaded(), "User menu part is not loaded");

        log.info("-> Press on Support part from menu");
        waitHelper.waitUntilElementWillBeVisible(userMenu.supportPart);
        userMenu.pressOnSupportPart();
//        Assert.assertTrue(aboutVlumePage.aboutVlumePageIsLoaded(),
//                "About Vlume link is not loaded");
    }

    @Test
    public void validatePressOnAboutVlumeLink() {
        softAssert = new SoftAssert();
        waitHelper.waitForSeconds(3);

        log.info("-> Validate current URL before press on About Vlume link");
        String urlBeforePressOnAboutVlumeLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAboutVlumeLink,
                UrlSupportProvider.SUPPORT_PAGE_URL.getUrl());

        waitHelper.waitForSeconds(3);
        log.info("-> Press on About Vlume link");
        waitHelper.waitUntilElementWillBeVisible(aboutVlumePage.aboutVlumeLink);
        aboutVlumePage.pressOnAboutVlumeLink();

        waitHelper.waitForSeconds(2);
        log.info("-> Validate current URL after pressed on About Vlume link");
        String urlAfterPressedOnAboutVlumeLink = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAboutVlumeLink,
                UrlAboutVlumeProvider.ABOUNT_VLUME_LINK_URL.getUrl());
        softAssert.assertAll();
    }

}
