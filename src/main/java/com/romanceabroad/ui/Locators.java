package com.romanceabroad.ui;

import org.openqa.selenium.By;

public class Locators {

    public static final By H1_TITLE = By.xpath("//h1");

    //MainPage
    public static final By YOUTUBE_LINK = By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']");
    public static final By YOUTUBE_PLAY_BUTTON = By.cssSelector("button.ytp-large-play-button.ytp-button");
    public static final By TITLE_OF_PAGE = By.xpath("//h1");
    public static final By TAB_OF_MAIN_PAGE = By.xpath("//ul[@class='navbar-nav']//li");

    //HowWeWork page
    public static final By HOW_WE_WORK_LINK = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By IMAGES = By.xpath("//a[@class='g-pic-border g-rounded']");

    //GiftsLink
    public static final By GIFTS_LINK = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");

    //TourToUkraine Link
    public static final By TOUR_TO_UKRAINE_LINK = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine'][text()='TOUR TO UKRAINE']");

    //Photos page
    public static final By LINK_MEDIA = By.cssSelector("a[href='https://romanceabroad.com/media/index']");
    public static final By LINK_TAB_USER_PROFILE = By.xpath("//ul[@id='gallery_filters']//a");

    //Blog page
    public static final By BLOG_LINK = By.cssSelector("a[class='nav-link ']");
    public static final int indexLinkBlog = 2;

    //SignIn page
    public static final By LINK_SIGN_IN = By.xpath("//a[@href='https://romanceabroad.com/users/login_form']");
    public static final By TEXT_FIELD_SIGN_IN_EMAIL = By.xpath("//div[@class='col-xs-8']//input[@id='email']");
    public static final By TEXT_FIELD_SIGN_IN_PASSWORD = By.xpath("//div[@class='col-xs-8']//input[@id='password']");
    public static final By BUTTON_SIGN_IN = By.xpath("//button[@type='submit']");
    public static final By SIGN_IN_ERROR_MESSAGE = By.xpath("//div[@class='error alert-danger alert-warning_pop_']");
    //Registration
    public static final By BUTTON_REGISTRATION = By.xpath("//button[@id='show-registration-block']");
    //public static final By BUTTON_NEXT = By.xpath("//button[@data-action='next-page'][text()='Next']");
    public static final By BUTTON_NEXT = By.xpath("//div[@class='col-xs-12']//button[text()='Next']");
    public static final By TEXT_FIELD_EMAIL = By.cssSelector("input#email");
    public static final By TEXT_FIELD_PASSWORD = By.cssSelector("input#password");
    public static final By TEXT_FIELD_NICKNAME = By.cssSelector("input#nickname");
    public static final By TEXT_FIELD_PHONE = By.cssSelector("input[name='data[phone]']");
    public static final By TOOLTIP_ERROR = By.xpath("//div[@class='tooltip']");

    //Day drop down selected
    public static final By LIST_DATE = By.xpath("//div[@id='daySelect']");
    public static final By DATE_OF_BIRTH = By.xpath("//li[@data-handler='selectDay']");

    //MONTH DROP DOWN
    public static final By LIST_MONTH = By.xpath("//div[@id='monthSelect']");
    public static final By MONTH_OF_BIRTH = By.xpath("//li[@data-handler='selectMonth']");

    //YEAR DROP DOWN
    public static final By LIST_YEAR = By.xpath("//div[@id='yearSelect']");
    public static final By YEAR_OF_BIRTH = By.xpath("//li[@data-handler='selectYear']");

    public static final By TEXT_FIELD_LOCATION = By.cssSelector("input[placeholder='Type your location']");
    public static final By CHECKBOX_CONFIRMATION = By.cssSelector("input#confirmation");
    public static final By AUTOFILLING_FORM_LOCATION = By.xpath("//input[@name='region_name']");
    public static final By LIST_VALUE_LOCATION = By.xpath("//div[@class='dropdown_dropdown_location']//ul//li");

    //Search
    public static final By LINK_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By DROP_DOWN_LIST_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By DROP_DOWN_LIST_MAX_AGE = By.cssSelector("select#age_max");
    public static final By DROP_DOWN_LIST_MIN_AGE = By.cssSelector("select#age_min");
    public static final By BUTTON_SEARCH = By.cssSelector("#main_search_button_user_advanced");
    public static final By TEXT_USER_INFO = By.xpath("//div[@class='text-overflow']");


    // Blog Page
    public static final By LINK_BLOG_TAB = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By LINKS_OF_ARTICLES = By.xpath("//ul[@class='nav nav-pills nav-stacked content-pages-tree']//li");

    //ContactUs page
    public static final By LINK_CONTACT_US = By.xpath("//a[@href='https://romanceabroad.com/tickets/']//div[@class='footer-menu-list-group-item-text']");

    // Links of Footer
    public static final By FOOTER_LINKS = By.xpath("//div[@class='footer-menu-list-group-item-text']");

}


