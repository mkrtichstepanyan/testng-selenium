package org.example.vlume.pages.panels.toppanel.profile.membership.joinnowparts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinNowPart extends JoinNowPartDiv {

    @FindBy(id = "startFreeTrial")
    public WebElement startFreeTrial;

    @FindBy(xpath = "//simple-snack-bar//span")
    public WebElement messageBox;

    public JoinNowPart(WebDriver driver) {
        super(driver);
    }


    public void pressOnStartFreeTrialButton() {
        startFreeTrial.click();
    }
    public String getMessageBoxText(){
       return messageBox.getText();
    }

    public boolean joinNowPartIsLoaded() {
        return super.pageIsLoaded(this.startFreeTrial);
    }
}
