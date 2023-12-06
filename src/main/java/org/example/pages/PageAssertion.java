package org.example.pages;

import dataProvider.email.EmailsProvider;
import dataProvider.password.PasswordsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.membership.PaymentDetailsPage;
import org.example.pages.authorization.SignInPage;
import org.testng.Assert;

@Slf4j
public class PageAssertion {

    public static void assertSignIn(SignInPage signInPage) {
        log.info("Assert sign in page is opened");
        Assert.assertTrue(signInPage.isPageOpened());

        log.info("Write correct email {}", EmailsProvider.correctEmail);
        signInPage.inputEmail.sendKeys(EmailsProvider.correctEmail);

        log.info("Write correct password {}", PasswordsProvider.correctPassword);
        signInPage.inputPassword.sendKeys(PasswordsProvider.correctPassword);

        log.info("Clock on sign in button");
        signInPage.clickOnSignInButton();
    }
}
