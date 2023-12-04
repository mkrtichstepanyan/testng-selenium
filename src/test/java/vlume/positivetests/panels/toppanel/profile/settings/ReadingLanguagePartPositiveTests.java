package vlume.positivetests.panels.toppanel.profile.settings;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserMenu;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.example.vlume.pages.panels.toppanel.profile.settings.readinglanguageparts.ReadingLanguagePart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class ReadingLanguagePartPositiveTests extends BaseTest {

    SignInPage signInPage;
    UserMenu userMenu;
    UserProfileIcon userProfileIcon;
    HomePage homePage;
    ReadingLanguagePart readingLanguagePart;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();
        Assert.assertTrue(signInPage.signInPageIsLoaded(), "Sign in page is not loaded");
        waitHelper.waitForSeconds(3);

        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        userMenu = new UserMenu(driver);
        userProfileIcon = new UserProfileIcon(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitForElementToBeClickable(userProfileIcon.userProfile);
        userProfileIcon.pressOnUserProfileIcon();
        readingLanguagePart = new ReadingLanguagePart(driver);
        Assert.assertTrue(userMenu.userMenuIsLoaded(), "User menu part is not loaded");

        log.info("-> Press on Settings part from menu");
        waitHelper.waitUntilElementWillBeVisible(userMenu.settingPart);
        userMenu.pressOnSettingPart();
    }


    @Test(priority = 0)
    public void validatePressOnICanReadEnglishButton() {
        waitHelper.waitForSeconds(5);
        log.info("press on");
        waitHelper.waitUntilElementWillBeVisible(readingLanguagePart.iCanReadArmenianButton);
        readingLanguagePart.pressOnICanReadArmenianButton();
        log.info("pressed on");
        waitHelper.waitForSeconds(6);
    }

//    @Test(priority = 1)
//    public void validate(){
//
//        waitHelper.waitForElementToBeClickable(readingLanguagePart.iCanReadArmenianButton);
//        readingLanguagePart.pressOnICanReadArmenianButton();
//    }


}
