package org.example.providers.urlproviders.welcome;

public enum UrlProvider {
    WELCOME_PAGE_URL("https://dev.vlume.com/"),

    SIGN_IN_PAGE_URL("https://dev.vlume.com/sign-in"),
    SIGN_UP_PAGE_URL("https://dev.vlume.com/sign-up"),
    FORGOT_PASSWORD_PAGE_URL("https://dev.vlume.com/forgot-password");

    private final String url;

    UrlProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
