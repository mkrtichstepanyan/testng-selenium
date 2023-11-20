package signup;

import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest extends DriverFactory {

    protected WebDriver driver;

    protected WaitHelper waitHelper;

    @BeforeClass
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
    }

}
