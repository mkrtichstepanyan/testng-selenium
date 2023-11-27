package org.example.vlume.pages.application.asidepanel.search;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(id="searchButton")
    public WebElement searchIcon;

    @FindBy(xpath = "//mat-card[@class='mat-card boxSize card-style']")
    public WebElement categoriesDiv;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnSearchIconFromAsidePanel(){
        searchIcon.click();
    }

    public boolean searchPageIsLoaded() {
        return super.pageIsLoaded(this.categoriesDiv);
    }
}
