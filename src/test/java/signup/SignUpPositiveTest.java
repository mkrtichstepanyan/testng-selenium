package signup;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUpPositiveTest extends SignUpBaseTest {

    @Test
    @SneakyThrows
    private void positiveSignUpTest() {
        signUpPage.sendKeysOnUsernameInput("zara.avetyan.2004@gmail.com");
        signUpPage.sendKeysOnPasswordInput("password");
        signUpPage.sendKeysOnConfirmPasswordInput("password");
        signUpPage.clickOnSignUpButton();
        Thread.sleep(5000);
        waitHelper.waitForElementToBeVisibility(By.className("edit-text"));
    }
}
