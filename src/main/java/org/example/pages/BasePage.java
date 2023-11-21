package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class BasePage {

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
