package org.example.vlume.pages.autentication.forgotpassword;

import org.example.vlume.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "username")
    public WebElement email;

    @FindBy(id = "send")
    public WebElement sendButton;

    @FindBy(id = "goToSignIn")
    public WebElement goToSignIn;
    @FindBy(xpath = "//snack-bar-container//span")
    public WebElement messageBox;
    @FindBy(id = "emailIsRequired")
    public WebElement emailIsRequiredValidationMessage;

    @FindBy(id = "wrongEmailFormat")
    public WebElement wrongEmailFormatValidationMessage;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void pressOnEnterEmail() {
        this.email.click();
    }

    public void pressOnSendButton() {
        this.sendButton.click();
    }

    public void pressOnGoToSignIn() {
        this.goToSignIn.click();
    }
    public String getMessageBoxText() {
        return this.messageBox.getText();
    }

    public boolean forgotPasswordPageIsLoaded() {
        return super.pageIsLoaded(this.email, this.sendButton, this.goToSignIn);
    }
    public void enterEmail(String email) {
        inputHelper.fieldsAreEmpty(this.email);
        this.email.sendKeys(email);
    }
}
