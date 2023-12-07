package org.example.pages.membership;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class MembershipPage extends BasePage {

    private final PaymentDetailsPage paymentDetailsPage;
    private final PaymentMethodePage paymentMethodePage;
    private final PaymentDetailsEditPage paymentDetailsEditPage;

    @FindBy(xpath = "//div//h2[@id = 'yourMembership']")
    public WebElement membershipTitle;

    @FindBy(xpath = "//div[@class = 'payment-card']")
    public WebElement paymentDetailsCart;

    public MembershipPage(WebDriver driver) {
        super(driver);
        paymentDetailsPage = new PaymentDetailsPage(driver);
        paymentMethodePage = new PaymentMethodePage(driver);
        paymentDetailsEditPage = new PaymentDetailsEditPage(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(membershipTitle, paymentDetailsCart);
    }

    public PaymentDetailsPage getPaymentDetails() {
        return paymentDetailsPage;
    }

    public PaymentMethodePage getPaymentMethodePage() {
        return paymentMethodePage;
    }

    public PaymentDetailsEditPage getPaymentDetailsEditPage() {
        return paymentDetailsEditPage;
    }
}
