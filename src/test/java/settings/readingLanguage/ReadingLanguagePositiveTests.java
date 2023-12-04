package settings.readingLanguage;

import base.AuthorizedTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.SettingsPage;
import org.example.pages.settings.mat_card.ReadingLanguagesPage;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Slf4j
public class ReadingLanguagePositiveTests extends AuthorizedTest {
    SettingsPage settingsPage;
    ReadingLanguagesPage readingLanguagesPage;

    @BeforeMethod
    public void goReadingPage() {
        settingsPage = new SettingsPage(driver);
        readingLanguagesPage = new ReadingLanguagesPage(driver);

        log.info("Go settings page");
        goToURL(UrlsProvider.SETTINGS_PAGE_URL);

        log.info("Assert settings page is opened");
        Assert.assertTrue(settingsPage.isPageOpened());

        log.info("Assert reading language page is opened");
        Assert.assertTrue(readingLanguagesPage.isPageOpened());
    }

    @Test
    public void verifyAllButtonIsSelected(){
        log.info("Assert radio button reading English is selected");

        String en = readingLanguagesPage.buttonReadEnglish.getCssValue("color");
        // convert rgba to hex
        String c = Color.fromString(en).asHex();
        System.out.println("Color is :" + en);
        System.out.println("Hex code for color:" + c);
        driver.quit();

        readingLanguagesPage.buttonReadEnglish.click();
        String arm = readingLanguagesPage.buttonReadEnglish.getCssValue("color");
        // convert rgba to hex
        String cArm = Color.fromString(arm).asHex();
        System.out.println("Color is :" + arm);
        System.out.println("Hex code for color:" + cArm);
        driver.quit();

//        String background = readingLanguagesPage.buttonReadEnglish.getAttribute("background");
//        String background_color = readingLanguagesPage.buttonReadEnglish.getAttribute("background-color");
//        String background_color_css = readingLanguagesPage.buttonReadEnglish.getCssValue("background-color");
//        String color = readingLanguagesPage.buttonReadEnglish.getCssValue("color");
//        String style = readingLanguagesPage.buttonReadEnglish.getAttribute("style");
//        String type = readingLanguagesPage.buttonReadEnglish.getAttribute("type");
//        log.info("background: " + background);
//        log.info(background_color);
//        log.info(color);
//        log.info(style);
//        log.info(background_color_css);
//        log.info(type);
//        String hex = Color.fromString(color).asHex();
//        log.info(hex);

    }

}
