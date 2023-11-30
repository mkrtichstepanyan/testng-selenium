package vlume.positivetests.toppanel.profile.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.pages.toppanel.profile.membership.JoinNowPart;
import org.example.vlume.pages.toppanel.profile.membership.MembershipPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class JoinNowPartPositiveTests extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;
    MembershipPart membershipPart;
    JoinNowPart joinNowPart;

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
        joinNowPart = new JoinNowPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitUntilElementWillBeVisible(membershipPart.userProfile);
        membershipPart.pressOnUserProfileIcon();
        Assert.assertTrue(membershipPart.membershipPartIsLoaded(), "Membership part is not loaded");
    }

    @Test
    public void validatePressOnStartFreeTrialButton(){

        log.info("-> Press on Membership part");
        waitHelper.waitUntilElementWillBeVisible(membershipPart.membershipPage);
        membershipPart.pressOnMembershipPage();

        waitHelper.waitForSeconds(4);
        log.info("-> Press on <Start your free trial> button ");
        waitHelper.waitUntilElementWillBeVisible(joinNowPart.startFreeTrial);
        joinNowPart.pressOnStartFreeTrialButton();
        Assert.assertTrue(joinNowPart.joinNowPartIsLoaded(), "Join now part is not loaded");
    }
}
