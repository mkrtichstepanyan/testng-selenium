package org.example.vlume.pages.panels.footer.social;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Social extends BasePage {
    @FindBy(css = "a[href='https://www.facebook.com/vlumeapp']")
    public WebElement facebook;

    @FindBy(xpath = "//a[@href='https://twitter.com/vlumeapp']")
    public WebElement twitter;

    public Social(WebDriver driver) {
        super(driver);
    }

    public void pressOnFacebookLink(){
        this.facebook.click();
    }

    public void pressOnTwitterLink(){
        this.twitter.click();
    }
}
