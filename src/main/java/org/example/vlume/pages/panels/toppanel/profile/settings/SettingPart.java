package org.example.vlume.pages.panels.toppanel.profile.settings;

import org.example.vlume.BasePage;
import org.example.vlume.pages.panels.toppanel.profile.settings.authenticationproviderparts.AuthenticationProviderPartDiv;
import org.example.vlume.pages.panels.toppanel.profile.settings.manageaccountparts.ManageAccountPartsDiv;
import org.example.vlume.pages.panels.toppanel.profile.settings.profileparts.ProfilePartDiv;
import org.example.vlume.pages.panels.toppanel.profile.settings.readinglanguageparts.ReadingLanguagePartDiv;
import org.openqa.selenium.WebDriver;

public class SettingPart extends BasePage {
    public AuthenticationProviderPartDiv authenticationProviderPartDiv;
    public ManageAccountPartsDiv manageAccountPartsDiv;
    public ProfilePartDiv profilePartDiv;
    public ReadingLanguagePartDiv readingLanguagePartDiv;

    protected SettingPart(WebDriver driver) {
        super(driver);
    }
}
