package membership.paymentDetailsEdit;

import base.AuthorizedTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.membership.MembershipPage;
import org.example.membership.PaymentDetailsEditPage;
import org.example.membership.PaymentDetailsPage;
import org.example.membership.PaymentMethodePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PaymentDetailsEditPositiveTests extends AuthorizedTest {

    String endCartNumber = "1111";

    MembershipPage membershipPage;
    PaymentDetailsPage paymentDetails;

    PaymentMethodePage paymentMethodePage;

    PaymentDetailsEditPage paymentDetailsEditPage;

    @BeforeMethod
    public void goMembershipPage() {
        goToURL(UrlsProvider.MEMBERSHIP_PAGE_URL);
        membershipPage = new MembershipPage(driver);
        paymentDetails = membershipPage.getPaymentDetails();
        paymentDetailsEditPage = new PaymentDetailsEditPage(driver);
        paymentMethodePage = new PaymentMethodePage(driver);

        log.info("Assert membership page is opened");
        assertThat(membershipPage.isPageOpened())
                .withFailMessage("Membership page is not opened")
                .isTrue();
    }

    @Test
    public void verifyPaymentDetailsEditPageIsOpened() {
        waitHelper.waitForElementToBeVisible(paymentDetails.cardNumber);

        log.info("Click change payment method button");
        paymentDetails.clickChangePaymentMethodButton();

        waitHelper.waitForSeconds(4);
        log.info("Assert payment method page is opened");
        assertThat(paymentMethodePage.isPageOpened())
                .withFailMessage("payment methode page is not opened")
                .isTrue();

        log.info("Click add payment method");
        paymentMethodePage.clickAddPaymentMethod();

        log.info("Assert payment details edit page is opened");
        assertThat(paymentDetailsEditPage.isPageOpened())
                .withFailMessage("payment details edit page is not opened")
                .isTrue();
    }
}
