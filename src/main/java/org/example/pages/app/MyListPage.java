package org.example.pages.app;


import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyListPage extends BasePage {

    @FindBy(xpath = "//mat-card[@class='mat-card boxSize card-style']")
    public WebElement myListPart;
    @FindBy(id="Plus")
    public WebElement plusIcon;

    public MyListPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnPlusIcon(){
        plusIcon.click();
    }

    public boolean myListPageIsLoaded() {
        return super.pageIsLoaded(this.myListPart);
    }
}
