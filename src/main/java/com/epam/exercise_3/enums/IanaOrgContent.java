package com.epam.exercise_3.enums;

public enum IanaOrgContent {
    DOMAIN_NAMES("Domain Names"),
    TEXT_IN_DOMAIN_SECTION("Management of the DNS Root Zone (assignments of ccTLDs and gTLDs)" +
            " along with other functions such as the .int and .arpa zones."),
    LINK_ROOT_ZONE_MANAGEMENT("http://www.iana.org/domains/root"),
    TEXT_UNDER_LOGO("The global coordination of the DNS Root, IP addressing, and other Internet protocol" +
            " resources is performed as the Internet Assigned Numbers Authority (IANA) functions. Learn more."),
    LINK("http://www.iana.org/");

    public String text;

    IanaOrgContent(String text) {
        this.text = text;
    }
}
