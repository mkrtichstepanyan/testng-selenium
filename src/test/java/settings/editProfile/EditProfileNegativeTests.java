package settings.editProfile;

import base.AuthorizedTest;
import dataProvider.errorMessage.ErrorMessage;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.mat_card.EditProfilePage;
import org.example.pages.settings.mat_card.ProfilePage;
import org.example.pages.settings.SettingsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class EditProfileNegativeTests extends AuthorizedTest {

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

    @Test
    public void verifyFirstNameErrorMessageWhenInputNameIsEmpty() {
        WebElement inputName = editProfilePage.inputFirstName;
        SoftAssert softAssert = new SoftAssert();

        log.info("Clear input name");
        writeHelper.clearInput(inputName);

        log.info("Click save button");
        editProfilePage.clickSaveButton();

        log.info("Assert input name error message is display");
        softAssert.assertTrue(editProfilePage.firstNameErrorMessage.isDisplayed());

        log.info("Assert input name error message is: {}", ErrorMessage.FIRST_NAME_ERROR_MESSAGE);
        softAssert.assertEquals(editProfilePage.firstNameErrorMessage.getText(), ErrorMessage.FIRST_NAME_ERROR_MESSAGE);

        softAssert.assertAll();
    }

    @Test
    public void verifyLastNameErrorMessageWhenInputLastNameIsEmpty() {
        WebElement inputLastName = editProfilePage.inputLastName;
        SoftAssert softAssert = new SoftAssert();

        log.info("Clear input name");
        writeHelper.clearInput(inputLastName);

        log.info("Click save button");
        editProfilePage.clickSaveButton();

        log.info("Assert input name error message is display");
        softAssert.assertTrue(editProfilePage.lastNameErrorMessage.isDisplayed());

        log.info("Assert input name error message is: {}", ErrorMessage.LAST_NAME_ERROR_MESSAGE);
        softAssert.assertEquals(editProfilePage.lastNameErrorMessage.getText(), ErrorMessage.LAST_NAME_ERROR_MESSAGE);

        softAssert.assertAll();
    }
}
