package org.example.pages.home;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class HomePage extends BasePage {

    @FindBy(id = "Title0")
    public WebElement recentlyAdded;

    @FindBy(id = "SeeMore0")
    public WebElement seeMoreRecentlyAdded;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-6']")
    public WebElement itemsOfRecentlyAdded;

    @FindBy(id = "Title2")
    public WebElement freeThisMonth;

    @FindBy(id = "SeeMore2")
    public WebElement seeMoreFreeThisMonth;

    @FindBy(xpath = "//div[@class='ng-tns-c98-3']/div")
    public WebElement itemsOfFreeThisMonth;

    @FindBy(id = "Title3")
    public WebElement trendingNow;

    @FindBy(id = "SeeMore3")
    public WebElement seeMoreTrendingNow;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-4']")
    public WebElement itemsOfTrendingNow;

    @FindBy(id = "Title4")
    public WebElement ourTopPicks;

    @FindBy(id = "SeeMore4")
    public WebElement seeMoreOurTopPicks;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-5']")
    public WebElement itemsOfOurTopPicks;

    @FindBy(id = "Title5")
    public WebElement newReleases;

    @FindBy(id = "SeeMore5")
    public WebElement seeMoreNewReleases;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-11']")
    public WebElement itemsOfNewReleases;

    @FindBy(id = "Title6")
    public WebElement mostRead;

    @FindBy(id = "SeeMore6")
    public WebElement seeMoreMostRead;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-8']")
    public WebElement itemsOfMostRead;

    @FindBy(id = "Title7")
    public WebElement topFiction;

    @FindBy(id = "SeeMore7")
    public WebElement seeMoreTopFiction;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-7']")
    public WebElement itemsOfTopFiction;

    @FindBy(id = "Title8")
    public WebElement topNoneFiction;

    @FindBy(id = "SeeMore8")
    public WebElement seeMoreTopNoneFiction;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-10']")
    public WebElement itemsOfTopNoneFiction;

    @FindBy(id = "Title9")
    public WebElement antares;

    @FindBy(id = "SeeMore9")
    public WebElement seeMoreAntares;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-9']")
    public WebElement itemsOfAntares;

    @FindBy(id = "Title10")
    public WebElement zangak;

    @FindBy(id = "SeeMore10")
    public WebElement seeMoreZangak;

    @FindBy(xpath = "//div[@class='owl-stage ng-tns-c98-12']")
    public WebElement itemsOfZangak;

    public WebElement[] webElements = {recentlyAdded, seeMoreRecentlyAdded, itemsOfRecentlyAdded,
            freeThisMonth, seeMoreFreeThisMonth, itemsOfFreeThisMonth,
            trendingNow, seeMoreTrendingNow, itemsOfTrendingNow,
            ourTopPicks, seeMoreOurTopPicks, itemsOfOurTopPicks,
            newReleases, seeMoreNewReleases, itemsOfNewReleases,
            mostRead, seeMoreMostRead, itemsOfMostRead,
            topFiction, seeMoreTopFiction, itemsOfOurTopPicks,
            topNoneFiction, seeMoreTopNoneFiction, itemsOfTopNoneFiction,
            antares, seeMoreAntares, itemsOfAntares,
            zangak, seeMoreZangak, itemsOfZangak
    };

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void isPageOpened() {
        log.info("Checking if HomePage is opened");

        waitHelper.waitForElementsToBeVisible(webElements);

        log.info("HomePage is successfully opened");

    }
}
