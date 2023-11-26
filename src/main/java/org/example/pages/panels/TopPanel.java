package org.example.pages.panels;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopPanel extends BasePage {
    @FindBy(xpath = "//div[@class='ng-star-inserted']/a")
    public WebElement vlumeButton;

    @FindBy(xpath = "//span[@id='selectLanguage']")
    public WebElement selectLanguageButton;

    @FindBy(xpath = " //a[@class ='sign-in-button ng-star-inserted']")
    public WebElement selectSignInButton;

    public void clickOnVlumeButton() {
        this.vlumeButton.click();
    }

    public void clickOnSelectLanguageButton() {
        this.selectLanguageButton.click();
    }

    public void selectSignInButton() {
        this.selectSignInButton.click();
    }

    public TopPanel(WebDriver driver) {
        super(driver);
    }
}
