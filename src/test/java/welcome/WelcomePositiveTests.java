package welcome;

import base.BaseTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.helpers.WaitHelper;
import org.example.pages.wordpress.WelcomePage;
import org.example.pages.wordpress.WelcomeTopPanel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class WelcomePositiveTests extends BaseTest {

    WelcomePage welcomePage;
    WelcomeTopPanel welcomePageTopPanel;

    @BeforeMethod
    public void goToUrl() {
        goToURL(UrlsProvider.WELCOME_PAGE_URL);
        welcomePage = new WelcomePage(driver);
        welcomePageTopPanel = new WelcomeTopPanel(driver);
    }

    @Test
    public void verifyWelcomePageIsOpenid(){
        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());
    }

    @Test
    public void verifyToPanelIsVisible(){
        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Assert welcome page's top panel is visible");
        Assert.assertTrue(welcomePage.getTopPanel().isTopPanelVisible());
    }

    @Test
    public void changeLanguageInArevelahayeren(){
        log.info("Assert welcome page is opened");
        Assert.assertTrue(welcomePage.isPageOpened());

        log.info("Assert welcome page's top panel is visible");
        Assert.assertTrue(welcomePage.getTopPanel().isTopPanelVisible());

        log.info("Click on language");
        welcomePage.getTopPanel().clickLanguage();

        log.info("Change language in arevelahayeren");
        welcomePage.getTopPanel().arevelahayeren.click();


        log.info("Click on language");
        welcomePage.getTopPanel().clickLanguage();

        log.info("Change language in arevelahayeren");
        welcomePage.getTopPanel().english.click();
//        welcomePage.getTopPanel().clickLanguage();
//
//        welcomePage.getTopPanel().english.click();

    }
}
