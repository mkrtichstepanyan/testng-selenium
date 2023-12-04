package vlume.positivetests.panels.toppanel.profile.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserMenu;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.pages.panels.toppanel.profile.membership.linkyourmembershipparts.LinkYourMembershipPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.toppanel.menuuser.membership.UrlMembershipProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class LinkYourMembershipPartPositiveTests extends BaseTest {

    SignInPage signInPage;
    UserMenu userMenu;
    UserProfileIcon userProfileIcon;
    HomePage homePage;
    LinkYourMembershipPart linkYourMembershipPart;

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
        linkYourMembershipPart = new LinkYourMembershipPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitUntilElementWillBeVisible(userProfileIcon.userProfile);
        userProfileIcon.pressOnUserProfileIcon();
        Assert.assertTrue(userMenu.userMenuIsLoaded(), "User menu part is not loaded");

        log.info("-> Press on Membership part");
        waitHelper.waitUntilElementWillBeVisible(userMenu.membershipPart);
        userMenu.pressOnMembershipPart();
        Assert.assertTrue(linkYourMembershipPart.linkYourMembershipPartIsLoaded(),
                "Link your membership part is not loaded");
    }

    @Test
    public void validatePressOnLinkMembershipButton() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on <Link membership> button");
        String urlBeforePressOnLinkMembershipButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnLinkMembershipButton,
                UrlMembershipProvider.MEMBERSHIP_PAGE_URL.getUrl());

        log.info("-> Press on <Link membership> button");
        waitHelper.waitUntilElementWillBeVisible(linkYourMembershipPart.linkMembershipButton);
        linkYourMembershipPart.pressOnLinkMembershipButton();

        log.info("-> Validate current URL after press on <Link membership> button");
        String urlAfterPressedOnLinkMembershipButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnLinkMembershipButton,
                UrlMembershipProvider.LINK_MEMBERSHIP_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
