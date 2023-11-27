package org.example.pages.footer;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialSection extends BasePage {

    @FindBy(css = "a[href='https://www.facebook.com/vlumeapp']")
    public WebElement facebook;

    @FindBy(xpath = "//a[@href='https://twitter.com/vlumeapp']")
    public WebElement twitter;

    public SocialSection(WebDriver driver) {
        super(driver);
    }

    public void pressOnFacebookLink() {
        this.facebook.click();
    }

    public void pressOnTwitterLink() {
        this.twitter.click();
    }
}
