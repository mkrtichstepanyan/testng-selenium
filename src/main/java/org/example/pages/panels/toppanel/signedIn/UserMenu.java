package org.example.pages.panels.toppanel.signedIn;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class UserMenu extends BasePage {
    @FindBy(id = "settingsPage")
    public WebElement settingPart;
    @FindBy(id = "membershipPage")
    public WebElement membershipPart;
    @FindBy(id = "signOut")
    public WebElement signOut;
    @FindBy(id = "supportPage")
    public WebElement supportPart;

    public UserMenu(WebDriver driver) {
        super(driver);
    }

    public void pressOnMembershipPart() {
        waitHelper.waitUntilElementWillBeVisible(this.membershipPart);
        this.membershipPart.click();
    }

    public void pressOnSettingPart() {
        waitHelper.waitUntilElementWillBeVisible(this.settingPart);
        this.settingPart.click();
    }

    public void pressOnSignOutPart() {
        waitHelper.waitUntilElementWillBeVisible(this.signOut);
        this.signOut.click();
    }

    public void pressOnSupportPart() {
        waitHelper.waitUntilElementWillBeVisible(this.supportPart);
        supportPart.click();
        Set<String> windowHandles = driver.getWindowHandles();
        int index = 0;
        for (String windowHandle : windowHandles) {
            if (index == 1) driver.switchTo().window(windowHandle);
            index++;
        }
    }

    public boolean userMenuIsLoaded() {
        return super.pageIsLoaded(this.membershipPart, this.settingPart, this.supportPart, this.signOut);
    }
}
