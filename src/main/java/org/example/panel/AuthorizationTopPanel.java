package org.example.panel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationTopPanel extends TopPanel {

    @FindBy(xpath = "//mat-toolbar//div[@class = 'ng-star-inserted']")
    public WebElement vlume;

    @FindBy(xpath = "//div//app-language-selector")
    public WebElement language;

    @FindBy(xpath = "//div//div[@class = 'mat-menu-trigger user-menu-button-container']")
    public WebElement userProfile;

    public AuthorizationTopPanel(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTopPanelVisible(WebElement... elements) {
        return super.isTopPanelVisible(vlume, language, userProfile);
    }
}
