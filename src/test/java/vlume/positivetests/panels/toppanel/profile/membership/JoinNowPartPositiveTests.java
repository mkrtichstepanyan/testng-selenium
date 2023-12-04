package vlume.positivetests.panels.toppanel.profile.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserMenu;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.pages.panels.toppanel.profile.membership.joinnowparts.JoinNowPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class JoinNowPartPositiveTests extends BaseTest {

    SignInPage signInPage;
    UserMenu userMenu;
    UserProfileIcon userProfileIcon;
    HomePage homePage;
    JoinNowPart joinNowPart;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();
        waitHelper.waitForSeconds(3);

        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        userMenu = new UserMenu(driver);
        userProfileIcon = new UserProfileIcon(driver);
        joinNowPart = new JoinNowPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @Test(priority = 0)
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitUntilElementWillBeVisible(userProfileIcon.userProfile);
        userProfileIcon.pressOnUserProfileIcon();
        Assert.assertTrue(userMenu.userMenuIsLoaded(), "User menu part is not loaded");

        log.info("-> Press on Membership part");
        waitHelper.waitUntilElementWillBeVisible(userMenu.membershipPart);
        userMenu.pressOnMembershipPart();
    }

    @Test(priority = 1)
    public void validatePressOnStartFreeTrialButton() {

        log.info("-> Press on <Start your free trial> button ");
        waitHelper.waitForElementToBeClickable(joinNowPart.startFreeTrial);
        joinNowPart.pressOnStartFreeTrialButton();
        Assert.assertTrue(joinNowPart.joinNowPartIsLoaded(), "Join now part is not loaded");
    }

    @Test(dependsOnMethods = "validatePressOnStartFreeTrialButton")
    public void validateGetMessageBoxText() {

        log.info("-> Get text of message box");
        waitHelper.waitUntilElementWillBeVisible(joinNowPart.messageBox);
        Assert.assertEquals(joinNowPart.getMessageBoxText(), "Please add a payment method");
    }
}
