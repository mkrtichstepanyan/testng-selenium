package org.example.vlume.providers.urlproviders.footer;

public enum UrlPageProvider {

    CATEGORIES_PAGE_URL("https://dev.vlume.com/search?type=title&Audiobook=1&Ebook=1&Animation=1&Language=en,hy&Dialect=&Spelling=");

    private final String url;

    UrlPageProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
