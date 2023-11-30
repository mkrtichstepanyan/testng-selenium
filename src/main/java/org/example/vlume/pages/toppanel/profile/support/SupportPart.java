package org.example.vlume.pages.toppanel.profile.support;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupportPart extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(css = "div[class='mat-menu-content ng-tns-c76-2']")
    public WebElement menuUserProfile;

    @FindBy(id="supportPage")
    public WebElement supportPage;

    public SupportPart(WebDriver driver) {
        super(driver);
    }


    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSupportPart(){
        supportPage.click();
    }

    public boolean supportPartIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.menuUserProfile,
                this.supportPage);
    }
}
