package settings.editProfile;

import base.AuthorizedTest;
import dataProvider.User;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.mat_card.EditProfilePage;
import org.example.pages.settings.mat_card.ProfilePage;
import org.example.pages.settings.SettingsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    @Test(priority = 1)
    public void verifyInputEmailIsNotEnable() {
        log.info("Assert input email is not enable");
        Assert.assertFalse(editProfilePage.userEmail.isEnabled());
    }

    @Test(priority = 2, groups = "returnFirstNameAndLastName")
    public void verifyChangFirstName() {
        String s = "abc";

        log.info("Write in input first name: {}", s);
        editProfilePage.inputFirstName.sendKeys(s);

        log.info("Click save button");
        editProfilePage.clickSaveButton();

        log.info("Assert profile page is opened");
        Assert.assertTrue(profilePage.isPageOpened());

        String actuateFullName = profilePage.userFullName.getText();
        String expectedFullName = User.loginedUser.getFirstName() + s + " " + User.loginedUser.getLastName();

        log.info("Assert user full name is: {}", expectedFullName);
        Assert.assertEquals(actuateFullName, expectedFullName);
    }

    @Test(priority = 3, groups = "returnFirstNameAndLastName")
    public void verifyChangLastName() {
        String s = "abc";

        log.info("Write in input last name: {}", s);
        editProfilePage.inputLastName.sendKeys(s);

        log.info("Click save button");
        editProfilePage.clickSaveButton();

        log.info("Assert profile page is opened");
        Assert.assertTrue(profilePage.isPageOpened());

        String actuateFullName = profilePage.userFullName.getText();
        String expectedFullName = User.loginedUser.getFirstName() + " " + User.loginedUser.getLastName() + s;

        log.info("Assert user full name is: {}", expectedFullName);
        Assert.assertEquals(actuateFullName, expectedFullName);
    }

    @Test(priority = 4)
    public void verifyChangeNameAndCancel() {
        String s = "abc";

        log.info("Write in input first name: {}", s);
        editProfilePage.inputFirstName.sendKeys(s);

        log.info("Click cancel button");
        editProfilePage.clickCancelButton();

        log.info("Assert profile page is opened");
        Assert.assertTrue(profilePage.isPageOpened());

        String actuateFullName = profilePage.userFullName.getText();
        String expectedFullName = User.loginedUser.getFullName();

        log.info("Assert user full name is: {}", expectedFullName);
        Assert.assertEquals(actuateFullName, expectedFullName);
    }

    @AfterMethod(onlyForGroups = "returnFirstNameAndLastName")
    public void returnFirstNameAndLastName() {
        log.info("Go edit profile page");
        profilePage.clickEditProfileButton();

        log.info("Assert edit profile page is openid");
        Assert.assertTrue(editProfilePage.isPageOpened());

        writeHelper.returnLoginedUserFirstName(editProfilePage.inputFirstName);
        writeHelper.returnLoginedUserLastName(editProfilePage.inputLastName);

        editProfilePage.clickSaveButton();

        log.info("Assert profile page is opened");
        Assert.assertTrue(profilePage.isPageOpened());
    }
}
