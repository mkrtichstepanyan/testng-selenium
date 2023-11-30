package org.example.vlume.providers.urlproviders.toppanel.menuuser.support;

public enum UrlAccountsAndSubscriptionProvider {

    PASSWORD_RECOVERY_LINK_URL("https://vlume.com/w/docs/password-recovery/"),
    SIGNING_UP_LINK_URL("https://vlume.com/w/docs/signing-up/"),
    CANCEL_YOUR_MEMBERSHIP_LINK_URL("https://vlume.com/w/docs/cancel-your-membership/"),
    DELETE_YOUR_VLUME_ACCOUNT_LINK_URL("https://vlume.com/w/docs/delete-account/"),
    WXPLORE_MORE_BUTTON_URL("https://vlume.com/w/category/accounts-subscriptions/");

    private final String url;

    UrlAccountsAndSubscriptionProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
