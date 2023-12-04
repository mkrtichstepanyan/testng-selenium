package org.example.vlumetests.positivetests.apptests.userprofilepagestests.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.providers.urlproviders.toppanel.UrlMembershipProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class LinkYourMembershipPartPositiveTests extends MembershipPageTestsOrganizer {

    @Test
    public void validatePressOnLinkMembershipButton() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on <Link membership> button");
        String urlBeforePressOnLinkMembershipButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnLinkMembershipButton,
                UrlMembershipProvider.MEMBERSHIP_PAGE_URL.getUrl());

        log.info("-> Press on <Link membership> button");
        waitHelper.waitUntilElementWillBeVisible(linkYourMembershipFirstState.linkMembershipButton);
        linkYourMembershipFirstState.pressOnLinkMembershipButton();

        log.info("-> Validate current URL after press on <Link membership> button");
        String urlAfterPressedOnLinkMembershipButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnLinkMembershipButton,
                UrlMembershipProvider.LINK_MEMBERSHIP_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
