package org.example.pages.app.userprofilepages.membership.firstsection;

import org.example.pages.footer.AboutSection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinNowFirstState extends JoinNowDiv {

    @FindBy(id = "startFreeTrial")
    public WebElement startFreeTrial;
    @FindBy(xpath = "//simple-snack-bar//span")
    public WebElement messageBox;

    public JoinNowFirstState(WebDriver driver) {
        super(driver);
    }

    public void pressOnStartFreeTrialButton() {
        waitHelper.waitUntilElementWillBeVisible(this.startFreeTrial);
        startFreeTrial.click();
    }

    public String getMessageBoxText() {
        waitHelper.waitUntilElementWillBeVisible(this.messageBox);
        return this.messageBox.getText();
    }

    public boolean joinNowFirstStateIsLoaded() {
        return super.pageIsLoaded(this.startFreeTrial);
    }
}
