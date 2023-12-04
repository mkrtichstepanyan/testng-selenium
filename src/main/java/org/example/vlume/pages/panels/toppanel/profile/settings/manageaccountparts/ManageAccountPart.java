package org.example.vlume.pages.panels.toppanel.profile.settings.manageaccountparts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAccountPart extends ManageAccountPartsDiv {

    @FindBy(css = "p[class='delete-text']")
    public WebElement deleteAccount;
    @FindBy(id = "ConfirmationDelete")
    public WebElement cancelButton;

    public ManageAccountPart(WebDriver driver) {
        super(driver);
    }

    public void pressOnDeleteAccountLink() {
        deleteAccount.click();
    }

    public void pressOnCancelButton() {
        cancelButton.click();
    }

    public boolean manageAccountPartIsLoaded() {
        return super.pageIsLoaded(this.deleteAccount);
    }
}
