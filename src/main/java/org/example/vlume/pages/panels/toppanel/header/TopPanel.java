package org.example.vlume.pages.panels.toppanel.header;

import org.example.vlume.BasePage;
import org.example.vlume.pages.panels.toppanel.header.signedin.UserProfileIcon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopPanel extends BasePage {
    @FindBy(xpath = "//img[@class='logo']")
    public WebElement logo;

    @FindBy(id = "selectLanguage")
    public WebElement selectLanguage;

    @FindBy(id = "hy")
    public WebElement selectLanguageHy;

    @FindBy(id = "hw")
    public WebElement selectLanguageHw;

    @FindBy(id = "en")
    public WebElement selectLanguageEn;

    public AuthenticationElement authenticationElement;

    public TopPanel(WebDriver driver, Class clazz) {
        super(driver);
        if (clazz.isAssignableFrom(UserProfileIcon.class)) {
            authenticationElement = new UserProfileIcon(driver);
        } else if (clazz.isAssignableFrom(SignInButton.class)) {
            authenticationElement = new SignInButton(driver);
        } else throw new RuntimeException("Specify correct class");

    }

    public void pressOnVlumeLogo() {
        this.logo.click();
    }

    public void pressOnLanguage() {
        this.selectLanguage.click();
    }

    public void pressFromLanguageHy() {
        this.selectLanguageHy.click();
    }

    public void pressFromLanguageHw() {
        this.selectLanguageHw.click();
    }

    public void pressFromLanguageEn() {
        this.selectLanguageEn.click();
    }

    public boolean topPanelIsLoaded() {
        boolean commonPartIsLoaded = super.pageIsLoaded(this.logo, this.selectLanguage);
        final List<Boolean> allElementsAreLoaded = new ArrayList<>();
        allElementsAreLoaded.add(commonPartIsLoaded);
        partIsLoaded(authenticationElement, allElementsAreLoaded);
        return allElementsAreLoaded
                .stream()
                .allMatch(sectionIsLoaded -> sectionIsLoaded);
    }

    private void partIsLoaded(BasePage authenticationMutableObject,
                              List<Boolean> authenticationElementIsLoaded) {
        Arrays.stream(authenticationMutableObject.getClass().getDeclaredMethods())
                .filter(method -> method.getName().contains("IsLoaded"))
                .forEach(method -> {
                    try {
                        Boolean returnValue = (Boolean) method.invoke(authenticationMutableObject);
                        authenticationElementIsLoaded.add(returnValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to invoke 'IsLoaded' method");
                    }
                });
    }
}
