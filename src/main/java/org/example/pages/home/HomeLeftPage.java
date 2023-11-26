package org.example.pages.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeLeftPage {

    public WebElement home;

    @FindBy(xpath = "//div//p[@id = 'searchButton']")
    public WebElement search;
    public WebElement audiobooks;
    public WebElement ebooks;
    public WebElement authors;
    public WebElement myList;
    public WebElement gift;

    @FindBy(xpath = "//div[@class = 'footer-container']//img")
    public WebElement icon;

    @FindBy(xpath = "//div//a[@href = 'https://vlume.com/terms/']")
    public WebElement termOfService;

    @FindBy(xpath = "//div//a[@href = 'https://vlume.com/privacy/']")
    public WebElement privacyPolicy;



}
