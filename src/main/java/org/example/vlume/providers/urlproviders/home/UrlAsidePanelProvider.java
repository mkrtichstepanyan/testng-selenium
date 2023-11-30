package org.example.vlume.providers.urlproviders.home;

public enum UrlAsidePanelProvider {

    HOME_PAGE_URL("https://dev.vlume.com/"),
    SEARCH_PAGE_URL("https://dev.vlume.com/search?type=title&search_text=&Audiobook=1&Ebook=1&Animation=1&Language=en,hy&Dialect=&Spelling="),
    AUDIOBOOKS_PAGE_URL("https://dev.vlume.com/audiobooks"),
    EBOOKS_PAGE_URL("https://dev.vlume.com/ebooks"),
    AUTHORS_PAGE_URL("https://dev.vlume.com/authors"),
    MY_LIST_PAGE_URL("https://dev.vlume.com/my-list"),
    NEW_LIST_PAGE_URL("https://dev.vlume.com/reading-list/create"),
    GIFT_PAGE_UAR("https://dev.vlume.com/gift"),
    CHOOSE_A_PACKAGE_PAGE_URL("https://dev.vlume.com/package");

    private final String url;

    UrlAsidePanelProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
