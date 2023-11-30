package org.example.vlume.providers.urlproviders.toppanel.menuuser.membership;

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
