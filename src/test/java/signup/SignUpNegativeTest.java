package signup;

import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpNegativeTest extends SignUpBaseTest {

    @Test
    public void withoutEmailAndPasswordsSignUpNegativeTest() {
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Email is required", signUpPage.emailIsRequired.getText());
        Assert.assertEquals("Password is required", signUpPage.passwordIsRequired.getText());
    }

    @Test
    public void withoutPasswordsSignUpNegativeTest() {
        signUpPage.sendKeysOnUsernameInput("test@mail.ru");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Password is required", signUpPage.passwordIsRequired.getText());
    }

    @Test
    public void withWrongFormatEmailWithoutPasswordsSignUpNegativeTest() {
        signUpPage.sendKeysOnUsernameInput("wrongFormatEmail");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Wrong email", signUpPage.wrongEmail.getText());
        Assert.assertEquals("Password is required", signUpPage.passwordIsRequired.getText());
    }

    @Test
    public void passwordsNotMatchNegativeSignUpTest() {
        signUpPage.sendKeysOnUsernameInput("test@mail.ru");
        signUpPage.sendKeysOnPasswordInput("password");
        signUpPage.sendKeysOnPasswordInput("passWord");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Passwords must match", signUpPage.passwordsMustMatch.getText());
    }

    @Test
    public void passwordsNotMatchWrongFormatEmailNegativeSignUpTest() {
        signUpPage.sendKeysOnUsernameInput("WrongFormatEmail");
        signUpPage.sendKeysOnPasswordInput("password");
        signUpPage.sendKeysOnPasswordInput("passWord");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Wrong email", signUpPage.wrongEmail.getText());
        Assert.assertEquals("Passwords must match", signUpPage.passwordsMustMatch.getText());
    }

    @Test
    public void wrongFormatPasswordWrongFormatEmailNegativeSignUpTest() {
        signUpPage.sendKeysOnUsernameInput("WrongFormatEmail");
        signUpPage.sendKeysOnPasswordInput("pass");
        signUpPage.sendKeysOnConfirmPasswordInput("pass");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals("Wrong email", signUpPage.wrongEmail.getText());
        Assert.assertEquals("Password should be at least 8 characters", signUpPage.passwordRegex.getText());
    }

    @Test
    public void wrongFormatPasswordNegativeSignUpTest() {
        signUpPage.sendKeysOnUsernameInput("test@mail.ru");
        signUpPage.sendKeysOnPasswordInput("pass");
        signUpPage.sendKeysOnConfirmPasswordInput("pass");
        signUpPage.clickOnSignUpButton();
        Assert.assertEquals(signUpPage.passwordRegex.getText(), "Password should be at least 8 characters");
    }

    @Test
    @SneakyThrows
    public void unexcitedEmailNegativeSignUpTest() {
        signUpPage.sendKeysOnUsernameInput("test@mail.ru");
        signUpPage.sendKeysOnPasswordInput("password");
        signUpPage.sendKeysOnConfirmPasswordInput("password");
        signUpPage.clickOnSignUpButton();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }


}
