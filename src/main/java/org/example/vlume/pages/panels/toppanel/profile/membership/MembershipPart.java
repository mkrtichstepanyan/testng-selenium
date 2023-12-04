package org.example.vlume.pages.panels.toppanel.profile.membership;

import org.example.vlume.BasePage;
import org.example.vlume.pages.panels.toppanel.profile.membership.joinnowparts.JoinNowPartDiv;
import org.example.vlume.pages.panels.toppanel.profile.membership.linkyourmembershipparts.LinkYourMembershipPartDiv;
import org.example.vlume.pages.panels.toppanel.profile.membership.paymentmethodsparts.PaymentMethodsPartDiv;
import org.openqa.selenium.WebDriver;

public class MembershipPart extends BasePage {

    public JoinNowPartDiv joinNowPartDiv;
    public LinkYourMembershipPartDiv linkYourMembershipPartDiv;
    public PaymentMethodsPartDiv paymentMethodsPartDiv;


    protected MembershipPart(WebDriver driver) {
        super(driver);
    }


}
