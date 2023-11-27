package org.example.vlume.pages.application.asidepanel.audiobooks;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AudiobooksPage extends BasePage {

    @FindBy(id="audiobooksButton")
    public WebElement audiobooksIcon;

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

    public AudiobooksPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnAudiobooksIconFromAsidePane(){
        audiobooksIcon.click();
    }

    public boolean audiobooksPageIsLoaded() {
        return super.pageIsLoaded(this.mostReadPart, this.ourTopPicksPart, this.topFictionPart,
                this.recentlyAddedPart, this.topNonFiction, this.trendingNowPart, this.audiobooksIcon);
    }
}
