package com.virco.locators;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
public interface ContentManagementPageLocators {

    String WCMS_PAGE_SIGN = "//td[contains(text(),'WCMS Page View')]";
    String MENU_DROPDOWN = "//div[@class='menulabel']//span";
    String LOGOUT_MENU_ITEM = "//a[contains(text(),'Logout')]";
    String USABB_SITE_MENU_ITEM = "//div[contains(@class,'advancedPanel')]//span[text() ='UsaBlueBook Site']";
    String USABB_CONTENT_CATALOG = "//div[@class='advancedGroupboxPreLabel']//span[text()='virco Content Catalog / $1']";
    String SPINNER = "//div[@id='zk_loading']//span";
    String PAGE_CONTENT_TEMPLATE = "//span[text()='$1']";
    String CMS_PAGE_ACTIONS_BUTTON = "//div[@class='cms_page_actions']//img[@title='$1']";
    String CMS_SYNCH_BUTTON = "//div[@class='cms_page_actions']//img[@title='Approval status']/following-sibling::img[1]";
    String CMS_PAGE_EDIT_BUTTON_IN_SECTION = "//span[contains(text(),'$1')]/ancestor::div[5]//img[@title='$2']";
    String BOTTOM_TEXT_AREA = "//textarea";
    String EDIT_AREA_NAME_TITLE = "//span[@title='name']";
    String TOP_FRAME_ICON_BY_TITLE = "//*[@title='$1']";
    String PAGINATION_BUTTON_WITH_NAME = "(//button[contains(@class,'z-paging-$1')])[1]";
    String POP_UP_BUTTON = "//td[@class='z-button-cm' and text()='$1']";
    String DISPLAY_LABEL = "//span[contains(text(),'$1')]/ancestor::div[5]//span[text()='$2']";
    String BUTTON_ON_SECTION_HEADER = "//span[contains(text(),'$1')]/ancestor::div[5]//a[@title='$2']";
    String TEMPLATE_FROM_CREATE_MODAL = "//div[@class='wizardContentFrame']//span[contains(text(),'$1')]";
    String WCMS_CONTENT_SEARCH_FIELD = "//div[@class='z-groupbox-header']//input[@size='25']";
    String WCMS_TOP_HEADER_SEARCH_BUTTON = "//table[contains(@class,'searchbtn')]//img";
    String WCMS_CONTENT_FRAME = "//div[@class='contentEditorEntry']//iframe";
    String CONTENT_EDIT_COMPONENT = "//table[@class='contentEditorGroupHeader z-hbox']/following-sibling::div//span";
    String WCMS_CONTENT_SOURCE_BUTTON = "//div[@title='Source']//td[text()='Source']";
    String SEARCH_BUTTON_IN_MODAL = "(//div[@class='advSearchBottomToolbar']//img)[3]";
    String MODAL_RESULTS_TABLE_VALUE = "(//span[text()='$1'])[1]";
    String BANNER_COMPONENT_GENERAL = "//div[contains(@class,'simple-banner-overlaid-with-text')]";
}
