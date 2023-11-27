package forgotpassword;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClickGoToSignInButtonTest extends ForgotPasswordBaseTest {
    @Test
    public void clickGoToSignInButton() {
        forgotPasswordPage.clickGoToSignInPageButton();
        signInPage.isPageOpened();
        Assert.assertEquals(driver.getCurrentUrl(), "https://dev.vlume.com/sign-in");
    }
}
