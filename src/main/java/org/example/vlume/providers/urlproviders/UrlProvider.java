package org.example.vlume.providers.urlproviders;

public enum UrlProvider {


    WELCOME_PAGE_URL("https://dev.vlume.com/"),
    HOME_PAGE_URL("https://dev.vlume.com/"),
    SIGN_IN_PAGE_URL("https://dev.vlume.com/sign-in"),
    SIGN_UP_PAGE_URL("https://dev.vlume.com/sign-up"),
    FORGOT_PASSWORD_PAGE_URL("https://dev.vlume.com/forgot-password"),
    AUDIOBOOKS_PAGE_URL("https://dev.vlume.com/audiobooks"),
    EBOOKS_PAGE_URL("https://dev.vlume.com/ebooks"),
    AUTHORS_PAGE_URL("https://dev.vlume.com/authors"),
    RECENTLY_ADDED_PAGE_UPL("https://dev.vlume.com/stack/STK_SITE_RECENT"),
    TRENDING_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TRENDING"),
    CATEGORIES_PAGE_URL("https://dev.vlume.com/search?type=title&Audiobook=1&Ebook=1&Animation=1&Language=en,hy&Dialect=&Spelling="),
    FACEBOOK_PAGE_URL("https://www.facebook.com/vlumeapp"),
    TWITTER_PAGE_URL("https://twitter.com/vlumeapp"),
    PRIVACY_POLICY_PAGE_URL("https://vlume.com/privacy"),
    TERMS_OF_SERVICE_PAGE_URL("https://vlume.com/terms"),
    SUPPORT_PAGE_URL("https://vlume.com/w/support/"),
    ACCOUNTS_SUBSCRIPTIONS_URL("https://vlume.com/w/category/accounts-subscriptions/"),
    VLUME_FOR_INSTITUTIONS_PAGE_URL("https://vlume.com/w/category/institution-accounts/"),
    VLUME_KEYBOARD_PAGE_URL("https://chromewebstore.google.com/detail/vlume-keyboard/ffgbbmfhmcfaphemeigfmcejcgnehjjd"),
    GIFT_PAGE_UAR("https://dev.vlume.com/gift"),
    APP_STORE_LOGO_URL("https://apps.apple.com/us/app/vlume/id1325346984"),
    GOOGLE_PLAY_LOGO_URL("https://play.google.com/store/apps/details?id=com.vlume.app&hl=en_US"),
    OUR_TOP_PICKS_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_POPULAR"),
    NEW_RELEASES_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_NEW_RELEASE"),
    MOST_READ_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_MOST_READ"),
    TOP_FICTION_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TOP_FICTION"),
    TOP_NON_FICTION_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_TOP_NONFICTION"),
    FREE_THIS_MONTH_PAGE_URL("https://dev.vlume.com/stack/STK_SITE_FREE"),
    CHOOSE_A_PACKAGE_PAGE_URL("https://dev.vlume.com/package"),
    MY_LIST_PAGE_URL("https://dev.vlume.com/my-list"),
    NEW_LIST_PAGE_URL("https://dev.vlume.com/reading-list/create"),
    SEARCH_PAGE_URL("https://dev.vlume.com/search?type=title&search_text=&Audiobook=1&Ebook=1&Animation=1&Language=en,hy&Dialect=&Spelling=");


    private final String url;

    UrlProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
