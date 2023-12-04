package org.example.vlume.pages.panels.toppanel.profile.support.accountandsubscriptionpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountAndSubscriptionPage extends AccountAndSubscriptionPageDiv {

    @FindBy()
    public WebElement accountsAndSubscriptions;

    @FindBy(css = "a[href='https://vlume.com/w/docs/password-recovery/']")
    public WebElement passwordRecovery;

    @FindBy(css = "a[href='https://vlume.com/w/docs/signing-up/']")
    public WebElement signingUp;

    @FindBy(css = "a[href='https://vlume.com/w/docs/cancel-your-membership/']")
    public WebElement cancelYourMembership;

    @FindBy(css = "a[href='https://vlume.com/w/docs/delete-account/']")
    public WebElement deleteYourVlumeAccount;

    @FindBy()
    public WebElement exploreMore;

    protected AccountAndSubscriptionPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnAccountsAndSubscriptions() {
        accountsAndSubscriptions.click();
    }

    public void pressOnPasswordRecoveryLink() {
        passwordRecovery.click();
    }

    public void pressOnSigningUpLink() {
        signingUp.click();
    }

    public void pressOnCancelYourMembershipLink() {
        cancelYourMembership.click();
    }

    public void pressOnDeleteYourVlumeAccountLink() {
        deleteYourVlumeAccount.click();
    }

    public void pressOnExploreMoreButton() {
        exploreMore.click();
    }

    public boolean accountAndSubscriptionPageIsLoaded() {
        return super.pageIsLoaded(this.accountsAndSubscriptions, this.passwordRecovery,
                this.signingUp, this.exploreMore, this.cancelYourMembership,
                this.deleteYourVlumeAccount);
    }
}
