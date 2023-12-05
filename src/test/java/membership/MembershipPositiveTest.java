package membership;

import base.AuthorizedTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.membership.MembershipPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MembershipPositiveTest extends AuthorizedTest {

    MembershipPage membershipPage;

    @BeforeMethod
    public void goMembershipPage() {
        goToURL(UrlsProvider.MEMBERSHIP_PAGE_URL);
        membershipPage = new MembershipPage(driver);

        log.info("Assert membership page is opened");
        assertThat(membershipPage.isPageOpened())
                .withFailMessage("Membership page is not opened")
                .isTrue();
    }

    @Test
    public void verifyCardNumber() {
        waitHelper.waitForElementToBeVisible(membershipPage.cardNumber);

        log.info("Assert cart number is displayed");
        assertThat(membershipPage.cardNumber.isDisplayed())
                .withFailMessage("card number is not displayed")
                .isTrue();

        log.info("Assert cart number is ended with: {}", "1111");
        assertThat(membershipPage.cardNumber.getText()).endsWith("1111");
    }
}
