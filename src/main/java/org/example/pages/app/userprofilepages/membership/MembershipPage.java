package org.example.pages.app.userprofilepages.membership;

import org.example.pages.BasePage;
import org.example.pages.app.userprofilepages.membership.firstsection.JoinNowDiv;
import org.example.pages.app.userprofilepages.membership.firstsection.JoinNowFirstState;
import org.example.pages.app.userprofilepages.membership.secondsection.LinkMembershipDiv;
import org.example.pages.app.userprofilepages.membership.secondsection.LinkYourMembershipFirstState;
import org.example.pages.app.userprofilepages.membership.thirdsection.PaymentDiv;
import org.example.pages.app.userprofilepages.membership.thirdsection.PaymentMethodsFirstState;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MembershipPage {
    public JoinNowDiv joinNowDiv;
    public LinkMembershipDiv linkMembershipDiv;
    public PaymentDiv paymentDiv;

    public MembershipPage(WebDriver driver, Class... clazzes) {
        for (Class clazz : clazzes) {
            if (clazz.isAssignableFrom(JoinNowFirstState.class)) {
                joinNowDiv = new JoinNowFirstState(driver);
            } else if (clazz.isAssignableFrom(LinkYourMembershipFirstState.class)) {
                linkMembershipDiv = new LinkYourMembershipFirstState(driver);
            } else if (clazz.isAssignableFrom(PaymentMethodsFirstState.class)) {
                paymentDiv = new PaymentMethodsFirstState(driver);
            } else throw new RuntimeException("Specify correct class!");
        }
    }

    public boolean membershipPageIsLoaded() {
        final List<Boolean> sectionsLoadBooleanValues = new ArrayList<>();
        sectionIsLoaded(joinNowDiv, sectionsLoadBooleanValues);
        sectionIsLoaded(linkMembershipDiv, sectionsLoadBooleanValues);
        sectionIsLoaded(paymentDiv, sectionsLoadBooleanValues);
        return sectionsLoadBooleanValues
                .stream()
                .allMatch(sectionIsLoaded -> sectionIsLoaded);
    }

    private void sectionIsLoaded(BasePage sectionObject, List<Boolean> sectionsLoadBooleanValues) {
        Arrays.stream(sectionObject.getClass().getDeclaredMethods())
                .filter(method -> method.getName().contains("IsLoaded"))
                .forEach(method -> {
                    try {
                        Boolean returnValue = (Boolean) method.invoke(sectionObject, new Object[0]);
                        sectionsLoadBooleanValues.add(returnValue);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to invoke 'IsLoaded' method");
                    }
                });
    }
}
