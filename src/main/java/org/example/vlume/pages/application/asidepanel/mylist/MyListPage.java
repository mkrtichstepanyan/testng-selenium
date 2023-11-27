package org.example.vlume.pages.application.asidepanel.mylist;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyListPage extends BasePage {

    @FindBy(id="myListButton")
    public WebElement myListIcon;

    @FindBy(id="Plus")
    public WebElement plusIcon;

    public MyListPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnMyListIconFromAsidePanel(){
        myListIcon.click();
    }

    public void pressOnPlusIcon(){
        plusIcon.click();
    }

    public boolean myListPageIsLoaded() {
        return super.pageIsLoaded(this.plusIcon, this.myListIcon);
    }
}
