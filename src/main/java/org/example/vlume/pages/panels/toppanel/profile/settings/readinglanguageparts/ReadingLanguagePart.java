package org.example.vlume.pages.panels.toppanel.profile.settings.readinglanguageparts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadingLanguagePart extends ReadingLanguagePartDiv {

    @FindBy(id = "languageButton0")
    public WebElement iCanReadEnglishButton;

    @FindBy(id = "languageButton1")
    public WebElement iCanReadArmenianButton;


    public ReadingLanguagePart(WebDriver driver) {
        super(driver);
    }

    public void pressOnICanReadEnglishButton() {
        iCanReadEnglishButton.click();
    }

    public void pressOnICanReadArmenianButton() {
        /*
        String colorQuery = "var colorName = function(rgb) {"
                + "  var colorName = require('color-name');"
                + "  var hex = rgbToHex(rgb);"
                + "  var name = colorName(hex);"
                + "  return name ? name : 'unknown';"
                + "};"
                + "var rgbToHex = function(rgb) {"
                + "  var hex = Number(rgb).toString(16);"
                + "  if (hex.length < 2) {"
                + "    hex = '0' + hex;"
                + "  }"
                + "  return hex;"
                + "};"
                + "return colorName(window.getComputedStyle(arguments[0]).color);";
         */
        String colorQuery = "return document.getComputedStyle(arguments[0]).color;";
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String color = (String) jsExecutor.executeScript(colorQuery, iCanReadArmenianButton);
        System.out.println(color);
        iCanReadArmenianButton.click();
//        colorQuery = "return window.getComputedStyle(arguments[0]).color;";
        jsExecutor = (JavascriptExecutor) driver;
        color = (String) jsExecutor.executeScript(colorQuery, iCanReadArmenianButton);
        System.out.println(color);
    }

    public boolean readingLanguagePartIsLoaded() {
        return super.pageIsLoaded(this.iCanReadEnglishButton, this.iCanReadArmenianButton);
    }
}
