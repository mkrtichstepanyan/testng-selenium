package org.example.vlumetests.positivetests.panels.toppaneltests.logedintests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.SignInPage;
import org.example.pages.panels.toppanel.TopPanel;
import org.example.pages.panels.toppanel.signedIn.UserProfile;
import org.example.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Slf4j
public class UserInfoTests extends BaseTest {
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
        Assert.assertTrue(topPanel.topPanelIsLoaded());
    }

    @Test(priority = 0)
    public void validateUserMenuInvisibilityBeforeOpeningIt() {
        log.info("Validate User Menu Invisibility Before Opening It");
        userProfile = (UserProfile) topPanel.getInstanceAuthElement();
        Assert.assertThrows("User Menu is opened before clicking on 'User Profile' icon",
                NullPointerException.class,
                () -> userProfile.userMenu.userMenuIsLoaded());
    }

    @Test(priority = 1)
    public void validateUserProfileIconFunctionality() {
        log.info("Click on 'User Profile' Icon");
        userProfile.pressOnUserProfileIcon();

        log.info("Check modal loading");
        boolean userMenuExistsAfterClicking = userProfile.userMenu.userMenuIsLoaded();
        Assert.assertTrue(userMenuExistsAfterClicking);
    }
}
