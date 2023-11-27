package org.example.pages.wordpress;

import org.example.pages.BaseTopPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomeTopPanel extends BaseTopPanel {

    @FindBy(xpath = "//div//a[@href = 'https://dev.vlume.com/w/']")
    public WebElement vlume;

    @FindBy(xpath = "//div//a[@href = '#pll_switcher']")
    public WebElement language;

    @FindBy(xpath = "//div//a[@href = 'https://dev.vlume.com/w/blog/']")
    public WebElement news;

    public WelcomeTopPanel(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTopPanelVisible(WebElement... elements) {
        return super.isTopPanelVisible(vlume,language,news);
    }

    public void clickLanguage(){
        language.click();
    }
}
