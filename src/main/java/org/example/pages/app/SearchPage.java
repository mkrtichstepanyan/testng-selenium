package org.example.pages.app;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//mat-card[@class='mat-card boxSize card-style']")
    public WebElement categoriesDiv;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean searchPageIsLoaded() {
        return super.pageIsLoaded(this.categoriesDiv);
    }
}
