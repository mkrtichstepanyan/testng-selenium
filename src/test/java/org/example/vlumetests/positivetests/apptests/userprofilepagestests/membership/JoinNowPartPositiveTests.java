package org.example.vlumetests.positivetests.apptests.userprofilepagestests.membership;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class JoinNowPartPositiveTests extends MembershipPageTestsOrganizer {

    @Test
    public void validateJoinNowFirstStateWithoutPayment() {
        System.out.println(joinNowFirstState.getClass());
        joinNowFirstState.pressOnStartFreeTrialButton();
        Assert.assertEquals(joinNowFirstState.getMessageBoxText(), "Please add a payment method");
    }
}
