package org.example.vlume.providers.urlproviders.home;

public enum UrlHomeProvider {

    RECENTLY_ADDED_PAGE_UPL("https://dev.vlume.com/stack/STK_SITE_RECENT"),
    FREE_THIS_MONTH_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_FREE"),
    TRENDING_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TRENDING"),
    OUR_TOP_PICKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_POPULAR"),
    NEW_RELEASES_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_NEW_RELEASE"),
    MOST_READ_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_MOST_READ"),
    TOP_FICTION_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TOP_FICTION"),
    TOP_NON_FICTION_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TOP_NONFICTION");

    private final String url;

    UrlHomeProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    }
