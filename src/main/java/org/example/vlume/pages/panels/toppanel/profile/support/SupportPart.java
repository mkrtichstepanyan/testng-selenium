package org.example.vlume.pages.panels.toppanel.profile.support;

import org.example.vlume.BasePage;
import org.example.vlume.pages.panels.toppanel.profile.support.aboutvlumepages.AboutVlumePageDiv;
import org.example.vlume.pages.panels.toppanel.profile.support.accountandsubscriptionpages.AccountAndSubscriptionPageDiv;
import org.example.vlume.pages.panels.toppanel.profile.support.institutionalaccountpages.InstitutionalAccountPageDiv;
import org.example.vlume.pages.panels.toppanel.profile.support.readingwithvlumepages.ReadingWithVlumePageDiv;
import org.example.vlume.pages.panels.toppanel.profile.support.vlumekeyboardpages.VlumeKeyboardPageDiv;
import org.openqa.selenium.WebDriver;

public class SupportPart extends BasePage {

    public AboutVlumePageDiv aboutVlumePageDiv;
    public AccountAndSubscriptionPageDiv accountAndSubscriptionPageDiv;
    public InstitutionalAccountPageDiv institutionalAccountPageDiv;
    public ReadingWithVlumePageDiv readingWithVlumePageDiv;
    public VlumeKeyboardPageDiv vlumeKeyboardPageDiv;

    protected SupportPart(WebDriver driver) {
        super(driver);
    }
}
