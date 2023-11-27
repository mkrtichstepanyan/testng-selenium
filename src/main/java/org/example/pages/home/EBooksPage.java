package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EBooksPage extends BasePage {
    @FindBy(id = "Title0")
    public WebElement recentlyAdded;

    @FindBy(id = "SeeMore0")
    public WebElement seeMoreRecentlyAdded;

    @FindBy(xpath = "//div[@class='ng-tns-c98-3']")
    public WebElement itemsOfRecentlyAdded;

    @FindBy(id = "Title1")
    public WebElement trendingNow;

    @FindBy(id = "SeeMore1")
    public WebElement seeMoreTrendingNow;

    @FindBy(xpath = "//div[@class='ng-tns-c98-4']")
    public WebElement itemsOfTrendingNow;

    @FindBy(id = "Title2")
    public WebElement ourTopPicks;

    @FindBy(id = "SeeMore2")
    public WebElement seeMoreOurTopPicks;

    @FindBy(xpath = "//div[@class='ng-tns-c98-5']")
    public WebElement itemsOfOurTopPicks;

    @FindBy(id = "Title3")
    public WebElement mostRead;

    @FindBy(id = "SeeMore3")
    public WebElement seeMoreMostRead;

    @FindBy(xpath = "//div[@class='ng-tns-c98-7']")
    public WebElement itemsOfMostRead;

    @FindBy(id = "Title4")
    public WebElement topFiction;

    @FindBy(id = "SeeMore4")
    public WebElement seeMoreTopFiction;

    @FindBy(xpath = "//div[@class='ng-tns-c98-6']")
    public WebElement itemsOfTopFiction;

    @FindBy(id = "Title5")
    public WebElement topNoneFiction;

    @FindBy(id = "SeeMore5")
    public WebElement seeMoreTopNoneFiction;

    @FindBy(xpath = "//div[@class='ng-tns-c98-8']")
    public WebElement itemsOfTopNoneFiction;

    public WebElement[] webElements = {
            recentlyAdded, seeMoreRecentlyAdded,
            trendingNow, seeMoreTrendingNow,
            ourTopPicks, seeMoreOurTopPicks,
            mostRead, seeMoreMostRead,
            topFiction, seeMoreTopFiction,
            topNoneFiction, seeMoreTopNoneFiction,
    };

    public EBooksPage(WebDriver driver) {
        super(driver);
    }
}
