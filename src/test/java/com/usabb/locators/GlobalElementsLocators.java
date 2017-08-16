package com.usabb.locators;

public interface GlobalElementsLocators {
    String HEADER_NAVIGATION_MENU_ITEMS = "//div[@class='navigation__overflow']//span/a";
    String HEADER_GLOBAL = "//header";
    String BODY = "//body";
    String HEADER_LOGO = "//div[@class='banner__component banner']//img";
    String FOOTER_SOCIAL_LINKS = "//div[contains(text(),'Follow Us')]/following-sibling::*//a";
    String FOOTER_LINK_BY_NAME = "//footer//a[contains(text(),'$1')]";
    String HEADER_WELCOME_SIGN = "//header//ul[contains(@class,'account')]/li[1]";
    String HEADER_MY_ACCOUNT_BUTTON = "(//header//a[text()='My Account'])[1]";
    String HEADER_SIGN_OUT_BUTTON = "//header//ul[contains(@class,'account')]/li[3]";
    String BADGE_BY_NAME = "//footer//img[contains(@src,'$1')]";
    String HEADER_CATEGORIES = "//header//div[@class='navigation__overflow']/ul[2]//span/a";
    String LAST_BREADCRUMB = "//ol[@class='breadcrumb']//li[@class='active']";
    String HEADER_LINK = "//header//a[text()='$1']";
    String HEADER_MY_ACCOUNT_LINK = "//header//ul[@class='nav__links']//a[text()='$1']";
    String COPYRIGHT = "//div[contains(@class,'footer__copyright')]";
    String MY_ACCOUNT_NAV_LINKS = "//ul[@class='nav__links']//a";
    String CONTRACT_DROP_DOWN = "//form[@id='contractForm']//div[@class='selectric']";
    String TITLE_IN_FOOTER = "//footer//h4[text()='$1']";
    String TELEPHONE_INFORMATION = "//footer//p";
    String FOLLOW_US_TITLE = "//footer//div[text()='Follow Us On']";
    String ROTATING_CAROUSEL_MAIN = "//div[@id='homepage_slider']";
    String ALL_CAROUSEL_SLOTS = "//div[@id='homepage_slider']//li";
    String ALL_CAROUSEL_ELEMENTS = "//div[@id='homepage_slider']//$1";
    String CONTENT_OF_BANNER = "//div[@id='homepage_slider']//li//div[contains(@class,'infobox')]";
    String BREADCRUMB_ITEMS = "//ol[@class='breadcrumb']/li";
    String PAGE_TITLE_ON_HOME_PAGE = "//div[@class='list-categories']/h3";
    String ALL_CATEGORIES_ON_HOME_PAGE = "//div[@class='list-categories']//strong";
    String DROP_DOWN_IN_HEADER = "//li[@class='submenu']/a[text()='$1']";
    String BANNER_HEADER_TEXT = "//div[@class='top-content']//h2";
    String BANNER_TEXT = "//div[@class='top-content']//p[2]";
}
