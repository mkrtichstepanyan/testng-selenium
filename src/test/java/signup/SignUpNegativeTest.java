package signup;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class SignUpNegativeTest extends SignUpBaseTest {

    @Test
    public void withoutEmailAndPasswordsSignUpNegativeTest() {
        log.info("Executing withoutEmailAndPasswordsSignUpNegativeTest");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Email is required", signUpPage.emailIsRequired.getText());
        Assert.assertEquals("Password is required", signUpPage.passwordIsRequired.getText());
    }

    @Test
    public void withoutPasswordsSignUpNegativeTest() {
        log.info("Executing withoutPasswordsSignUpNegativeTest");
        signUpPage.enterTheEmail("test@mail.ru");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Password is required", signUpPage.passwordIsRequired.getText());
    }

    @Test
    public void withWrongFormatEmailWithoutPasswordsSignUpNegativeTest() {
        log.info("Executing unexcitedEmailNegativeSignUpTest");
        signUpPage.enterTheEmail("wrongFormatEmail");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Wrong email", signUpPage.wrongEmail.getText());
        Assert.assertEquals("Password is required", signUpPage.passwordIsRequired.getText());
    }

    @Test
    public void passwordsNotMatchNegativeSignUpTest() {
        log.info("Executing passwordsNotMatchNegativeSignUpTest");
        setUsernameAndPasswordsAndClickSignUpButton("test@mail.ru", "password", "passWord");
        Assert.assertEquals("Passwords must match", signUpPage.passwordsMustMatch.getText());
    }

    @Test
    public void passwordsNotMatchWrongFormatEmailNegativeSignUpTest() {
        log.info("Executing passwordsNotMatchWrongFormatEmailNegativeSignUpTest");
        setUsernameAndPasswordsAndClickSignUpButton("WrongFormatEmail", "password", "passWord");
        Assert.assertEquals("Wrong email", signUpPage.wrongEmail.getText());
        Assert.assertEquals("Passwords must match", signUpPage.passwordsMustMatch.getText());
    }

    @Test
    public void wrongFormatPasswordWrongFormatEmailNegativeSignUpTest() {
        log.info("Executing wrongFormatPasswordWrongFormatEmailNegativeSignUpTest");
        setUsernameAndPasswordsAndClickSignUpButton("WrongFormatEmail", "pass", "pass");
        Assert.assertEquals("Wrong email", signUpPage.wrongEmail.getText());
        Assert.assertEquals("Password should be at least 8 characters", signUpPage.passwordRegex.getText());
    }

    @Test
    public void wrongFormatPasswordNegativeSignUpTest() {
        log.info("Executing wrongFormatPasswordNegativeSignUpTest");
        setUsernameAndPasswordsAndClickSignUpButton("test@mail.ru", "pass", "pass");
        Assert.assertEquals(signUpPage.passwordRegex.getText(), "Password should be at least 8 characters");
    }

    @Test
    @SneakyThrows
    public void unexcitedEmailNegativeSignUpTest() {
        log.info("Executing unexcitedEmailNegativeSignUpTest");
        setUsernameAndPasswordsAndClickSignUpButton("test@mail.ru", "password", "password");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

}
