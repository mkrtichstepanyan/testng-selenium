package org.example.vlume.providers.urlproviders.toppanel.menuuser.setting;

public enum UrlSettingProvider {

    SETTINGS_PAGE_URL("https://dev.vlume.com/settings");
    private final String url;

    UrlSettingProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
