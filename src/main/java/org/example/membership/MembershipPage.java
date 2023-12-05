package org.example.membership;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPage extends BasePage {
    @FindBy(xpath = "//div//h2[@id = 'yourMembership']")
    public WebElement membershipTitle;

    @FindBy(xpath = "//div[@class = 'payment-card']")
    public WebElement paymentDetailsCart;

    @FindBy(xpath = "//b[@id= 'cardNumber']")
    public WebElement cardNumber;

    public MembershipPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(membershipTitle, paymentDetailsCart);
    }
}
