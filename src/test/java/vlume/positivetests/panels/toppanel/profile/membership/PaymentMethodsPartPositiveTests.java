package vlume.positivetests.panels.toppanel.profile.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserMenu;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.pages.panels.toppanel.profile.membership.linkyourmembershipparts.LinkYourMembershipPart;
import org.example.vlume.pages.panels.toppanel.profile.membership.paymentmethodsparts.PaymentMethodsPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class PaymentMethodsPartPositiveTests extends BaseTest {
    SignInPage signInPage;

    UserMenu userMenu;
    UserProfileIcon userProfileIcon;
    HomePage homePage;
    LinkYourMembershipPart linkYourMembershipPart;
    PaymentMethodsPart paymentMethodsPart;


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
        paymentMethodsPart = new PaymentMethodsPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");

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


    @Test(priority = 0)
    public void validatePressOnChangePaymentMethodButton() {
        waitHelper.waitForSeconds(3);
        log.info("-> Press on <Change payment method> button");
        paymentMethodsPart.pressOnChangePaymentMethodButton();
        waitHelper.waitForSeconds(3);
    }

    @Test(priority = 1)
    public void validatePressOnPayPalButton() {

        log.info("-> Press on <PayPal> button");
        waitHelper.waitForSeconds(4);
        paymentMethodsPart.pressOnPayPalButton();
    }

    @Test(priority = 2)
    public void validatePressOnDebitOrCreditCardButton() {

        log.info("-> Press on <Debit or Card> button");
        waitHelper.waitUntilElementWillBeVisible(paymentMethodsPart.debitOrCreditCard);
        paymentMethodsPart.pressOnDebitOrCreditCardButton();
        waitHelper.waitForSeconds(7);
        Assert.assertTrue(paymentMethodsPart.paymentMethodsPartIsLoaded(),
                "Payment method part is not loaded");
    }

    @Test(dependsOnMethods = "validatePressOnDebitOrCreditCardButton")
    public void validateFilInCardInformation() {

        waitHelper.waitForSeconds(5);
        log.info("-> Press on Card number field");
        waitHelper.waitForElementToBeClickable(paymentMethodsPart.cardNumber);
        paymentMethodsPart.pressOnCardNumberField();
        paymentMethodsPart.paymentMethodsPartIsLoaded();

        log.info("-> Write Card number information");
        paymentMethodsPart.enterCardNumber("4111111111111111");

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
