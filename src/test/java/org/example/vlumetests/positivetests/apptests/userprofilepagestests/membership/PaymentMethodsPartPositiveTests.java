package org.example.vlumetests.positivetests.apptests.userprofilepagestests.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.app.userprofilepages.membership.thirdsection.PaymentDetailForm;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class PaymentMethodsPartPositiveTests extends MembershipPageTestsOrganizer {

    @Test(priority = 0)
    public void validateFunctionalityOfPayPalButton() {
        log.info("Validate Functionality of Paypal Button");
        paymentMethodsFirstState.pressOnPayPalButton();
    }

    @Test(priority = 1)
    public void validatePressOnDebitOrCreditCardButton() {
        log.info("-> Press on <Debit or Card> button");
        paymentMethodsFirstState.pressOnDebitOrCreditCardButton();
        form = new PaymentDetailForm(driver);
        Assert.assertTrue(form.paymentDetailFormIsLoaded(),
                "Payment details form is not loaded");
    }

    @Test(dependsOnMethods = "validatePressOnDebitOrCreditCardButton")
    public void validateFilInCardInformation() {
        form.enterData();
        form.pressOnCancelButton();
    }
}
