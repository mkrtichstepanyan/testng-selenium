package org.example.vlume.pages.application.asidepanel.home;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id="SeeMore0")
    public WebElement recentlyAddedPart;

    @FindBy(id="SeeMore2")
    public WebElement freeThisMonthPart;

    @FindBy(id="SeeMore3")
    public WebElement trendingNowPart;

    @FindBy(id="SeeMore4")
    public WebElement ourTopPicks;

    @FindBy(id="SeeMore5")
    public WebElement newReleasesPart;

    @FindBy(id="SeeMore6")
    public WebElement mostReadPart;

    @FindBy(id="SeeMore7")
    public WebElement topFictionPart;

    @FindBy(id="SeeMore8")
    public WebElement topNonFictionPart;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void pressOnRecentlyAddedPart(){
        recentlyAddedPart.click();
    }

    public void pressOnFreeThisMonthPart(){
        freeThisMonthPart.click();
    }

    public void pressOnTrendingNowPart(){
        trendingNowPart.click();
    }

    public void pressOnOurTopPicks(){
        ourTopPicks.click();
    }

    public void pressOnNewReleasesPart(){
        newReleasesPart.click();
    }

    public void pressOnMostReadPart(){
        mostReadPart.click();
    }

    public void pressOnTopFictionPart(){
        topFictionPart.click();
    }

    public void pressOnTopNonFictionPart(){
        topNonFictionPart.click();
    }

    public boolean homePageIsLoaded() {
        return super.pageIsLoaded(this.freeThisMonthPart, this.mostReadPart, this.newReleasesPart,
                this.ourTopPicks, this.topNonFictionPart, this.recentlyAddedPart,
                this.trendingNowPart, this.topFictionPart);
    }
}
