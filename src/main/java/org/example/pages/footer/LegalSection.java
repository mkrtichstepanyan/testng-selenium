package org.example.pages.footer;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LegalSection extends BasePage {
    @FindBy(css = "a[href='https://vlume.com/privacy']")
    public WebElement privacyPolicy;

    @FindBy(xpath = "//a[@href='https://vlume.com/terms']")
    public WebElement termsOfService;

    public LegalSection(WebDriver driver) {
        super(driver);
    }

    public void pressOnPrivacyPolicyLink() {
        this.privacyPolicy.click();
    }

    public void pressOnTermsOfServiceLink() {
        this.termsOfService.click();
    }
}
