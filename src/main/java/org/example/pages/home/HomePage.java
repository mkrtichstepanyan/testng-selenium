package org.example.pages.home;

import org.example.pages.BasePage;
import org.example.panel.AuthorizationTopPanel;
import org.example.panel.HomeTopPanel;
import org.example.panel.TopPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div//p[@id = 'homeButton']")
    public WebElement homeButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(homeButton);
    }

    @Override
    public TopPanel getTopPanel(WebDriver driver) {
        return new HomeTopPanel(driver);
    }
}
