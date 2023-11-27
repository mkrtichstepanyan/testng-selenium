package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLeftPage extends BasePage {
    @FindBy(xpath = "//div//p[@id = 'homeButton']")
    public WebElement home;

    @FindBy(xpath = "//div//p[@id = 'searchButton']")
    public WebElement search;

    @FindBy(xpath = "//div//p[@id = 'audiobooksButton']")
    public WebElement audiobooks;

    @FindBy(xpath = "//div//p[@id = 'ebooksButton']")
    public WebElement ebooks;

    @FindBy(xpath = "//div//p[@id = 'authorsButton']")
    public WebElement authors;

    @FindBy(xpath = "//div//p[@id = 'myListButton']")
    public WebElement myList;

    @FindBy(xpath = "//div//p[@id = 'giftButton']")
    public WebElement gift;

    @FindBy(xpath = "//div[@class = 'footer-container']//img")
    public WebElement icon;

    @FindBy(xpath = "//div//a[@href = 'https://vlume.com/terms/']")
    public WebElement termOfService;

    @FindBy(xpath = "//div//a[@href = 'https://vlume.com/privacy/']")
    public WebElement privacyPolicy;

    public HomeLeftPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(home, search, audiobooks, ebooks, authors, myList, gift, icon, termOfService, privacyPolicy);
    }
}
