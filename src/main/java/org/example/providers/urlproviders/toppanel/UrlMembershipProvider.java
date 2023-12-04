package org.example.providers.urlproviders.toppanel;

public enum UrlMembershipProvider {

    MEMBERSHIP_PAGE_URL("https://dev.vlume.com/membership"),
    LINK_MEMBERSHIP_PAGE_URL("https://dev.vlume.com/accounts");

    private final String url;

    UrlMembershipProvider(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
