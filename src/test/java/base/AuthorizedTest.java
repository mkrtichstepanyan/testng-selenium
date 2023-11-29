package base;

import base.BaseTest;
import dataProvider.url.UrlsProvider;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.PageAssertion;
import org.example.pages.authorization.SignInPage;
import org.example.pages.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

@Slf4j(topic = "AuthorizationLogger")
public class AuthorizedTest extends BaseTest {
    protected SignInPage signInPage;
    protected HomePage homePage;

    @BeforeClass
    @Override
    public void setup() {
        super.setup();

        goToURL(UrlsProvider.SIGN_IN_PAGE_URL);
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);

        log.info("Perform sign in");
        PageAssertion.assertSignIn(signInPage);

        log.info("Assert home page is openid");
        Assert.assertTrue(homePage.isPageOpened());
    }
}

