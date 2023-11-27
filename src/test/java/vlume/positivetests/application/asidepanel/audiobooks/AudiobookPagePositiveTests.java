package vlume.positivetests.application.asidepanel.audiobooks;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.audiobooks.AudiobooksPage;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class AudiobookPagePositiveTests extends BaseTest {

    SignInPage signInPage;
    AudiobooksPage audiobooks;

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
        driver.get(UrlProvider.HOME_PAGE_URL.getUrl());
        audiobooks = new AudiobooksPage(driver);
        boolean pageIsLoaded = audiobooks.audiobooksPageIsLoaded();
        softAssert = new SoftAssert();
        softAssert.assertTrue(pageIsLoaded);
    }

    @Test
    public void validatePressOnAudiobooksIcon() {

        log.info("-> Validate current URL before press on Audiobooks icon");
        String urlBeforePressOnAudiobooksIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlBeforePressOnAudiobooksIcon, UrlProvider.HOME_PAGE_URL.getUrl());

        log.info("-> Press on Audiobooks icon from aside panel");
        waitHelper.waitForSeconds(3);
        waitHelper.waitForElementToBeClickable(audiobooks.audiobooksIcon);
        audiobooks.pressOnAudiobooksIconFromAsidePane();

        log.info("-> Validate current URL after pressed on Audiobooks icon");
        waitHelper.waitForSeconds(4);
        String urlAfterPressedOnAudiobooksIcon = driver.getCurrentUrl();
        softAssert.assertEquals(urlAfterPressedOnAudiobooksIcon,
                UrlProvider.AUDIOBOOKS_PAGE_URL.getUrl());

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

}
