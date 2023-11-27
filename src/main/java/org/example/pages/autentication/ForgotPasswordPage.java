package org.example.pages.autentication;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {
    @FindBy(id = "username")
    public WebElement emailField;

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

    public void enterEmail(String email) {
        inputHelper.fieldsAreEmpty(this.emailField);
        this.emailField.sendKeys(email);
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
        return super.pageIsLoaded(this.emailField, this.sendButton, this.goToSignIn);
    }
}
