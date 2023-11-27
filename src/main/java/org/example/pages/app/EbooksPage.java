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

    public EbooksPage(WebDriver driver) {
        super(driver);
    }

    public boolean ebooksPageIsLoaded() {
        return super.pageIsLoaded(this.mostReadPart, this.ourTopPicksPart, this.topFictionPart,
                this.recentlyAddedPart, this.topNonFiction, this.trendingNowPart);
    }
}
