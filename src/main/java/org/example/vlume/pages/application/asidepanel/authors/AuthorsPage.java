package org.example.vlume.pages.application.asidepanel.authors;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorsPage extends BasePage {

    @FindBy(xpath = "//mat-card[@class='mat-card card-style']")
    public WebElement authorsList;

    public AuthorsPage(WebDriver driver) {
        super(driver);
    }

    public boolean authorsPageIsLoaded() {
        return super.pageIsLoaded(this.authorsList);
    }
}
