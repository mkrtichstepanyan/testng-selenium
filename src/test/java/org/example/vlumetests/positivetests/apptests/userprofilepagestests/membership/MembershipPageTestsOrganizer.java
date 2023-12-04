package org.example.vlumetests.positivetests.apptests.userprofilepagestests.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.app.HomePage;
import org.example.pages.app.userprofilepages.membership.MembershipPage;
import org.example.pages.app.userprofilepages.membership.firstsection.JoinNowFirstState;
import org.example.pages.app.userprofilepages.membership.secondsection.LinkYourMembershipFirstState;
import org.example.pages.app.userprofilepages.membership.thirdsection.PaymentDetailForm;
import org.example.pages.app.userprofilepages.membership.thirdsection.PaymentMethodsFirstState;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.toppanel.UrlMembershipProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

@Slf4j
public class MembershipPageTestsOrganizer extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;
    MembershipPage membershipPage;
    JoinNowFirstState joinNowFirstState;
    LinkYourMembershipFirstState linkYourMembershipFirstState;
    PaymentMethodsFirstState paymentMethodsFirstState;
    PaymentDetailForm form;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.signInWithValidData();
        homePage = new HomePage(driver);
        homePage.homePageIsLoaded();

        log.info("-> Open Membership page");
        driver.get(UrlMembershipProvider.MEMBERSHIP_PAGE_URL.getUrl());

        membershipPage = new MembershipPage(driver,
                JoinNowFirstState.class,
                LinkYourMembershipFirstState.class,
                PaymentMethodsFirstState.class);

        joinNowFirstState = (JoinNowFirstState) membershipPage.joinNowDiv;
        linkYourMembershipFirstState = (LinkYourMembershipFirstState) membershipPage.linkMembershipDiv;
        paymentMethodsFirstState = (PaymentMethodsFirstState) membershipPage.paymentDiv;

        Assert.assertTrue(membershipPage.membershipPageIsLoaded());
    }
}
