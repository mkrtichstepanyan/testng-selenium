package org.example.pages.panels;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends BasePage {

    @FindBy(xpath = "//div[@class='footer-section'][1]/h5")
    public WebElement pages;
    @FindBy(xpath = "//a[@href='/']")
    public WebElement home;

    @FindBy(xpath = "//a[@href='/audiobooks']")
    public WebElement audiobooks;

    @FindBy(xpath = "/a[@href='/ebooks']")
    public WebElement ebooks;

    @FindBy(xpath = "//a[@href='/authors']")
    public WebElement authors;

    @FindBy(xpath = "//a[@href='/stack/STK_SITE_RECENT']")
    public WebElement recentlyAdded;

    @FindBy(xpath = "//a[@href='/stack/STK_SITE_TRENDING']")
    public WebElement trending;
    @FindBy(xpath = "//a[@href='/search']")
    public WebElement categories;

    @FindBy(xpath = "//div[@class='footer-section'][2]/h5")
    public WebElement about;

    @FindBy(xpath = "//div[@class='footer-section'][2]/a[1]")
    public WebElement support;

    @FindBy(xpath = "//div[@class='footer-section'][2]/a[2]")
    public WebElement accountsSubscriptions;

    @FindBy(xpath = "//div[@class='footer-section'][2]/a[3]")
    public WebElement vlumeForInstitutions;

    @FindBy(xpath = "//div[@class='footer-section'][2]/a[4]")
    public WebElement vlumeKeyboard;

    @FindBy(xpath = "//a[@href='/gift']")
    public WebElement gift;

    @FindBy(xpath = "//div[@class='footer-section'][3]/h5")
    public WebElement legal;

    @FindBy(xpath = "//div[@class='footer-section'][3]/a[1]")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//div[@class='footer-section'][3]/a[2]")
    public WebElement termsOfService;

    @FindBy(xpath = "//div[@class='footer-section'][4]/h5")
    public WebElement social;

    @FindBy(xpath = "//div[@class='footer-section'][4]/a[1]")
    public WebElement facebook;

    @FindBy(xpath = "//div[@class='footer-section'][4]/a[2]")
    public WebElement twitter;

    @FindBy(xpath = "//div[@class='footer-app']/h5")
    public WebElement getOurFreeApps;

    @FindBy(xpath = "//div[@class='footer-app']//a[@id='appleLink']")
    public WebElement appStore;


    @FindBy(xpath = "//div[@class='footer-app']//a[@id='androidLink']")
    public WebElement googlePlay;


    public void clickOnHome() {
        home.click();
    }

    public void clickOnAudiobooks() {
        audiobooks.click();
    }

    public void clickOnEbooks() {
        ebooks.click();
    }

    public void clickAuthors() {
        authors.click();
    }

    public void clickOnRecentlyAdded() {
        recentlyAdded.click();
    }

    public void clickOnTrending() {
        trending.click();
    }

    public void clickOnCategories() {
        categories.click();
    }

    public void clickOnSupport() {
        support.click();
    }

    public void clickOnAccountsSubscriptions() {
        accountsSubscriptions.click();
    }

    public void clickOnVlumeForInstitutions() {
        vlumeForInstitutions.click();
    }

    public void clickOnVlumeKeyboard() {
        vlumeKeyboard.click();
    }

    public void clickOnGift() {
        gift.click();
    }

    public void clickOnPrivacyPolicy() {
        privacyPolicy.click();
    }

    public void clickOnTermsOfService() {
        termsOfService.click();
    }

    public void clickOnFacebook() {
        facebook.click();
    }

    public void clickOnTwitter() {
        twitter.click();
    }

    public void clickOnAppStore() {
        appStore.click();
    }

    public void clickOnGooglePlay() {
        googlePlay.click();
    }

    public Footer(WebDriver driver) {
        super(driver);
    }


}
