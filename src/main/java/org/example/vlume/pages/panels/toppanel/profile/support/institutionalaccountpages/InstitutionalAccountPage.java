package org.example.vlume.pages.panels.toppanel.profile.support.institutionalaccountpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InstitutionalAccountPage extends InstitutionalAccountPageDiv {

    @FindBy()
    public WebElement institutionalAccount;

    @FindBy(css = "a[href='https://vlume.com/w/docs/link-account/']")
    public WebElement linkYourAccount;

    @FindBy(css = "a[href='https://vlume.com/w/docs/partnering-libraries/']")
    public WebElement partneringLibraries;

    @FindBy()
    public WebElement explorerMore;


    protected InstitutionalAccountPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnInstitutionalAccount() {
        institutionalAccount.click();
    }

    public void pressOnLinkYourAccountLink() {
        linkYourAccount.click();
    }

    public void pressOnPartneringLibrariesLink() {
        partneringLibraries.click();
    }

    public void pressOnExplorerMorebutton() {
        explorerMore.click();
    }

    public boolean institutionalAccountPageIsLoaded() {
        return super.pageIsLoaded(this.institutionalAccount, this.linkYourAccount,
                this.partneringLibraries, this.explorerMore);
    }
}
