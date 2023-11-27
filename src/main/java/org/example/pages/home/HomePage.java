package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final HomeTopPanel homeTopPanel;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][1]")
    public WebElement recentlyAdded;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][2]")
    public WebElement continueReading;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][3]")
    public WebElement freeThisMonth;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][4]")
    public WebElement trendingNow;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][5]")
    public WebElement ourTopPicks;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][6]")
    public WebElement newReleases;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][7]")
    public WebElement mostRead;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][8]")
    public WebElement topFiction;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][9]")
    public WebElement topNonFiction;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][10]")
    public WebElement antares;

    @FindBy(xpath = "//div[@class = 'vlume-container screen-content']//div[@class = 'ng-star-inserted'][11]")
    public WebElement zangak;

    public HomePage(WebDriver driver) {
        super(driver);
        homeTopPanel = new HomeTopPanel(driver);
    }

    public HomeTopPanel getTopPanel() {
        return homeTopPanel;
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(recentlyAdded, continueReading, freeThisMonth, trendingNow, ourTopPicks, newReleases, mostRead, topFiction, topNonFiction, antares, zangak);
    }
}
