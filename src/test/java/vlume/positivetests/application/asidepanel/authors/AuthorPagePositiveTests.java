package vlume.positivetests.application.asidepanel.authors;

import lombok.extern.slf4j.Slf4j;
import org.example.vlume.pages.application.asidepanel.authors.AuthorsPage;
import org.example.vlume.pages.authentication.signin.SignInPage;
import org.example.vlume.providers.urlproviders.home.UrlAsidePanelProvider;
import org.example.vlume.providers.urlproviders.welcome.UrlProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import vlume.BaseTest;

@Slf4j
public class AuthorPagePositiveTests extends BaseTest {

    SignInPage signInPage;
    AuthorsPage authorsPage;

    @BeforeClass
    public void goToUrl() {
        log.info("-> Open sign in page");
        driver.get(UrlProvider.SIGN_IN_PAGE_URL.getUrl());
        signInPage = new SignInPage(driver);

        log.info("-> Sign in");
        signInPage.signIn();

        waitHelper.waitForSeconds(3);
        driver.get(UrlAsidePanelProvider.HOME_PAGE_URL.getUrl());
    }

    @Test
    public void goToAuthorsPage() {

        log.info("-> Open Authors page");
        driver.get(UrlAsidePanelProvider.AUTHORS_PAGE_URL.getUrl());
        authorsPage = new AuthorsPage(driver);
        Assert.assertTrue(authorsPage.authorsPageIsLoaded(), "Authors page os not loaded");
    }

}
