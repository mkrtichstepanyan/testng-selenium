package org.example.pages.footer;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagesSection extends BasePage {

    @FindBy(xpath = "//a[@href='/']")
    public WebElement home;

    @FindBy(css = "a[href='/audiobooks']")
    public WebElement audiobooks;

    @FindBy(css = "a[href='/ebooks']")
    public WebElement ebooks;
    @FindBy(xpath = "//a[@href='/authors']")
    public WebElement authors;

    @FindBy(css = "[href='/stack/STK_SITE_RECENT']")
    public WebElement recentlyAdded;

    @FindBy(css = "[href='/stack/STK_SITE_TRENDING']")
    public WebElement trending;

    @FindBy(xpath = "//a[@href='/search']")
    public WebElement categories;
    public void pressOnHomeLink() {
        this.home.click();
    }

    public PagesSection(WebDriver driver) {
        super(driver);
    }

    public void pressOnAudiobooksLink() {
        this.audiobooks.click();
    }

    public void pressOnEbooksLink() {
        this.ebooks.click();
    }
    public void pressOnAuthorsLink() {
        this.authors.click();
    }

    public void pressOnRecentlyAddedLink() {
        this.recentlyAdded.click();
    }

    public void pressOnTrendingLink() {
        this.trending.click();
    }
    public void pressOnCategoriesLink() {
        this.categories.click();
    }
}
