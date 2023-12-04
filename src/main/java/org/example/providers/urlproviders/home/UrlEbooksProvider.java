package org.example.providers.urlproviders.home;

public enum UrlEbooksProvider {

    RECENTLY_ADDED_EBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_RECENT/EB"),
    TRENDING_NOW_EBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TRENDING/EB"),
    OUR_TOP_PICKS_EBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_POPULAR/EB"),
    MOST_READ_EBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_MOST_READ/EB"),
    TOP_FICTION_EBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TOP_FICTION/EB"),
    TOP_NON_FICTION_EBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TOP_NONFICTION/EB");

    private final String url;

    UrlEbooksProvider(String url){
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
