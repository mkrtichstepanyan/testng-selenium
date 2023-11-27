package vlume.negativetests.autentiacation.signin;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.autentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SignInPageNegativeTest extends BaseTest {

    SignInPage signInPage;
    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign In Page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validateSignInByUsingIncorrectEmail() {
        log.info("-> Enter Incorrect Email");
        waitHelper.waitForElementToBeClickable(signInPage.emailField);
        signInPage.enterEmail("samsungansuryangmail.com");
        waitHelper.waitForSeconds(2);

        log.info("-> Validate Value has been successfully entered");
        softAssert.assertTrue(signInPage.emailField.getAttribute("value")
                .equals("samsungansuryangmail.com"));

        log.info("-> Enter password");
        waitHelper.waitUntilElementWillBeVisible(signInPage.passwordField);
        signInPage.enterPassword("sfhfdhsgsg");

        log.info("-> Validate Value has been successfully entered");
        softAssert.assertTrue(signInPage.passwordField.getAttribute("value").equals("sfhfdhsgsg"));

        log.info("-> Press on <Send> button");
        waitHelper.waitForElementToBeClickable(signInPage.signInButton);
        signInPage.pressSignInButton();

        log.info("-> Validate Message Existence after pressed on <Send> button");
        waitHelper.waitUntilElementWillBeVisible(signInPage.messageBox);
        String messageText = signInPage.getMessageBoxText();
        softAssert.assertEquals(messageText, "Wrong credentials");

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
