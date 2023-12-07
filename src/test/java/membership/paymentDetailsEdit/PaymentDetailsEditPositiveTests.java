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

    MembershipPage membershipPage;

    PaymentDetailsPage paymentDetailsPage;

    PaymentMethodePage paymentMethodePage;

    PaymentDetailsEditPage paymentDetailsEditPage;

    @BeforeMethod
    public void goMembershipPage() {
        goToURL(UrlsProvider.MEMBERSHIP_PAGE_URL);
        membershipPage = new MembershipPage(driver);
        paymentDetailsPage = membershipPage.getPaymentDetails();
        paymentDetailsEditPage = new PaymentDetailsEditPage(driver);
        paymentMethodePage = new PaymentMethodePage(driver);

        log.info("Assert membership page is opened");
        assertThat(membershipPage.isPageOpened())
                .withFailMessage("Membership page is not opened")
                .isTrue();
    }

    @Test(priority = 1)
    public void verifyPaymentDetailsEditPageIsOpened() {
        log.info("Assert payment details page is opened");
        assertThat(paymentDetailsPage.isPageOpened()).isTrue();

        goPaymentDetailsEditPage();
    }

    @Test(priority = 2)
    public void changeCartNumber() {
        log.info("Assert payment details page is opened");
        assertThat(paymentDetailsPage.isPageOpened()).isTrue();

        String currentCartNumber = paymentDetailsPage.cardNumber.getText();

        if (currentCartNumber.endsWith("1111")) {
            goPaymentDetailsEditPage();

            writeHelper.changeValidSecondCardNumber(paymentDetailsEditPage.inputCardNumber, paymentDetailsEditPage.inputExpiration, paymentDetailsEditPage.inputCvv);

            log.info("Click on save button");
            paymentDetailsEditPage.clickSaveButton();

            log.info("Assert payment details page is opened");
            assertThat(paymentDetailsPage.isPageOpened()).isTrue();

            log.info("Assert cart number is ended: {}", "4444");
            assertThat(paymentDetailsPage.cardNumber.getText()).endsWith("4444");
        } else if (currentCartNumber.endsWith("4444")) {
            goPaymentDetailsEditPage();

            log.info("Chang cart number");
            writeHelper.changeValidFirstCardNumber(paymentDetailsEditPage.inputCardNumber, paymentDetailsEditPage.inputExpiration, paymentDetailsEditPage.inputCvv);

            log.info("Click on save button");
            paymentDetailsEditPage.clickSaveButton();

            log.info("Assert payment details page is opened");
            assertThat(paymentDetailsPage.isPageOpened()).isTrue();

            log.info("Assert cart number is ended: {}", "1111");
            assertThat(paymentDetailsPage.cardNumber.getText()).endsWith("1111");
        }

    }

    private void goPaymentDetailsEditPage() {

        log.info("Click change payment method button");
        paymentDetailsPage.clickChangePaymentMethodButton();

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

        waitHelper.waitForSeconds(3);
    }
}
