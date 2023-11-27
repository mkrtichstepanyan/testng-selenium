package signup;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Slf4j
public class SignUpPositiveTest extends SignUpBaseTest {

    @Test
    private void positiveSignUpTest() {

        setUsernameAndPasswordsAndClickSignUpButton("zara.avetyan.2004@gmail.com", "password", "password");
        log.info("Entered username and passwords, and clicked on Sign Up button");

        waitHelper.waitForElementToBeVisible(By.className("edit-text"));
        log.info("Sign-up completed successfully");
    }
}
