package vlume.positivetests.toppanel.profile.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.pages.toppanel.profile.membership.LinkYourMembershipPart;
import org.example.vlume.pages.toppanel.profile.membership.MembershipPart;
import org.example.vlume.pages.toppanel.profile.membership.PaymentMethodsPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class PaymentMethodsPartPositiveTests extends BaseTest {
    SignInPage signInPage;
    HomePage homePage;
    MembershipPart membershipPart;
    LinkYourMembershipPart linkYourMembershipPart;
    PaymentMethodsPart paymentMethodsPart;


    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Write email");
        signInPage.enterEmail("@gmail.com");

        log.info("-> Write password");
        signInPage.enterPassword("0000");

        log.info("-> Press on <Sign in> button");
        signInPage.pressSignInButton();
        waitHelper.waitForSeconds(3);

        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        membershipPart = new MembershipPart(driver);
        linkYourMembershipPart = new LinkYourMembershipPart(driver);
        paymentMethodsPart = new PaymentMethodsPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }


    @BeforeMethod
    public void validatePressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitUntilElementWillBeVisible(membershipPart.userProfile);
        membershipPart.pressOnUserProfileIcon();
        Assert.assertTrue(membershipPart.membershipPartIsLoaded(), "Membership part is not loaded");

        log.info("-> Press on Membership part");
        waitHelper.waitUntilElementWillBeVisible(membershipPart.membershipPage);
        membershipPart.pressOnMembershipPage();
        Assert.assertTrue(linkYourMembershipPart.linkYourMembershipPartIsLoaded(),
                "Link your membership part is not loaded");

        log.info("-> Press on <Debit or Card> button");
        waitHelper.waitUntilElementWillBeVisible(paymentMethodsPart.debitOrCreditCard);
        paymentMethodsPart.pressOnDebitOrCreditCardButton();
        waitHelper.waitForSeconds(5);
        Assert.assertTrue(paymentMethodsPart.paymentMethodsPartIsLoaded(),
                "Payment method part is not loaded");
    }

//    @Test(priority = 1)
//    public void validatePressOnDebitOrCreditCardButton() {

//        log.info("-> Press on <Debit or Card> button");
//        waitHelper.waitUntilElementWillBeVisible(paymentMethodsPart.debitOrCreditCard);
//        paymentMethodsPart.pressOnDebitOrCreditCardButton();
//        waitHelper.waitForSeconds(5);
//        Assert.assertTrue(paymentMethodsPart.paymentMethodsPartIsLoaded(),
//                "Payment method part is not loaded");
//    }

    @Test
    public void validateFilInCardInformation() {
        waitHelper.waitForSeconds(5);
        log.info("-> Press on Card number field");
        waitHelper.waitUntilElementWillBeVisible(paymentMethodsPart.cardNumber);
        paymentMethodsPart.pressOnCardNumberField();

        log.info("-> Write Card number information");
        paymentMethodsPart.enterCardNumber("4444444444444444");

        log.info("-> Press on Expiration Date field");
        waitHelper.waitUntilElementWillBeVisible(paymentMethodsPart.expirationData);
        paymentMethodsPart.pressOnExpirationDataField();

        log.info("-> Write Expiration Data information");
        paymentMethodsPart.enterExpirationData("06/26");

        log.info("-> Press on CVV field");
        waitHelper.waitUntilElementWillBeVisible(paymentMethodsPart.cvv);
        paymentMethodsPart.pressOnCvvField();

        log.info("-> Write CVV information");
        paymentMethodsPart.enterCvv("356");

        log.info("-> Press on <Save> button");
        waitHelper.waitUntilElementWillBeVisible(paymentMethodsPart.saveButton);
        paymentMethodsPart.pressOnSaveButton();
    }
}
