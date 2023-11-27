package org.example.pages.footer;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutSection extends BasePage {
    @FindBy(css = "a[href='https://vlume.com/w/support/']")
    public WebElement support;

    @FindBy(xpath = "//a[@href='https://vlume.com/w/category/accounts-subscriptions/']")
    public WebElement accountsAndSubscriptions;

    @FindBy(css = "a[href='https://vlume.com/w/category/institution-accounts/']")
    public WebElement vlumeForInstitutions;
    @FindBy(css = "a[href='https://chrome.google.com/webstore/detail/vlume-keyboard/ffgbbmfhmcfaphemeigfmcejcgnehjjd']")
    public WebElement vlumeKeyboard;
    @FindBy(xpath = "//a[@href='/gift']")
    public WebElement gift;

    public AboutSection(WebDriver driver) {
        super(driver);
    }

    public void pressOnSupportLink() {
        this.support.click();
    }

    public void pressOnAccountsAndSubscriptionsLink() {
        this.accountsAndSubscriptions.click();
    }

    public void pressOnVlumeForInstitutionsLink() {
        this.vlumeForInstitutions.click();
    }

    public void pressOnVlomeKeyboardLink() {
        this.vlumeKeyboard.click();
    }

    public void pressOnGiftLink() {
        this.gift.click();
    }
}
