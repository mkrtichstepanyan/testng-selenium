package org.example.vlume.pages.toppanel.profile.support;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountAndSubscriptionPage extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(id="supportPage")
    public WebElement supportPart;

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

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSupportPart(){
        supportPart.click();
    }

    public void pressOnAccountsAndSubscriptions(){
        accountsAndSubscriptions.click();
    }

    public void pressOnPasswordRecoveryLink(){
        passwordRecovery.click();
    }

    public void pressOnSigningUpLink(){
        signingUp.click();
    }

    public void pressOnCancelYourMembershipLink(){
        cancelYourMembership.click();
    }

    public void pressOnDeleteYourVlumeAccountLink(){
        deleteYourVlumeAccount.click();
    }

    public void pressOnExploreMoreButton(){
        exploreMore.click();
    }

    public boolean accountAndSubscriptionPageIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.supportPart,
                this.accountsAndSubscriptions, this.passwordRecovery, this.signingUp,
                this.exploreMore, this.cancelYourMembership, this.deleteYourVlumeAccount);
    }
}
