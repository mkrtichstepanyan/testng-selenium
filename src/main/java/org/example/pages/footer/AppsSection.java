package org.example.pages.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.example.pages.BasePage;

public class AppsSection extends BasePage{
    @FindBy(id="appleLink")
    public WebElement appStore;

    @FindBy(id="androidLink")
    public WebElement googlePlay;

    public AppsSection(WebDriver driver) {
        super(driver);
    }
    public void pressOnAppStoreLogo(){
        appStore.click();
    }

    public void pressOnGooglePlayLogo(){
        googlePlay.click();
    }
}
