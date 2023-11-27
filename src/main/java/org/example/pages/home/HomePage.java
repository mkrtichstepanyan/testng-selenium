package org.example.pages.home;

import org.example.pages.BasePage;
import org.example.pages.BaseTopPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private final HomeTopPanel homeTopPanel;

    @FindBy(xpath = "//div//p[@id = 'homeButton']")
    public WebElement homeButton;

    public HomePage(WebDriver driver) {
        super(driver);
        homeTopPanel = new HomeTopPanel(driver);
    }

    public HomeTopPanel getTopPanel() {
        return homeTopPanel;
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(homeButton);
    }
}
