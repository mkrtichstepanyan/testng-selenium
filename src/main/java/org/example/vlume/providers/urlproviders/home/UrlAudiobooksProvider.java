package org.example.vlume.providers.urlproviders.home;

public enum UrlAudiobooksProvider {

    RECENTLY_ADDED_AUDIOBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_RECENT/AB"),
    TRENDING_NOW_AUDIOBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TRENDING/AB"),
    OUR_TOP_PICKS_AUDIOBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_POPULAR/AB"),
    MOST_READ_AUDIOBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_MOST_READ/AB"),
    TOP_FICTION_AUDIOBOOKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TOP_FICTION/AB"),
    TOP_NON_FICTION_AUDIOBOOKS_URL("https://dev.vlume.com/stack/STK_SITE_TOP_NONFICTION/AB");

    private final String url;

    UrlAudiobooksProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
