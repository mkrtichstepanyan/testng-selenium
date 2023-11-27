package org.example.pages.authorization;

import org.example.pages.BaseTopPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationTopPanel extends BaseTopPanel {

    @FindBy(xpath = "//mat-toolbar//div[@class = 'ng-star-inserted']")
    public WebElement vlume;

    @FindBy(xpath = "//div//app-language-selector")
    public WebElement language;

    @FindBy(xpath = "//div//a[@class = 'sign-in-button ng-star-inserted']")
    public WebElement signIn;

    public AuthorizationTopPanel(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTopPanelVisible(WebElement... elements) {
        return super.isTopPanelVisible(vlume, language, signIn);
    }
}
