package vlume;

import org.example.vlume.driver.DriverFactory;
import org.example.vlume.helper.InputHelper;
import org.example.vlume.helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest extends DriverFactory {
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected SoftAssert softAssert;
    protected InputHelper inputHelper;

    @BeforeClass
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
        inputHelper = new InputHelper();
    }
}
