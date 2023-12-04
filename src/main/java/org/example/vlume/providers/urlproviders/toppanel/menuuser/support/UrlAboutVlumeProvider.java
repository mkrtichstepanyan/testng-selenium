package org.example.vlume.providers.urlproviders.toppanel.menuuser.support;

public enum UrlAboutVlumeProvider {

    ABOUNT_VLUME_LINK_URL("https://vlume.com/w/category/about-vlume/"),
    SUPPORT_LINK_URL("https://vlume.com/w/docs/support/"),
    EXPLORE_MORE_BUTTON_URL("https://vlume.com/w/category/about-vlume/");

    private final String url;

    UrlAboutVlumeProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
