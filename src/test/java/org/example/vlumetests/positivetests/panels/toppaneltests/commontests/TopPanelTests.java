package org.example.vlumetests.positivetests.panels.toppaneltests.commontests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.panels.toppanel.SignInElement;
import org.example.pages.panels.toppanel.TopPanel;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class TopPanelTests extends BaseTest {
    TopPanel topPanel;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Sign In Page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        topPanel = new TopPanel(SignInElement.class, driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validatePressOnVlumeLogo() {
        log.info("Validate Current Url Before Clicking on Vlume Logo");
        String urlBeforeClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforeClick, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("Click on Vlume logo");
        waitHelper.waitForElementToBeClickable(topPanel.logo);
        topPanel.pressOnVlumeImg();

        log.info("Validate Current Url After Clicking on Vlume Logo");
        String urlAfterClick = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterClick, UrlProvider.WELCOME_PAGE_URL.getUrl());

        softAssert.assertAll();
    }

    @Test
    public void validatePressOnLanguage() {
        log.info("Check if Language Dropdown is closed");
        try {
            waitHelper.checkInvisibilityOfElements(topPanel.selectLanguageHy, topPanel.selectLanguageHw, topPanel.selectLanguageEn);
        } catch (TimeoutException e) {
            softAssert.fail("The Dropdown is Opened");
        }

        log.info("Click on 'Languages' dropdown");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);

        log.info("Check if Language Dropdown is opened");
        try {
            waitHelper.waitForAllElementsToBeVisible(topPanel.selectLanguageEn, topPanel.selectLanguageHy, topPanel.selectLanguageHw);
        } catch (TimeoutException e) {
            softAssert.fail("The Dropdown is not Opened");
        }
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnLanguageHy() {
        log.info("Select 'Armenian' option from 'Languages' dropdown");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguageHy);
        topPanel.pressFromLanguageHy();
        waitHelper.waitForSeconds(2);
    }

    @Test
    public void validatePressOnLanguageHw() {
        log.info("Select 'Western Armenian' option from 'Languages' dropdown");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguageHw);
        topPanel.pressFromLanguageHw();
        waitHelper.waitForSeconds(2);
    }

    @Test
    public void validatePressOnLanguageEn() {
        log.info("Select 'English' option from 'Languages' dropdown");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguageEn);
        topPanel.pressFromLanguageEn();
        waitHelper.waitForSeconds(2);
    }
}
