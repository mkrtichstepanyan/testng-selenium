package org.example.vlume.pages.toppanel.profile.support;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadingWithVlumePage extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(id="supportPage")
    public WebElement supportPart;

    @FindBy()
    public WebElement readingWithVlume;

    @FindBy(css = "a[href='https://vlume.com/w/docs/install-vlume/']")
    public WebElement installingVlumeApp;

    @FindBy(css = "a[href='https://vlume.com/w/docs/browser-access/']")
    public WebElement webBrowserAccess;

    @FindBy()
    public WebElement exploreMore;

    protected ReadingWithVlumePage(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSupportPart(){
        supportPart.click();
    }

    public void pressOnReadingWithVlume(){
        readingWithVlume.click();
    }

    public void pressOnInstallingVlumeAppLink(){
        installingVlumeApp.click();
    }

    public void pressOnWebBrowserAccessLink(){
        webBrowserAccess.click();
    }

    public void pressOnExploreMoreButton(){
        exploreMore.click();
    }

    public boolean readingWithVlumePageIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.supportPart,
                this.readingWithVlume, this.installingVlumeApp, this.webBrowserAccess,
                this.exploreMore);
    }
}
