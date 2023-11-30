package settings;

import base.AuthorizedTest;
import dataProvider.User;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.mat_card.ProfilePage;
import org.example.pages.settings.SettingsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SettingsPositiveTests extends AuthorizedTest {
    SettingsPage settingsPage;

    @BeforeMethod
    public void beforeMethod() {
        settingsPage = new SettingsPage(driver);
    }

    @Test(priority = 1)
    public void verifyNavigateWelcomePageToHome() {
        goToURL(UrlsProvider.WELCOME_PAGE_URL);

        log.info("Assert home page is openid");
        Assert.assertTrue(homePage.isPageOpened());
    }

    @Test(priority = 2)
    public void verifySettingsPageIsOpenid() {
        log.info("go to home page");
        goToURL(UrlsProvider.HOME_PAGE_URL);

        log.info("Click on user profile");
        homePage.getTopPanel().clickOnUserProfileButton();

        log.info("Assert settings button is visible");
        Assert.assertTrue(homePage.getTopPanel().settings.isDisplayed());

        log.info("Click settings button");
        homePage.getTopPanel().clickOnSettingsButton();

        log.info("Assert settings page is opened");
        Assert.assertTrue(settingsPage.isPageOpened());
    }

    @Test(priority = 3)
    public void verifyProfilePageIsOpenid() {
        log.info("Go to settings page");
        goToURL(UrlsProvider.SETTINGS_PAGE_URL);

        log.info("Assert settings page is opened");
        Assert.assertEquals(driver.getCurrentUrl(), UrlsProvider.SETTINGS_PAGE_URL);

        log.info("Assert Profile page is opened");
        Assert.assertTrue(settingsPage.getProfilePage().isPageOpened());
    }

    @Test(priority = 4)
    public void verifyUsersFullNameInProfilePage() {
        SoftAssert softAssert = new SoftAssert();

        log.info("Go to settings page");
        goToURL(UrlsProvider.SETTINGS_PAGE_URL);

        log.info("Assert settings page is opened");
        softAssert.assertEquals(driver.getCurrentUrl(), UrlsProvider.SETTINGS_PAGE_URL);

        ProfilePage profilePage = settingsPage.getProfilePage();

        log.info("Assert Profile page is opened");
        softAssert.assertTrue(profilePage.isPageOpened());

        String actualUserFullName = profilePage.userFullName.getText();
        String expectedFullName = User.loginedUser.getFirstName() + " " + User.loginedUser.getLastName();

        log.info("Assert users full name is: {}", expectedFullName);
        softAssert.assertEquals(actualUserFullName, expectedFullName);

        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void verifyUsersEmailInProfilePage() {
        SoftAssert softAssert = new SoftAssert();

        log.info("Go to settings page");
        goToURL(UrlsProvider.SETTINGS_PAGE_URL);

        log.info("Assert settings page is opened");
        softAssert.assertEquals(driver.getCurrentUrl(), UrlsProvider.SETTINGS_PAGE_URL);

        ProfilePage profilePage = settingsPage.getProfilePage();

        log.info("Assert Profile page is opened");
        softAssert.assertTrue(profilePage.isPageOpened());

        String actualEmail = profilePage.userEmail.getText();
        String expectedEmail = profilePage.userEmail.getText();

        log.info("Assert users firstName is: {}", User.loginedUser.getEmail());
        softAssert.assertEquals(actualEmail, expectedEmail);

        softAssert.assertAll();
    }

}
