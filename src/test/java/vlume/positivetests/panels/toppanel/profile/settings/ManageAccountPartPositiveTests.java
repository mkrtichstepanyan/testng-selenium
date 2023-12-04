package vlume.positivetests.panels.toppanel.profile.settings;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserMenu;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.pages.panels.toppanel.profile.settings.manageaccountparts.ManageAccountPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class ManageAccountPartPositiveTests extends BaseTest {

    SignInPage signInPage;

    UserMenu userMenu;
    UserProfileIcon userProfileIcon;
    HomePage homePage;
    ManageAccountPart manageAccountPart;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();
        Assert.assertTrue(signInPage.signInPageIsLoaded(), "Sign in page is not loaded");

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
        manageAccountPart = new ManageAccountPart(driver);
        Assert.assertTrue(userMenu.userMenuIsLoaded(), "User menu part is not loaded");

        log.info("-> Press on Setting part");
        waitHelper.waitUntilElementWillBeVisible(userMenu.settingPart);
        userMenu.pressOnSettingPart();
    }

    @Test
    public void validatePressOnDeleteAccount() {
        softAssert = new SoftAssert();

        log.info("-> Press on Delete account link");
        waitHelper.waitUntilElementWillBeVisible(manageAccountPart.deleteAccount);
        manageAccountPart.pressOnDeleteAccountLink();

        log.info("-> Press on <Cancel> button from message window");
        waitHelper.waitUntilElementWillBeVisible(manageAccountPart.cancelButton);
        manageAccountPart.pressOnCancelButton();
    }

}
