package vlume.positivetests.toppanel.profile.settings;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.home.HomePage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.pages.toppanel.profile.settings.SettingPart;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.toppanel.menuuser.setting.UrlSettingProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SettingPartPositiveTests extends BaseTest {

    SignInPage signInPage;
    HomePage homePage;
    SettingPart settingPart;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        signInPage.enterEmail("samsungansuryan@gmail.com");
        signInPage.enterPassword("8663a375315");
        signInPage.pressSignInButton();
        waitHelper.waitForSeconds(3);
    }

    @BeforeMethod
    public void goToHomePage() {

        log.info("-> Open Home page");
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
        homePage = new HomePage(driver);
        settingPart = new SettingPart(driver);
        Assert.assertTrue(homePage.homePageIsLoaded(), "Home page is not loaded");
    }

    @BeforeMethod
    @Test
    public void validatePressOnPressOnUserProfileIcon() {

        log.info("-> Press on User profile icon");
        waitHelper.waitForElementToBeClickable(settingPart.userProfile);
        settingPart.pressOnUserProfileIcon();
        Assert.assertTrue(settingPart.settingPartIsLoaded(), "Settings part is not loaded");
    }

    @Test
    public void validatePressOnSettingPart() {
        softAssert = new SoftAssert();

        log.info("-> Validate current URL before press on Setting page from menu user profile");
        String urlBeforePressOnSettingPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnSettingPart,
                UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());


        log.info("-> Press on Setting part");
        waitHelper.waitUntilElementWillBeVisible(settingPart.settingPage);
        settingPart.pressOnSettingPart();

        log.info("-> Validate current URL after press on Setting page");
        String urlAfterPressedOnSettingPart = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnSettingPart,
                UrlSettingProvider.SETTINGS_PAGE_URL.getUrl());
        softAssert.assertAll();
    }
}
