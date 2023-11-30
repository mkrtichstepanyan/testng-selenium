package org.example.vlume.providers.urlproviders.toppanel.menuuser.support;

public enum UrlReadingWithVlumeProvider {

    INSTALLING_VLUME_APP_LINK_URL("https://vlume.com/w/docs/install-vlume/"),
    WEB_BROWSER_ACCESS_LINK_URL("https://vlume.com/w/docs/browser-access/"),
    EXPLORE_MORE_BUTTON_URL("https://vlume.com/w/category/reading/");

    private final String url;

    UrlReadingWithVlumeProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
