package vlume.positivetests.toppanel.profile.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.pages.toppanel.profile.membership.LinkYourMembershipPart;
import org.example.vlume.pages.toppanel.profile.membership.MembershipPart;
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
    HomePage homePage;
    MembershipPart membershipPart;
    LinkYourMembershipPart linkYourMembershipPart;

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

        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        membershipPart = new MembershipPart(driver);
        linkYourMembershipPart = new LinkYourMembershipPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitUntilElementWillBeVisible(membershipPart.userProfile);
        membershipPart.pressOnUserProfileIcon();
        Assert.assertTrue(membershipPart.membershipPartIsLoaded(), "Membership part is not loaded");

        log.info("-> Press on Membership part");
        waitHelper.waitUntilElementWillBeVisible(membershipPart.membershipPage);
        membershipPart.pressOnMembershipPage();
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
