package org.example.vlume.providers.urlproviders.toppanel.menuuser.support;

public enum UrlInstitutionalAccountProvider {
    LINK_TOUR_ACCOUNT_LINK_URL("https://vlume.com/w/docs/link-account/"),
    PARTNERING_LIBRARIES_LINK_URL("https://vlume.com/w/docs/partnering-libraries/"),
    EXPLORE_MORE_BUTTON_URL("https://vlume.com/w/category/institution-accounts/");

    private final String url;

    UrlInstitutionalAccountProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
