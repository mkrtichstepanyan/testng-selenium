package org.example.vlume.providers.urlproviders.toppanel.menuuser.support;

public enum UrlVlumeKeyboardProvider {

    ABOUT_LINK_URL("https://vlume.com/w/docs/vlume-keyboard/"),
    EXPLORE_MORE_BUTTON_URL("https://vlume.com/w/category/keyboard/");

    private final String url;

    UrlVlumeKeyboardProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
