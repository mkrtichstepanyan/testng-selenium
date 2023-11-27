package signin;

import lombok.SneakyThrows;
import org.example.pages.home.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPositiveTest extends SignInBaseTest {


    @Test
    public void signInPositiveTest() {
        setUsernameAndPasswordAndClickLogInButton("zara.avetyan.2004@mail.ru", "correctPassword");
        HomePage homePage = new HomePage(driver);
//        homePage.isPageOpened();
        waitHelper.waitForElementsToBeVisible(homePage.webElements);
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/");

    }
}
