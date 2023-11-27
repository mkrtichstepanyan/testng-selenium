package org.example.vlume.pages.toppanel;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopPanel  extends BasePage {
    @FindBy(xpath = "//img[@class='logo']")
    public WebElement logo;

    @FindBy(id="selectLanguage")
    public WebElement selectLanguage;

    @FindBy(id="hy")
    public WebElement selectLanguageHy;

    @FindBy(id="hw")
    public WebElement selectLanguageHw;

    @FindBy(id="en")
    public WebElement selectLanguageEn;

    public TopPanel(WebDriver driver) {
        super(driver);
    }

    public void pressOnVlumeLogo(){
        this.logo.click();
    }

    public void pressOnLanguage(){
        this.selectLanguage.click();
    }

    public void pressFromLanguageHy(){
        this.selectLanguageHy.click();
    }

    public void pressFromLanguageHw(){
        this.selectLanguageHw.click();
    }

    public void pressFromLanguageEn(){
        this.selectLanguageEn.click();
    }

}
