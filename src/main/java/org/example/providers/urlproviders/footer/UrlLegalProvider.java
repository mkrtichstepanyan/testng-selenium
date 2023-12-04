package org.example.providers.urlproviders.footer;

public enum UrlLegalProvider {

    PRIVACY_POLICY_PAGE_URL("https://vlume.com/privacy"),
    TERMS_OF_SERVICE_PAGE_URL("https://vlume.com/terms");

    private final String url;

    UrlLegalProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
