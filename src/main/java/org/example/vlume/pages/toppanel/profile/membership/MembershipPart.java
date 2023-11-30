package org.example.vlume.pages.toppanel.profile.membership;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembershipPart extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(css = "div[class='mat-menu-content ng-tns-c76-2']")
    public WebElement menuUserProfile;

    @FindBy(id = "membershipPage")
    public WebElement membershipPage;

    public MembershipPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnMembershipPage(){
        membershipPage.click();
    }

    public boolean membershipPartIsLoaded(){
        return super.pageIsLoaded(this.menuUserProfile,
                this.membershipPage);
    }
}
