package vlume.positivetests.panels.toppanel.header;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.panels.toppanel.header.SignInButton;
import org.example.vlume.pages.panels.toppanel.header.TopPanel;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class TopPanelPositiveTests extends BaseTest {
    TopPanel topPanel;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open sign in page from top panel");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        topPanel = new TopPanel(driver, SignInButton.class);
    }

    @Test
    public void validatePressOnVlumeLogo() {
        softAssert = new SoftAssert();


        log.info("-> Verify current URL Sign in page before press on Vlume logo");
        String urlBeforePressOnVlumeLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnVlumeLogo, UrlProvider.SIGN_IN_PAGE_URL.getUrl());

        log.info("-> Press on <Vlume> logo");
        waitHelper.waitForElementToBeClickable(topPanel.logo);
        topPanel.pressOnVlumeLogo();

        log.info("-> Verify current URL Welcome page after pressed on Vlume logo");
        String urlAfterPressOnVlumeLogo = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressOnVlumeLogo, UrlProvider.WELCOME_PAGE_URL.getUrl());
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnLanguage() {
        log.info("-> Press on <Language> icon");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        waitHelper.waitForSeconds(2);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);
    }

    @Test
    public void validatePressFromLanguageHy() {
        log.info("-> Press on <Language> icon");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);

        log.info("-> Select from <Language> East Armenian <Hy>");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguageHy);
        topPanel.pressFromLanguageHy();
        waitHelper.waitForSeconds(2);
    }

    @Test
    public void validatePressFromLanguageHw() {

        log.info("-> Press on <Language> icon");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);

        log.info("-> Select from <Language> West Armenian (Hw)");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguageHw);
        topPanel.pressFromLanguageHw();
        waitHelper.waitForSeconds(2);
    }

    @Test
    public void validatePressFromLanguageEn() {

        log.info("-> Press on <Language> icon");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguage);
        topPanel.pressOnLanguage();
        waitHelper.waitForSeconds(2);

        log.info("-> Select from <Language> English");
        waitHelper.waitForElementToBeClickable(topPanel.selectLanguageEn);
        topPanel.pressFromLanguageEn();
        waitHelper.waitForSeconds(2);
    }
}
