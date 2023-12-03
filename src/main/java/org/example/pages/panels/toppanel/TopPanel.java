package org.example.pages.panels.top_panel;

import org.example.pages.BasePage;
import org.example.pages.panels.top_panel.signedIn.UserProfile;
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
    public AuthElement authElement;

    public TopPanel(Class clazz, WebDriver driver) {
        super(driver);
        if (clazz.isAssignableFrom(UserProfile.class)) {
            authElement = new UserProfile(driver);
        } else if (clazz.isAssignableFrom(SignInElement.class)) {
            authElement = new SignInElement(driver);
        } else throw new RuntimeException("Specify correct class!");
    }

    public void pressOnVlumeImg() {
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
        boolean commonSectionIsLoaded = super.pageIsLoaded(this.logo, this.selectLanguage);
        final List<Boolean> allElementsAreLoaded = new ArrayList<>();
        allElementsAreLoaded.add(commonSectionIsLoaded);
        sectionIsLoaded(authElement, allElementsAreLoaded);
        return allElementsAreLoaded
                .stream()
                .anyMatch(sectionIsLoaded -> sectionIsLoaded);
    }

    private void sectionIsLoaded(BasePage authMutableObject, List<Boolean> authElementIsLoaded) {
        Arrays.stream(authMutableObject.getClass().getDeclaredMethods())
                .filter(method -> method.getName().contains("IsLoaded"))
                .forEach(method -> {
                    try {
                        Boolean returnValue = (Boolean) method.invoke(authMutableObject);
                        authElementIsLoaded.add(returnValue);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException("Failed to invoke 'IsLoaded' method");
                    }
                });
    }

    public AuthElement getInstanceAuthElement() {
        return authElement;
    }
}
