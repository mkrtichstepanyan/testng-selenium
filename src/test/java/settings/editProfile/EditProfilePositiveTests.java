package settings.editProfile;

import base.AuthorizedTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.EditProfilePage;
import org.example.pages.settings.ProfilePage;
import org.example.pages.settings.SettingsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class EditProfilePositiveTests extends AuthorizedTest {

    SettingsPage settingsPage;
    ProfilePage profilePage;

    EditProfilePage editProfilePage;

    @BeforeMethod
    public void goEditProfilePage() {
        settingsPage = new SettingsPage(driver);
        profilePage = settingsPage.getProfilePage();
        editProfilePage = settingsPage.getEditProfilePage();

        log.info("Go settings page");
        goToURL(UrlsProvider.SETTINGS_PAGE_URL);

        log.info("Assert profile page is opened");
        Assert.assertTrue(settingsPage.isPageOpened());

        log.info("Click edit profile button");
        profilePage.clickEditProfileButton();

        log.info("Assert edit profile page is opened");
        Assert.assertTrue(editProfilePage.isPageOpened());
    }
    
}
