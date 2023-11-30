package vlume.positivetests.toppanel.profile.signout;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.pages.toppanel.profile.settings.SettingPart;
import org.example.vlume.pages.toppanel.profile.signout.SignOutPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class SignOutPartPositiveTests extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;
    SignOutPart signOutPart;

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
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        signOutPart = new SignOutPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    @Test
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitForElementToBeClickable(signOutPart.userProfile);
        waitHelper.waitForSeconds(3);
        signOutPart.pressOnUserProfileIcon();
        Assert.assertTrue(signOutPart.signOutPartIsLoaded(), "Settings part is not loaded");
    }

    @Test
    public void validatePressOnSignOutPart(){
        log.info("-> Press on Sign out link");
        waitHelper.waitUntilElementWillBeVisible(signOutPart.signOut);
        signOutPart.pressOnSignOutPart();
    }
}
