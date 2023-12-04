package org.example.providers.urlproviders.footer;

public enum UrlAppProvider {

    APP_STORE_LOGO_URL("https://apps.apple.com/us/app/vlume/id1325346984"),
    GOOGLE_PLAY_LOGO_URL("https://play.google.com/store/apps/details?id=com.vlume.app&hl=en_US");

    private final String url;

    UrlAppProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
