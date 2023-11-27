package org.example.pages.panel;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class LeftBar extends BasePage {
    @FindBy(xpath = "//div[@class='menu-item-container'][1]/svg")
    public WebElement homeIcon;

    @FindBy(id = "homeButton")
    public WebElement homeButton;

    @FindBy(xpath = "//div[@class='menu-item-container'][2]/svg")
    public WebElement searchIcon;

    @FindBy(id = "searchButton")
    public WebElement searchButton;

    @FindBy(xpath = "//img[@src='assets/Icons/Audiobooks.svg']")
    public WebElement audioIcon;

    @FindBy(id = "audiobooksButton")
    public WebElement audiobooksButton;

    @FindBy(xpath = "//img[@src='assets/Icons/Ebooks.svg']")
    public WebElement eBookIcon;

    @FindBy(id = "ebooksButton")
    public WebElement ebooksButton;

    @FindBy(xpath = "//img[@src='assets/Icons/Authors.svg']")
    public WebElement authorsIcon;

    @FindBy(id = "authorsButton")
    public WebElement authorsButton;

    @FindBy(xpath = "//div[@class='menu-item-container'][6]/svg")
    public WebElement myListIcon;

    @FindBy(id = "myListButton")
    public WebElement myListButton;

    @FindBy(xpath = "//div[@class='menu-item-container'][7]/svg")
    public WebElement giftIcon;

    @FindBy(id = "giftButton")
    public WebElement giftButton;

    @FindBy(xpath = "//img[@src='../../../assets/Icons/logo-footer-side.svg']")
    public WebElement vlumeIcon;

    @FindBy(xpath = "//a[@href='https://vlume.com/terms/']")
    public WebElement termsOfService;

    @FindBy(xpath = "//a[@href='https://vlume.com/privacy/']")
    public WebElement privacy;

    @FindBy(className = "copy-right")
    public WebElement allRightReserved;

    @FindBy(className = "version")
    public WebElement version;

    public WebElement[] webElements = {
            homeButton, searchButton,
            audiobooksButton, ebooksButton,
            authorsButton, myListButton,
            giftButton
    };

    public LeftBar(WebDriver driver) {
        super(driver);
    }


    public void clickOnSearchButton() {
        log.info("Clicking on the Search button");
        this.searchButton.click();
    }

    public void clickEbooksButton() {
        log.info("Clicking on the Ebooks button");
        this.ebooksButton.click();

    }


    public void clickOnAuthorsButton() {
        log.info("Clicking on the Authors button");
        this.authorsButton.click();
    }

    public void clickMyListButton() {
        log.info("Clicking on the My List button");
        this.myListButton.click();

    }

    public void clickGiftButton() {
        log.info("Clicking on the Gift button");
        this.giftButton.click();

    }

    public void clickAudiobooksButton() {
        log.info("Clicking on the Audiobooks button");
        this.audiobooksButton.click();
    }

    public void clickAuthorsButton() {
        log.info("Clicking on the Authors button");
        this.authorsButton.click();
    }
}
