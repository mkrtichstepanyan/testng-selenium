package org.example.pages.app;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbooksPage extends BasePage{
    @FindBy(id = "stackContainer0")
    public WebElement recentlyAddedPart;
    @FindBy(id = "stackContainer1")
    public WebElement trendingNowPart;
    @FindBy(id = "stackContainer2")
    public WebElement ourTopPicksPart;
    @FindBy(id = "stackContainer3")
    public WebElement mostReadPart;
    @FindBy(id = "stackContainer4")
    public WebElement topFictionPart;
    @FindBy(id = "stackContainer5")
    public WebElement topNonFiction;
    @FindBy(id="SeeMore0")
    public WebElement recentlyAddedSeeMore;
    @FindBy(id="SeeMore1")
    public WebElement trendingNowSeeMore;
    @FindBy(id="SeeMore2")
    public WebElement ourTopPicksSeeMore;
    @FindBy(id="SeeMore3")
    public WebElement mostReadSeeMore;
    @FindBy(id="SeeMore4")
    public WebElement topFictionSeeMore;
    @FindBy(id="SeeMore5")
    public WebElement topNonFictionSeeMore;

    public EbooksPage(WebDriver driver) {
        super(driver);
    }
    public void pressOnRecentlyAddedPart(){
        this.recentlyAddedSeeMore.click();
    }

    public void pressOnTrendingNowPart(){
        this.trendingNowSeeMore.click();
    }

    public void pressOnOurTopPicks(){
        this.ourTopPicksSeeMore.click();
    }

    public void pressOnMostReadPart(){
        this.mostReadSeeMore.click();
    }

    public void pressOnTopFictionPart(){
        this.topFictionSeeMore.click();
    }

    public void pressOnTopNonFictionPart(){
        topNonFiction.click();
    }

    public boolean ebooksPageIsLoaded() {
        return super.pageIsLoaded(this.mostReadPart, this.ourTopPicksPart, this.topFictionPart,
                this.recentlyAddedPart, this.topNonFiction, this.trendingNowPart);
    }
}
