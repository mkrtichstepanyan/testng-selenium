package signin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPositiveTest extends SignInBaseTest {


    @Test
    public void signInPositiveTest() {
        setUsernameAndPasswordAndClickLogInButton("zara.avetyan.2004@mail.ru", "correctPassword");
        waitHelper.waitForElementToBeVisibility(By.xpath("//div[@class='menu-item-container'][1]"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/");
    }
}
