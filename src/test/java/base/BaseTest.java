package base;

import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.util.Iterator;
import java.util.Set;

public class BaseTest extends DriverFactory {

    protected WebDriver driver;

    protected WaitHelper waitHelper;

    @BeforeClass
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
    }

    public String nextWidow() {
        Set<String> setWidows = driver.getWindowHandles();
        Iterator<String> iterator = setWidows.iterator();
        String currentWindow = iterator.next();
        while (iterator.hasNext()){
            currentWindow = iterator.next();
        }
        return currentWindow;
    }
}
