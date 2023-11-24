package base;

import lombok.extern.slf4j.Slf4j;
import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;

@Slf4j
public class BaseTest extends DriverFactory {

    protected WebDriver driver;

    protected WaitHelper waitHelper;

    protected final String WELCOME_PAGE_URL = "https://dev.vlume.com/";
    protected final String SIGN_IN_PAGE_URL = "https://dev.vlume.com/sign-in";

    protected final String SIGN_UP_PAGE_URL = "https://dev.vlume.com/sign-up";
    protected final String FORGOT_PASSWORD_PAGE_URL = "https://dev.vlume.com/forgot-password";

    @BeforeClass
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
    }

    public String nextWidow() {
        Set<String> setWidows = driver.getWindowHandles();
        Iterator<String> iterator = setWidows.iterator();
        String currentWindow = iterator.next();
        while (iterator.hasNext()) {
            currentWindow = iterator.next();
        }
        return currentWindow;
    }

    public void goToURL(String url) {
        log.info("Go to URL {} ", url);
        driver.get(url);
    }
}
