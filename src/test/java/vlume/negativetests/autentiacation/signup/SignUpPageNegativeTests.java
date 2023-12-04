package vlume.negativetests.autentiacation.signup;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.authentication.signup.SignUpPage;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import vlume.BaseTest;

@Slf4j
public class SignUpPageNegativeTests extends BaseTest {
    SignUpPage signUpPage;

    @BeforeMethod
    public void goToUrl() {
        log.info("-> Open Sign Up Page");
        driver.get(UrlProvider.SIGN_UP_PAGE_URL.getUrl());
        signUpPage = new SignUpPage(driver);
        softAssert = new SoftAssert();

        log.info("-> Sign Up Page is Loaded Successfully");
        boolean pageIsLoaded = signUpPage.signUpPageIsLoaded();
        softAssert.assertTrue(pageIsLoaded);

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }

    @Test
    public void validatePressOnSignUpButtonWithoutEnteringData() {
        log.info("-> Make sure fields are Clear");
        inputHelper.fieldsAreEmpty(signUpPage.emailField, signUpPage.passwordField,
                signUpPage.confirmPasswordField);
        softAssert.assertTrue(inputHelper.getValue(signUpPage.emailField).isEmpty() &&
                inputHelper.getValue(signUpPage.passwordField).isEmpty() &&
                inputHelper.getValue(signUpPage.confirmPasswordField).isEmpty());

        log.info("-> Press on <Sign Up> button");
        waitHelper.waitForElementToBeClickable(signUpPage.signUpButton);
        signUpPage.pressOnSignUpButton();

        log.info("-> Validate Message Existence after pressed on <Sign Up> button");
        String emailIsRequiredText = inputHelper.getValue(signUpPage.emailIsRequiredValidationMessage);
        String passwordIsRequiredText = inputHelper.getValue(signUpPage.passwordIsRequiredValidationMessage);
        softAssert.assertTrue(emailIsRequiredText.equals("Email is required"));
        softAssert.assertTrue(passwordIsRequiredText.equals("Password is required"));

        log.info("-> Test succeeded");
        softAssert.assertAll();
    }
}
