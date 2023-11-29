package org.example.pages.settings;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage extends BasePage {

    @FindBy(xpath = "//button[@id = 'saveButtonEditProfile']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@id = 'cancelButtonEditProfile']")
    public WebElement cancelButton;

    protected EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened(WebElement... elements) {
        return super.isPageOpened(cancelButton, saveButton);
    }
}
