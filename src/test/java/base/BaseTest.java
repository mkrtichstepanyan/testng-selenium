package base;

import org.example.driver.DriverFactory;
import org.example.helpers.WaitHelper;
import org.example.pages.wordpress.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverFactory {

    protected WebDriver driver;

    protected WaitHelper waitHelper;

    protected WelcomePage welcomePage;


    @BeforeMethod
    public void setup() {
        driver = getDriver();
        waitHelper = new WaitHelper(driver);
        welcomePage = new WelcomePage(driver);
    }

}
