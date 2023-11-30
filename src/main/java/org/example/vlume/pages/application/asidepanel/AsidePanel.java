package org.example.vlume.pages.application.asidepanel;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AsidePanel extends BasePage {

    @FindBy(id = "homeButton")
    public WebElement homeIcon;
    @FindBy(id = "audiobooksButton")
    public WebElement audiobooksIcon;
    @FindBy(id = "authorsButton")
    public WebElement authorsIcon;
    @FindBy(id = "ebooksButton")
    public WebElement ebooksIcon;
    @FindBy(id = "giftButton")
    public WebElement giftIcon;
    @FindBy(id = "myListButton")
    public WebElement myListIcon;
    @FindBy(id = "searchButton")
    public WebElement searchIcon;

    public AsidePanel(WebDriver driver) {
        super(driver);
    }
    public void pressOnHomeIconFromAsidePanel() {
        this.homeIcon.click();
    }
    public void pressOnAudiobooksIconFromAsidePanel() {
        this.audiobooksIcon.click();
    }

    public void pressOnAuthorsIconFromAsidePanel() {
        this.authorsIcon.click();
    }
    public void pressOnEbooksIconFromAsidePanel() {
        this.ebooksIcon.click();
    }
    public void pressOnMyListIconFromAsidePanel() {
        this.myListIcon.click();
    }
    public void pressOnGiftIcon() {
        this.giftIcon.click();
    }
    public void pressOnSearchIconFromAsidePanel() {
        this.searchIcon.click();
    }
    public boolean asideIsLoaded() {
        return super.pageIsLoaded(this.audiobooksIcon, this.searchIcon,
                this.homeIcon, this.authorsIcon, this.ebooksIcon, this.myListIcon,
                this.giftIcon);
    }
}
