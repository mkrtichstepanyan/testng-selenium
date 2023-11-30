package org.example.vlume.pages.application.asidepanel.ebooks;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbooksPage extends BasePage {

    @FindBy(id = "SeeMore0")
    public WebElement recentlyAddedPart;
    @FindBy(id = "SeeMore1")
    public WebElement trendingNowPart;
    @FindBy(id = "SeeMore2")
    public WebElement ourTopPicksPart;
    @FindBy(id = "SeeMore3")
    public WebElement mostReadPart;
    @FindBy(id = "SeeMore4")
    public WebElement topFictionPart;
    @FindBy(id = "SeeMore5")
    public WebElement topNonFiction;

    public EbooksPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnRecentlyAddedPart() {
        recentlyAddedPart.click();
    }

    public void pressOnTrendingNowPart() {
        trendingNowPart.click();
    }

    public void pressOnOurTopPicks() {
        ourTopPicksPart.click();
    }

    public void pressOnMostReadPart() {
        mostReadPart.click();
    }

    public void pressOnTopFictionPart() {
        topFictionPart.click();
    }

    public void pressOnTopNonFictionPart() {
        topNonFiction.click();
    }

    public boolean ebooksPageIsLoaded() {
        return super.pageIsLoaded(this.mostReadPart, this.ourTopPicksPart, this.topFictionPart,
                this.recentlyAddedPart, this.topNonFiction, this.trendingNowPart);
    }
}
