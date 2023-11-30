package org.example.vlume.pages.toppanel.profile.support;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutVlumePage extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(id="supportPage")
    public WebElement supportPart;

    @FindBy()
    public WebElement aboutVlume;

    @FindBy(css = "a[href='https://vlume.com/w/docs/support/']")
    public WebElement supportLink;

    @FindBy()
    public WebElement exploreMore;

    protected AboutVlumePage(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSupportPart(){
        supportPart.click();
    }

    public void pressOnAboutVlume(){
        aboutVlume.click();
    }

    public void pressOnSupportLink(){
        supportLink.click();
    }

    public void pressOnExploreMoreButton(){
        exploreMore.click();
    }

    public boolean aboutVlumePageIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.aboutVlume,
                this.supportPart, this.supportLink, this.exploreMore);
    }

}
