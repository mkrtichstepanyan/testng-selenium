package vlume.positivetests.panels.toppanel.logedintests;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.TopPanel;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class UserInfoTests extends BaseTest {

    TopPanel topPanel;
    SignInPage signInPage;
    UserProfileIcon userProfileIcon;

    @BeforeClass
    public void logIn() {
        log.info("-> Open Sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();
        waitHelper.waitForSeconds(3);
        topPanel = new TopPanel(driver, UserProfileIcon.class);
        Assert.assertTrue(topPanel.topPanelIsLoaded(), "Top panel is not loaded");
    }

    @Test(priority = 0)
    public void validateUserMenuInvisibilityBeforeOpeningIt() {

        log.info("-> Validate User Menu invisibility before opening it");
        userProfileIcon = (UserProfileIcon) topPanel.authenticationElement;
        Assert.assertThrows("User Menu is opened before pressing on user profile icon",
                NullPointerException.class,
                () -> userProfileIcon.userMenu.userMenuIsLoaded());
    }

    @Test(priority = 1)
    public void validateUserProfileIconFunctionality() {

        log.info("-> Press on User profile menu");
        userProfileIcon.pressOnUserProfileIcon();

        log.info("-> Validate User profile icon functionality");
        boolean userMenuExistsAfterPressing = userProfileIcon.userMenu.userMenuIsLoaded();
        Assert.assertTrue(userMenuExistsAfterPressing);
    }
}
