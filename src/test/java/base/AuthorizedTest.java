package base;

import dataProvider.url.UrlsProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.PageAssertion;
import org.example.pages.authorization.SignInPage;
import org.example.pages.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Slf4j(topic = "AuthorizationLogger")
public class AuthorizedTest extends BaseTest {
    protected SignInPage signInPage;
    protected HomePage homePage;

    @BeforeClass
    @Override
    @Description("This step test we use when we need authorization")
    @Severity(CRITICAL)
    @Owner("John Doe")
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

