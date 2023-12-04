package org.example.vlume.pages.panels.footer.getourfreeapps;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppPart extends BasePage {

    @FindBy(id="appleLink")
    public WebElement appStore;

    @FindBy(id="androidLink")
    public WebElement googlePlay;

    public AppPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnAppStoreLogo(){
        appStore.click();
    }

    public void pressOnGooglePlayLogo(){
        googlePlay.click();
    }
}
