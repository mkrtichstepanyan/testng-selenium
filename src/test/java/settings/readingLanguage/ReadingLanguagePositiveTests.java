package settings.readingLanguage;

import base.AuthorizedTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.SettingsPage;
import org.example.pages.settings.mat_card.ReadingLanguagesPage;
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
        Assert.assertTrue(readingLanguagesPage.buttonReadEnglish.isSelected());

        log.info("Assert radio button reading Armenian is selected");
        Assert.assertTrue(readingLanguagesPage.buttonReadArmenia.isSelected());
    }

}
