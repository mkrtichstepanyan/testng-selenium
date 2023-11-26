package org.example.panel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeTopPanel extends TopPanel {
    public HomeTopPanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//mat-toolbar//div[@class = 'ng-star-inserted']")
    public WebElement vlume;

    @FindBy(xpath = "//div//app-language-selector")
    public WebElement language;


    @Override
    public boolean isTopPanelVisible(WebElement... elements) {
        return super.isTopPanelVisible(vlume,language);
    }
}
