package signin;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInNegativeTest extends SignInBaseTest {

    private void negativeSignInTest(String username, String password) {
        setUsernameAndPasswordAndClickLogInButton(username, password);
        waitHelper.waitForElementToBeVisible(signInPage.errorMassage);
        Assert.assertEquals(signInPage.errorMassage.getText(), "Wrong credentials");
    }


    @Test
    public void wrongPasswordSignInTest() {
        negativeSignInTest("zara.avetyan.2004@mail.ru", "wrongPassword");
    }

    @Test
    public void wrongUsernameSignInTest() {
        negativeSignInTest("wrongUsername", "correctPassword");
    }

    @Test
    public void wrongUsernameAndPasswordSignInTest() {
        negativeSignInTest("wrongUsername", "wrongPassword");
    }
}
