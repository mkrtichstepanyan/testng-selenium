package org.example.vlume.pages.panels.toppanel.profile.support.aboutvlumepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutVlumePage extends AboutVlumePageDiv {

    @FindBy(xpath = "//div[@id='cat-id-23']//div[@class='docs-cat-title']//a[@href='https://vlume.com/w/category/about-vlume/'][1]")
    public WebElement aboutVlumeLink;

    @FindBy(css = "a[href='https://vlume.com/w/docs/support/']")
    public WebElement supportLink;

    @FindBy(xpath = "//a[contains(@href, 'about-vlume')][@class='docs-cat-link-btn']")
    public WebElement exploreMoreButton;

    public AboutVlumePage(WebDriver driver) {
        super(driver);
    }

    public void pressOnAboutVlumeLink() {
        aboutVlumeLink.click();
    }

    public void pressOnSupportLink() {
        supportLink.click();
    }

    public void pressOnExploreMoreButton() {
        exploreMoreButton.click();
    }

    public boolean aboutVlumePageIsLoaded() {
        return super.pageIsLoaded(this.supportLink, this.exploreMoreButton);
    }

}
