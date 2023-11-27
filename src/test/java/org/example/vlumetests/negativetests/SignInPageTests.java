package org.example.vlumetests.negativetests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.SignInPage;
import org.example.providers.urlproviders.UrlProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SignInPageTests extends BaseTest {
    SignInPage signInPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Sign In Page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void validateSignInByUsingIncorrectEmail() {
        log.info("Enter Incorrect Email");
        waitHelper.waitForElementToBeClickable(signInPage.emailField);
        signInPage.enterEmail("testgmail.com");
        waitHelper.waitForSeconds(2);

        log.info("Validate Value has been Successfully Entered");
        softAssert.assertTrue(signInPage.emailField.getAttribute("value").equals("testgmail.com"));

        log.info("Enter password");
        waitHelper.waitUntilElementWillBeVisible(signInPage.passwordField);
        signInPage.enterPassword("testtest");

        log.info("Validate Value has been Successfully Entered");
        softAssert.assertTrue(signInPage.passwordField.getAttribute("value").equals("testtest"));

        log.info("Click on 'Send' Button");
        waitHelper.waitForElementToBeClickable(signInPage.signInButton);
        signInPage.clickOnSignInButton();

        log.info("Validate Message Existence after clicking on 'Send' button");
        waitHelper.waitUntilElementWillBeVisible(signInPage.messageBox);
        String messageText = signInPage.getMessageBoxText();
        softAssert.assertEquals(messageText, "Wrong credentials");

        softAssert.assertAll();
    }
}
