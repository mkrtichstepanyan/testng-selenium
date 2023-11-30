package org.example.vlume.providers.urlproviders.toppanel.menuuser.support;

public enum UrlSupportProvider {

    SUPPORT_PAGE_URL("https://vlume.com/w/support/");

    private final String url;

    UrlSupportProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
