package org.example.auth.signup;

import lombok.extern.slf4j.Slf4j;
import org.example.BaseTest;
import org.example.helpers.WaitHelper;
import org.example.pages.wordpress.welcomepage.WelcomePage;
import org.testng.annotations.BeforeMethod;


@Slf4j
public class SignUpPositiveTest extends BaseTest {
    private final String SIGN_UP_PAGE_URL = "https://dev.vlume.com/sign-up";

    WelcomePage welcomePage;

    WaitHelper waitHelper;

    @BeforeMethod
    public void goToUrl() {
        log.info("Go to welcome page");
        driver.get("https://dev.vlume.com/");
        welcomePage = new WelcomePage(driver);
    }
}

