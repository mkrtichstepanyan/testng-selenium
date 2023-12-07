package membership.paymentDetails;

import base.AuthorizedTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.membership.MembershipPage;
import org.example.pages.membership.PaymentDetailsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PaymentDetailsPositiveTest extends AuthorizedTest {

    String endCartNumber = "1111";

    MembershipPage membershipPage;
    PaymentDetailsPage paymentDetails;

    @BeforeMethod
    public void goMembershipPage() {
        goToURL(UrlsProvider.MEMBERSHIP_PAGE_URL);
        membershipPage = new MembershipPage(driver);
        paymentDetails = membershipPage.getPaymentDetails();

        log.info("Assert membership page is opened");
        assertThat(membershipPage.isPageOpened())
                .withFailMessage("Membership page is not opened")
                .isTrue();
    }

    @Test
    public void verifyCardNumber() {
        waitHelper.waitForElementToBeVisible(paymentDetails.cardNumber);

        log.info("Assert payment details page is opened");
        assertThat(paymentDetails.isPageOpened())
                .withFailMessage("payment details page is not opened")
                .isTrue();

        log.info("Assert cart number is ended with: {}", endCartNumber);
        assertThat(paymentDetails.cardNumber.getText()).endsWith(endCartNumber);
    }

}
