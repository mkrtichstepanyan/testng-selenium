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
        forgotPasswordPage.enterTheEmail("abc@gmail.com");
        forgotPasswordPage.clickOnSendButton();
        waitHelper.waitForElementToBeVisible(forgotPasswordPage.errorMassage);

        Assert.assertEquals(forgotPasswordPage.errorMassage.getText(), "The user with specified email address not exist.");
    }

    @Test(enabled = false)
    public void forgotPasswordWithoutUsernameNegativeTestAfterWrongEmail() {
        forgotPasswordWrongEmailNegativeTest();
        forgotPasswordPage.clearEmailInput();
        forgotPasswordWithoutUsername();
    }

    @Test(enabled = false)
    public void forgotPasswordWithoutUsernameNegativeTestAfterWrongFormatEmail() {
        forgotPasswordWrongFormatNegativeTest();
        forgotPasswordPage.clearEmailInput();
        forgotPasswordWithoutUsername();
    }

    @Test
    public void forgotPasswordWrongFormatNegativeTestAfterWrongEmail() {
        forgotPasswordWrongEmailNegativeTest();
        forgotPasswordPage.clearEmailInput();
        forgotPasswordWrongFormat();
    }

    @Test
    public void forgotPasswordWrongFormatNegativeTestAfterWrongFormatEmail() {
        forgotPasswordWrongFormatNegativeTest();
        forgotPasswordPage.clearEmailInput();
        forgotPasswordWrongFormat();
    }

    private void forgotPasswordWithoutUsername() {
        Assert.assertEquals(forgotPasswordPage.emailIsRequired.getText(), "Email is required");
    }

    private void forgotPasswordWrongFormat() {
        forgotPasswordPage.enterTheEmail("wrongFormatEmail");
        Assert.assertEquals(forgotPasswordPage.wrongEmailFormat.getText(), "Wrong email format");
    }
}
