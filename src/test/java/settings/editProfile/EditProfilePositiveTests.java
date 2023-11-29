package settings.editProfile;

import base.AuthorizedTest;
import dataProvider.User;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.ProfilePage;
import org.example.pages.settings.SettingsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class EditProfilePositiveTests extends AuthorizedTest {

    SettingsPage settingsPage;

    @BeforeMethod
    public void createPage() {
        settingsPage = new SettingsPage(driver);

        log.info("Go settings page");
        goToURL(UrlsProvider.SETTINGS_PAGE_URL);

        ProfilePage profilePage = settingsPage.getProfilePage();

        log.info("Assert profile page is opened");
        Assert.assertTrue(settingsPage.isPageOpened());

        log.info("Click edit profile button");
        profilePage.clickEditProfileButton();

        log.info("Assert edit profile page is opened");
        Assert.assertTrue(settingsPage.getEditProfilePage().isPageOpened());
    }

//    @Test
//    public void verifyEditProfilePageIsOpened() {
//        String actualUserFirstName = settingsPage.getEditProfilePage().userFirstName.getText();
//        String expectedUserFirstname = User.loginedUser.getFirstName();
//
//        settingsPage.getEditProfilePage().userLastName.sendKeys("aaaaaaaa");
//        String actualUserFirstName1 = settingsPage.getEditProfilePage().userLastName.getText();
//
//        log.info("Assert in the user name is: {}", expectedUserFirstname);
//        Assert.assertEquals(actualUserFirstName, expectedUserFirstname);
//
//    }

}
