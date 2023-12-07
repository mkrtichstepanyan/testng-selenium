package base;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import lombok.extern.slf4j.Slf4j;
import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.example.helpers.WriteHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Slf4j
public class BaseTest extends DriverFactory {

    protected WebDriver driver;

    protected WriteHelper writeHelper;

    protected WaitHelper waitHelper;

    @BeforeClass
    @Severity(CRITICAL)
    @Owner("Garik Gharibyan")
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
        writeHelper = new WriteHelper(driver);
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
