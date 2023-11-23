package forgotpassword;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordNegativeTest extends ForgotPasswordBaseTest {

    @Test
    public void forgotPasswordWithoutUsernameNegativeTest() {
        forgotPasswordPage.clickOnSendButton();
        forgotPasswordWithoutUsername();
    }

    @Test
    public void forgotPasswordWrongFormatNegativeTest() {
        forgotPasswordWithoutUsernameNegativeTest();
        forgotPasswordWrongFormat();
    }

    @Test
    public void forgotPasswordWrongEmailNegativeTest() {
        forgotPasswordPage.sendKeysOnUsernameInput("abc@gmail.com");
        forgotPasswordPage.clickOnSendButton();
        waitHelper.waitForElementToBeVisibility(forgotPasswordPage.errorMassage);

        Assert.assertEquals(forgotPasswordPage.errorMassage.getText(), "The user with specified email address not exist.");
    }

    @Test(enabled = false)
    public void forgotPasswordWithoutUsernameNegativeTestAfterWrongEmail() {
        forgotPasswordWrongEmailNegativeTest();
        forgotPasswordPage.clearUsernameInput();
        forgotPasswordWithoutUsername();
    }

    @Test(enabled = false)
    public void forgotPasswordWithoutUsernameNegativeTestAfterWrongFormatEmail() {
        forgotPasswordWrongFormatNegativeTest();
        forgotPasswordPage.clearUsernameInput();
        forgotPasswordWithoutUsername();
    }

    @Test
    public void forgotPasswordWrongFormatNegativeTestAfterWrongEmail() {
        forgotPasswordWrongEmailNegativeTest();
        forgotPasswordPage.clearUsernameInput();
        forgotPasswordWrongFormat();
    }

    @Test
    public void forgotPasswordWrongFormatNegativeTestAfterWrongFormatEmail() {
        forgotPasswordWrongFormatNegativeTest();
        forgotPasswordPage.clearUsernameInput();
        forgotPasswordWrongFormat();
    }

    private void forgotPasswordWithoutUsername() {
        Assert.assertEquals(forgotPasswordPage.emailIsRequired.getText(), "Email is required");
    }

    private void forgotPasswordWrongFormat() {
        forgotPasswordPage.sendKeysOnUsernameInput("wrongFormatEmail");
        Assert.assertEquals(forgotPasswordPage.wrongEmailFormat.getText(), "Wrong email format");
    }
}
