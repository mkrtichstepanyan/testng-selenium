package org.example.vlume.pages.toppanel.profile.membership;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinNowPart extends BasePage {

    @FindBy(id="startFreeTrial")
    public WebElement startFreeTrial;

    public JoinNowPart(WebDriver driver) {
        super(driver);
    }


    public void pressOnStartFreeTrialButton(){
        startFreeTrial.click();
    }

    public boolean joinNowPartIsLoaded(){
        return super.pageIsLoaded(this.startFreeTrial);
    }
}
