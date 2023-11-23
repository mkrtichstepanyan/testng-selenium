package forgotpassword;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordPositiveTest extends ForgotPasswordBaseTest {
    @Test
    public void forgotPasswordPositiveTest() {
        forgotPasswordPage.sendKeysOnUsernameInput("zara.avetyan.2004@mail.ru");
        forgotPasswordPage.clickOnSendButton();
        waitHelper.waitForElementToBeVisibility(signInPage.forgotPasswordButton);
        Assert.assertEquals("https://dev.vlume.com/sign-in", driver.getCurrentUrl());
        waitHelper.waitForElementToBeVisibility(forgotPasswordPage.passwordResetLink);
        Assert.assertEquals(forgotPasswordPage.passwordResetLink.getText(), "Password reset link was sent to your email");
    }
}
