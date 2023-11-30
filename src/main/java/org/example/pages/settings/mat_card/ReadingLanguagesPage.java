package org.example.pages.settings.mat_card;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadingLanguagesPage extends BasePage {

    @FindBy(xpath = "//p[text() = 'Reading languages']")
    public WebElement title;

    @FindBy(xpath = "//div[@id = 'languageButton0']")
    public WebElement buttonReadEnglish;

    @FindBy(xpath = "//div[@id = 'languageButton1']")
    public WebElement buttonReadArmenia;

    public ReadingLanguagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(title,buttonReadEnglish,buttonReadArmenia);
    }
}
