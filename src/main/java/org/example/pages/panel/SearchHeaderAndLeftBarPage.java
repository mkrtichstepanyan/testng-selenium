package org.example.pages.panel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHeaderAndLeftBarPage extends HeaderPage {
    @FindBy(xpath = "//div[@class='search-barr-container']//div[@class='search-web']//button")
    public WebElement vlumeKeyboard;

    @FindBy(xpath = "//div[@class='search-barr-container']//div[@class='search-web']//input")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='search-barr-container']/app-search-barr//p[@id='searchByTitle']")
    public WebElement title;

    @FindBy(xpath = "//div[@class='search-barr-container']//p[@id='searchByReadingList']")
    public WebElement readingLists;


//    @FindBy(xpath = "//div[@class='menu-item-container filter-item']//svg")
//    public WebElement filterIcon;

    @FindBy(xpath = "//div[@class='filters-container ng-star-inserted']//p[@class='menu-item-name-style']")
    public WebElement filter;

    @FindBy(id = "FormatTitle")
    public WebElement format;

    @FindBy(xpath = "//app-filter-checkbox[@id='AudiobookCheckBox']")
    public WebElement audiobookCheckbox;

    @FindBy(id = "AudiobookText")
    public WebElement audiobookCheckboxText;

    @FindBy(xpath = "//app-filter-checkbox[@id='EbookCheckBox']")
    public WebElement ebookCheckbox;

    @FindBy(id = "EbookText")
    public WebElement ebookCheckboxText;

    @FindBy(xpath = "//app-filter-checkbox[@id='AnimationCheckBox']")
    public WebElement tvCheckbox;

    @FindBy(id = "TVText")
    public WebElement tvCheckboxText;

    @FindBy(id = "LanguageTitle")
    public WebElement language;

    @FindBy(xpath = "//app-filter-checkbox[@id='English']")
    public WebElement englishCheckbox;

    @FindBy(id = "EnglishText")
    public WebElement englishCheckboxText;

    @FindBy(xpath = "//app-filter-checkbox[@id='Հայերեն']")
    public WebElement armenianCheckbox;

    @FindBy(id = "ՀայերենText")
    public WebElement armenianCheckboxText;

    @FindBy(id = "DialectTitle")
    public WebElement dialect;

    @FindBy(xpath = "//app-filter-checkbox[@id='EasternArmenian']")
    public WebElement easternArmenianCheckbox;

    @FindBy(id = "EasternArmenianText")
    public WebElement easternArmenianCheckboxText;

    @FindBy(xpath = "//app-filter-checkbox[@id='WesternArmenian']")
    public WebElement westernArmenianCheckbox;

    @FindBy(id = "WesternArmenianText")
    public WebElement westernArmenianCheckboxText;

    @FindBy(id = "SpellingTitle")
    public WebElement spelling;

    @FindBy(xpath = "//app-filter-checkbox[@id='ClassicalArmenian']")
    public WebElement classicalArmenianCheckbox;

    @FindBy(id = "ClassicalArmenianText")
    public WebElement classicalArmenianCheckboxText;

    @FindBy(xpath = "//app-filter-checkbox[@id='ModernArmenian']")
    public WebElement modernArmenian;

    @FindBy(id = "ModernArmenianText")
    public WebElement modernArmenianCheckboxText;

    @FindBy(id = "resetFilter")
    public WebElement resetFilter;

    public WebElement[] webElements = {
            vlumeHomePage, global, language, profilePicture, title,
            profileProperties, vlumeKeyboard, searchInput, readingLists,
            filter, format, audiobookCheckbox, audiobookCheckboxText,
            ebookCheckbox, ebookCheckboxText, tvCheckbox, tvCheckboxText,
            language, englishCheckbox, englishCheckboxText, armenianCheckbox,
            armenianCheckboxText, dialect, easternArmenianCheckbox, easternArmenianCheckboxText,
            westernArmenianCheckbox, westernArmenianCheckboxText, spelling,
            classicalArmenianCheckbox, classicalArmenianCheckboxText,
            modernArmenian, modernArmenianCheckboxText, resetFilter
    };

    public SearchHeaderAndLeftBarPage(WebDriver driver) {
        super(driver);
    }
}
