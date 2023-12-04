package org.example.providers.urlproviders.footer;

public enum UrlAboutProvider {

    SUPPORT_PAGE_URL("https://vlume.com/w/support/"),
    ACCOUNTS_SUBSCRIPTIONS_URL("https://vlume.com/w/category/accounts-subscriptions/"),
    VLUME_FOR_INSTITUTIONS_PAGE_URL("https://vlume.com/w/category/institution-accounts/"),
    VLUME_KEYBOARD_PAGE_URL("https://chromewebstore.google.com/detail/vlume-keyboard/ffgbbmfhmcfaphemeigfmcejcgnehjjd");


    private final String url;

    UrlAboutProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
