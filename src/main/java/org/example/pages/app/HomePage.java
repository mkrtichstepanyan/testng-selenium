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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean homePageIsLoaded() {
        return super.pageIsLoaded(this.freeThisMonthPart, this.mostReadPart, this.newReleasesPart,
                this.ourTopPicks, this.topNonFictionPart, this.recentlyAddedPart, this.trendingNowPart, this.topFictionPart);
    }
}
