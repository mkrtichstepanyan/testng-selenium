package org.example.vlume.providers.urlproviders.footer;

public enum UrlSocialMediaProvider {

    FACEBOOK_PAGE_URL("https://www.facebook.com/vlumeapp"),
    TWITTER_PAGE_URL("https://twitter.com/vlumeapp");

    private final String url;

    UrlSocialMediaProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
