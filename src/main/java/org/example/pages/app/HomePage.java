package org.example.pages.app;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "stackContainer0")
    public WebElement recentlyAddedPart;
    @FindBy(id = "stackContainer2")
    public WebElement freeThisMonthPart;
    @FindBy(id = "stackContainer3")
    public WebElement trendingNowPart;
    @FindBy(id = "stackContainer4")
    public WebElement ourTopPicks;
    @FindBy(id = "stackContainer5")
    public WebElement newReleasesPart;
    @FindBy(id = "stackContainer6")
    public WebElement mostReadPart;
    @FindBy(id = "stackContainer7")
    public WebElement topFictionPart;
    @FindBy(id = "stackContainer8")
    public WebElement topNonFictionPart;
    @FindBy(id="SeeMore0")
    public WebElement recentlyAddedSeeMore;
    @FindBy(id="SeeMore2")
    public WebElement freeThisMonthSeeMore;
    @FindBy(id="SeeMore3")
    public WebElement trendingNowSeeMore;
    @FindBy(id="SeeMore4")
    public WebElement ourTopPicksSeeMore;
    @FindBy(id="SeeMore5")
    public WebElement newReleasesSeeMore;
    @FindBy(id="SeeMore6")
    public WebElement mostReadSeeMore;
    @FindBy(id="SeeMore7")
    public WebElement topFictionSeeMore;
    @FindBy(id="SeeMore8")
    public WebElement topNonFictionSeeMore;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void pressOnRecentlyAddedPart(){
        this.recentlyAddedSeeMore.click();
    }
    public void pressOnFreeThisMonthPart(){
        this.freeThisMonthSeeMore.click();
    }
    public void pressOnTrendingNowPart(){
        this.trendingNowSeeMore.click();
    }
    public void pressOnOurTopPicks(){
        this.ourTopPicksSeeMore.click();
    }
    public void pressOnNewReleasesPart(){
        this.newReleasesSeeMore.click();
    }
    public void pressOnMostReadPart(){
        this.mostReadSeeMore.click();
    }
    public void pressOnTopFictionPart(){
        this.topFictionSeeMore.click();
    }
    public void pressOnTopNonFictionPart(){
        this.topNonFictionSeeMore.click();
    }

    public boolean homePageIsLoaded() {
        return super.pageIsLoaded(this.freeThisMonthPart, this.mostReadPart, this.newReleasesPart,
                this.ourTopPicks, this.topNonFictionPart, this.recentlyAddedPart, this.trendingNowPart, this.topFictionPart);
    }
}
