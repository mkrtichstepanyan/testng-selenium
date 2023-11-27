package org.example.vlume.pages.footer.legal;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Legal extends BasePage {

    @FindBy(css = "a[href='https://vlume.com/privacy']")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//a[@href='https://vlume.com/terms']")
    public WebElement termsOfService;

    public Legal(WebDriver driver) {
        super(driver);
    }

    public void pressOnPrivacyPolicyLink(){
        this.privacyPolicy.click();
    }

    public void pressOnTermsOfServiceLink(){
        this.termsOfService.click();
    }
}
