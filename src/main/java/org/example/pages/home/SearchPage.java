package org.example.pages.home;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(tagName = "h1")
    public WebElement categories;

    @FindBy(xpath = "//a[@href='/category/11']")
    public WebElement biographyAndMemory;

    @FindBy(xpath = "//a[@href='/category/12']")
    public WebElement fiction;

    @FindBy(xpath = "//a[@href='/category/13']")
    public WebElement poetryAndDrama;

    @FindBy(xpath = "//a[@href='/category/14']")
    public WebElement mysteryAndThrillers;

    @FindBy(xpath = "//a[@href='/category/15']")
    public WebElement humor;

    @FindBy(xpath = "//a[@href='/category/16']")
    public WebElement history;

    @FindBy(xpath = "//a[@href='/category/17']")
    public WebElement romance;

    @FindBy(xpath = "//a[@href='/category/18']")
    public WebElement religionAndSpirituality;

    @FindBy(xpath = "//a[@href='/category/19']")
    public WebElement kidsAndTeens;

    @FindBy(xpath = "//a[@href='/category/20']")
    public WebElement professional;

    @FindBy(xpath = "//a[@href='/category/21']")
    public WebElement lifestyle;

    public WebElement[] webElements = {
            categories, biographyAndMemory, fiction, poetryAndDrama,
            mysteryAndThrillers, humor, history, romance,
            religionAndSpirituality, kidsAndTeens,
            professional, lifestyle
    };


    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
