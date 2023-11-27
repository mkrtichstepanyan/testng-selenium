package org.example.vlumetests.negativetests;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.pages.autentication.SignUpPage;
import org.example.providers.urlproviders.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Slf4j
public class SignUpPageTests extends BaseTest {
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("Open Sign Up Page");
        driver.get(UrlProvider.SIGN_UP_PAGE_URL.getUrl());
        signUpPage = new SignUpPage(driver);
        softAssert = new SoftAssert();

        log.info("Sign Up Page is Loaded Successfully");
        boolean pageIsLoaded = signUpPage.signUpPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        softAssert.assertAll();
    }

    @Test
    public void validatePressOnSignUpButtonWithoutEnteringData() {
        log.info("Make sure fields are Clear");
        inputHelper.fieldsAreEmpty(signUpPage.emailField, signUpPage.passwordField, signUpPage.confirmPasswordField);
        softAssert.assertTrue(inputHelper.getValue(signUpPage.emailField).isEmpty() &&
                inputHelper.getValue(signUpPage.passwordField).isEmpty() &&
                inputHelper.getValue(signUpPage.confirmPasswordField).isEmpty());

        log.info("Click on 'Sign Up' button");
        waitHelper.waitForElementToBeClickable(signUpPage.signUpButton);
        signUpPage.clickOnSignUpButton();

        log.info("Validate Message Existence after clicking on 'Sign Up' Button");
        String emailIsRequiredText = inputHelper.getValue(signUpPage.emailIsRequiredValidationMessage);
        String passwordIsRequiredText = inputHelper.getValue(signUpPage.passwordIsRequiredValidationMessage);
        softAssert.assertTrue(emailIsRequiredText.equals("Email is required"));
        softAssert.assertTrue(passwordIsRequiredText.equals("Password is required"));

        softAssert.assertAll();
    }
}
