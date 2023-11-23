package org.example.pages.panel;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage {

    @FindBy(xpath = "//div[@class='footer-section'][1]/h5")
    public WebElement pages;


    @FindBy(xpath = "//div[@class='footer-section'][1]/a[@href='/']n")
    public WebElement home;


    @FindBy(xpath = "//div[@class='footer-section'][1]/a[@href='/audiobooks']")
    public WebElement audiobooks;


    @FindBy(xpath = "//div[@class='footer-section'][1]/a[@href='/ebooks']")
    public WebElement ebooks;


    @FindBy(xpath = "//div[@class='footer-section'][1]/a[@href='/authors']")
    public WebElement authors;


    @FindBy(xpath = "//div[@class='footer-section'][1]/a[@href='/stack/STK_SITE_RECENT']")
    public WebElement recentlyAdded;


    @FindBy(xpath = "//div[@class='footer-section'][1]/a[@href='/stack/STK_SITE_TRENDING']")
    public WebElement trending;


    @FindBy(xpath = "//div[@class='footer-section'][1]/a[@href='/search']")
    public WebElement categories;


    @FindBy(xpath = "//div[@class='footer-section'][2]/h5")
    public WebElement about;


    @FindBy(xpath = "//div[@class='footer-section'][2]/a[@href='https://vlume.com/w/support/']")
    public WebElement support;


    @FindBy(xpath = "//div[@class='footer-section'][2]/a[@href='https://vlume.com/w/category/accounts-subscriptions/']")
    public WebElement accountAndSubscription;


    @FindBy(xpath = "//div[@class='footer-section'][2]/a[@href='https://vlume.com/w/category/institution-accounts/']")
    public WebElement vlumeForInstitutions;


    @FindBy(xpath = "//div[@class='footer-section'][2]/a[@href='https://chrome.google.com/webstore/detail/vlume-keyboard/ffgbbmfhmcfaphemeigfmcejcgnehjjd']")
    public WebElement vlumeKeyboard;


    @FindBy(xpath = "//div[@class='footer-section'][2]/a[@href='/gift']")
    public WebElement gift;


    @FindBy(xpath = "//div[@class='footer-section'][3]/h5")
    public WebElement legal;


    @FindBy(xpath = "div[@class='footer-section'][3]/a[@href='https://vlume.com/privacy']")
    public WebElement privacyPolicy;


    @FindBy(xpath = "//div[@class='footer-section'][3]/a[@href='https://vlume.com/terms']")
    public WebElement termsOfService;


    @FindBy(xpath = "//div[@class='footer-section'][4]/h5")
    public WebElement social;


    @FindBy(xpath = "//div[@class='footer-section'][4]/a[@href='https://www.facebook.com/vlumeapp']")
    public WebElement facebook;


    @FindBy(xpath = "//div[@class='footer-section'][4]/a[@href='https://twitter.com/vlumeapp']")
    public WebElement twitter;


    @FindBy(xpath = "//div[@class='footer-app']/h5")
    public WebElement getOurFreeApps;


    @FindBy(xpath = "//div[@class='footer-app']/a[@href='https://apps.apple.com/us/app/vlume/id1325346984']")
    public WebElement appStore;


    @FindBy(xpath = "https://play.google.com/store/apps/details?id=com.vlume.app&hl=en_US")
    public WebElement googlePlay;


    public FooterPage(WebDriver driver) {
        super(driver);
    }
}
