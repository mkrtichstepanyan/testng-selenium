package org.example.vlumetests.positivetests.panels.toppaneltests.logedintests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.SignInPage;
import org.example.pages.panels.toppanel.TopPanel;
import org.example.pages.panels.toppanel.signedIn.UserProfile;
import org.example.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.providers.urlproviders.toppanel.UrlMembershipProvider;
import org.example.providers.urlproviders.toppanel.UrlSettingProvider;
import org.example.providers.urlproviders.toppanel.UrlSupportProvider;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class UserMenuTests extends BaseTest {
    TopPanel topPanel;
    SignInPage signInPage;
    UserProfile userProfile;

    @BeforeClass
    public void logIn() {
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("Sign in With Valid Data");
        signInPage.signInWithValidData();
        topPanel = new TopPanel(UserProfile.class, driver);
        topPanel.topPanelIsLoaded();
        userProfile = (UserProfile) topPanel.getInstanceAuthElement();
    }

    @BeforeMethod()
    public void validateUserProfileIconFunctionality() {
        log.info("Click on 'User Profile' Icon");
        userProfile.pressOnUserProfileIcon();

        log.info("Check modal loading");
        boolean userMenuExistsAfterClicking = userProfile.userMenu.userMenuIsLoaded();
        Assert.assertTrue(userMenuExistsAfterClicking);
    }


    @Test(priority = 0)
    public void validateFunctionalityOfMembershipButton() {
        softAssert = new SoftAssert();
        waitHelper.waitForSeconds(2);
        log.info("Validate Current URL Before Press on 'Membership' Button from User Profile Menu");
        String urlBeforePressOnMembershipButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnMembershipButton,
                UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());

        log.info("Press on Membership part");
        userProfile.userMenu.pressOnMembershipPart();

        waitHelper.waitForSeconds(5);
        log.info("Validate Current URL After Press on Membership Button");
        String urlAfterPressedOnMembershipPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnMembershipPart,
                UrlMembershipProvider.MEMBERSHIP_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void validateFunctionalityOfSettingsButton() {
        softAssert = new SoftAssert();
        waitHelper.waitForSeconds(2);
        log.info("Validate Current URL Before Press on 'Settings' Button from User Profile Menu");
        String urlBeforePressOnSettingsButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSettingsButton,
                UrlMembershipProvider.MEMBERSHIP_PAGE_URL.getUrl());

        log.info("Press on Settings part");
        userProfile.userMenu.pressOnSettingPart();

        waitHelper.waitForSeconds(5);
        log.info("Validate Current URL After Press on Settings Button");
        String urlAfterPressedOnSettingsPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSettingsPart,
                UrlSettingProvider.SETTINGS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void validateFunctionalityOfSupportButton() {
        softAssert = new SoftAssert();
        waitHelper.waitForSeconds(2);
        String windowHandleDev = driver.getWindowHandle();
        log.info("Validate Current URL Before Press on 'Support' Button from User Profile Menu");
        String urlBeforePressOnSupportButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSupportButton,
                UrlSettingProvider.SETTINGS_PAGE_URL.getUrl());

        log.info("Press on Support part");
        userProfile.userMenu.pressOnSupportPart();

        log.info("Validate Current URL After Press on Support Button");
        String urlAfterPressedOnSupportPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSupportPart,
                UrlSupportProvider.SUPPORT_PAGE_URL.getUrl());
        driver.switchTo().window(windowHandleDev);
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void validateFunctionalityOfSignOutButton() {
        softAssert = new SoftAssert();

        log.info("Validate Current URL Before Press on 'Sign Out' Button from User Profile Menu");
        String urlBeforePressOnSignOutButton = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSignOutButton,
                UrlSettingProvider.SETTINGS_PAGE_URL.getUrl());

        log.info("Press on Support part");
        userProfile.userMenu.pressOnSignOutPart();

        waitHelper.waitForSeconds(5);
        log.info("Validate Current URL After Press on Sign Out Button");
        String urlAfterPressedOnSignOutPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSignOutPart,
                UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

}
