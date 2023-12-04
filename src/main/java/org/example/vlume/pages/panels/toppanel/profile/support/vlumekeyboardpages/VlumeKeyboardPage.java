package org.example.vlume.pages.panels.toppanel.profile.support.vlumekeyboardpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VlumeKeyboardPage extends VlumeKeyboardPageDiv {

    @FindBy()
    public WebElement vlumeKeyboard;

    @FindBy(css = "a[href='https://vlume.com/w/docs/vlume-keyboard/']")
    public WebElement about;

    @FindBy()
    public WebElement exploreMore;

    protected VlumeKeyboardPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnVlumeKeyboard() {
        vlumeKeyboard.click();
    }

    public void pressOnAboutLink() {
        about.click();
    }

    public void pressOnExploreMore() {
        exploreMore.click();
    }

    public boolean vlumeKeyboardPageIsLoaded() {
        return super.pageIsLoaded(this.vlumeKeyboard, this.about, this.exploreMore);
    }
}
