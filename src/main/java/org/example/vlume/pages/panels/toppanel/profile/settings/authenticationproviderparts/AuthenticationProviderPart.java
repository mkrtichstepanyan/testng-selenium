package org.example.vlume.pages.panels.toppanel.profile.settings.authenticationproviderparts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationProviderPart extends AuthenticationProviderPartDiv {
    @FindBy()
    public WebElement changeEmailAddress;
    @FindBy(css = "div[class='column-item ng-star-inserted']")
    public WebElement changePassword;

    @FindBy(css = "div[class='facebook-button']")
    public WebElement connectFacebookAccount;

    @FindBy(css = "div[class='facebook-button google-button']")
    public WebElement connectGoogleAccount;

    protected AuthenticationProviderPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnChangeEmailAddressLink() {
        changeEmailAddress.click();
    }

    public void pressOnChangePasswordLink() {
        changePassword.click();
    }

    public void pressOnConnectFacebookAccountLink() {
        connectFacebookAccount.click();
    }

    public void pressOnConnectGoogleAccountLink() {
        connectGoogleAccount.click();
    }

    public boolean authenticationProviderPartIsLoaded() {
        return super.pageIsLoaded(this.changeEmailAddress, this.changePassword,
                this.connectGoogleAccount, this.connectFacebookAccount);
    }
}
