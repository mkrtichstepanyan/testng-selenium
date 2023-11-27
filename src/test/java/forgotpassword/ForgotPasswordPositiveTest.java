package forgotpassword;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordPositiveTest extends ForgotPasswordBaseTest {
    @Test
    public void forgotPasswordPositiveTest() {
        forgotPasswordPage.enterTheEmail("zara.avetyan.2004@mail.ru");
        forgotPasswordPage.clickOnSendButton();
        waitHelper.waitForElementToBeVisible(signInPage.forgotPasswordButton);
        Assert.assertEquals("https://dev.vlume.com/sign-in", driver.getCurrentUrl());
        waitHelper.waitForElementToBeVisible(forgotPasswordPage.passwordResetLink);
        Assert.assertEquals(forgotPasswordPage.passwordResetLink.getText(), "Password reset link was sent to your email");
    }
}
