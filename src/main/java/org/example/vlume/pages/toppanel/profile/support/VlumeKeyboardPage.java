package org.example.vlume.pages.toppanel.profile.support;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VlumeKeyboardPage extends BasePage {

    @FindBy(id = "userProfile")
    public WebElement userProfile;

    @FindBy(id="supportPage")
    public WebElement supportPart;

    @FindBy()
    public WebElement vlumeKeyboard;

    @FindBy(css = "a[href='https://vlume.com/w/docs/vlume-keyboard/']")
    public WebElement about;

    @FindBy()
    public WebElement exploreMore;

    protected VlumeKeyboardPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnUserProfileIcon(){
        userProfile.click();
    }

    public void pressOnSupportPart(){
        supportPart.click();
    }

    public void pressOnVlumeKeyboard(){
        vlumeKeyboard.click();
    }

    public void pressOnAboutLink(){
        about.click();
    }

    public void pressOnExploreMore(){
        exploreMore.click();
    }

    public boolean vlumeKeyboardPageIsLoaded(){
        return super.pageIsLoaded(this.userProfile, this.supportPart,
                this.vlumeKeyboard, this.about, this.exploreMore);
    }
}
