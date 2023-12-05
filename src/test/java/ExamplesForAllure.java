import base.AuthorizedTest;
import dataProvider.url.UrlsProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import lombok.extern.slf4j.Slf4j;
import org.example.pages.settings.SettingsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExamplesForAllure extends AuthorizedTest {

    SettingsPage settingsPage;

    @BeforeMethod
    public void goReadingPage() {
        goToURL(UrlsProvider.SETTINGS_PAGE_URL);
        settingsPage = new SettingsPage(driver);

        log.info("Assert settings page is opened");
        assertThat(settingsPage.isPageOpened()).withFailMessage("SETTINGS PAGE IS NOT OPENED").isTrue();
    }

    @Test
    @Description("for example allure fail")
    @Severity(MINOR)
    public void failTest() {
        assertThat(1).isGreaterThan(2);
    }

    @Test(dependsOnMethods = "failTest")
    @Description("for example allure fail")
    @Severity(MINOR)
    public void skippTest2() {
        assertThat(1).isEqualTo(1);
    }

    @Test
    @Description("for example allure fail")
    @Severity(MINOR)
    public void failTest3() {
        assertThat(1).isGreaterThan(2);
    }

    @Test(dependsOnMethods = "failTest3")
    @Description("for example allure fail")
    @Severity(MINOR)
    public void skippTest4() {
        assertThat(1).isEqualTo(1);
    }
}
