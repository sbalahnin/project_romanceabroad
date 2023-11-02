package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MainPage extends BaseActions {


    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String currentUrlMedia;
    String currentUrlBlog;
    String currentUrlGifts;
    String currentUrlHowWeWork;
    String currentUrlSignIn;
    String currentUrlTourUkraine;
    String currentUrlSearch;

    public void clickJoinButton() {
        Reports.log ("Wait Join button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_REGISTRATION));

        Reports.log("Click Join button");
        driver.findElement(Locators.BUTTON_REGISTRATION).click();

    }

    public void completeFirstPartOfRegistration(String email, String password) {
//        Reports.log("Wait email text field");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Reports.log("Type email in text field: " + email);
        driver.findElement(Locators.TEXT_FIELD_EMAIL).sendKeys(email);

        Reports.log("Wait email text field");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locators.TEXT_FIELD_PASSWORD)));

        Reports.log("Type password in text field: " + password);
        driver.findElement(Locators.TEXT_FIELD_PASSWORD).sendKeys(password);


    }

    public void clickNextButton() {
        Reports.log("Wait Next button");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.BUTTON_NEXT));

        Reports.log("Click Next button");
        driver.findElement(Locators.BUTTON_NEXT).click();
        driver.findElement(Locators.BUTTON_NEXT).click();
    }

    public void completeSecondPartOfRegistration(String nickname, String phone, String day,
                                                 String month, String year, String city, String location) {

        Reports.log("Type nickname in text field: " + nickname);
        driver.findElement(Locators.TEXT_FIELD_NICKNAME).sendKeys(nickname);

        Reports.log("Click List of days");
        driver.findElement(Locators.LIST_DATE).click();

        Reports.log("Select specific date of birth:"+ day);
        clickValueOfList(Locators.DATE_OF_BIRTH, day);

        Reports.log("Click list of months");
        driver.findElement(Locators.LIST_MONTH).click();

        Reports.log("Select specific month:" + month);
        clickValueOfList(Locators.MONTH_OF_BIRTH, month);

        Reports.log("Click list of years");
        driver.findElement(Locators.LIST_YEAR).click();

        Reports.log("Select specific year: " + year);
        clickValueOfList(Locators.YEAR_OF_BIRTH, year);

        Reports.log("Type phone number: " + phone);
        driver.findElement(Locators.TEXT_FIELD_PHONE).sendKeys(phone);

        Reports.log("Click Confirmation checkbox");
        driver.findElement(Locators.CHECKBOX_CONFIRMATION).click();

        Reports.log("Clean location autofilling form");
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).clear();

        Reports.log("Type one of the city: " + city);
        driver.findElement(Locators.AUTOFILLING_FORM_LOCATION).sendKeys(city);

        Reports.log("Select specific location: " + location);
        clickValueOfList(Locators.LIST_VALUE_LOCATION, location);

//        WebElement checkboxConfirmation = driver.findElement(com.romanceabroad.ui.Locators.CHECKBOX_CONFIRMATION);
//        boolean selectedCheckBox = checkboxConfirmation.isSelected();
//        System.out.println(selectedCheckBox + "!!!!!!!");
//        checkboxConfirmation.click();
    }


    public String verifyBlogLink() {
        driver.findElements(Locators.BLOG_LINK).get(Locators.indexLinkBlog).click();
        currentUrlBlog = driver.getCurrentUrl();
        return currentUrlBlog;
    }

    public String verifyGiftLink() {
        driver.findElement(Locators.GIFTS_LINK).click();
        currentUrlGifts = driver.getCurrentUrl();
        return currentUrlGifts;
    }

    public String verifyHowWeWorkLink() {
        driver.findElement(Locators.HOW_WE_WORK_LINK).click();
        currentUrlHowWeWork = driver.getCurrentUrl();
        return currentUrlHowWeWork;
    }


    public String verifySignInLink() {
        driver.findElement(Locators.LINK_SIGN_IN).click();
        currentUrlSignIn = driver.getCurrentUrl();
        return currentUrlSignIn;
    }

    public String verifyTourToUkraineLink() {
        driver.findElement(Locators.TOUR_TO_UKRAINE_LINK).click();
        currentUrlTourUkraine = driver.getCurrentUrl();
        return currentUrlTourUkraine;
    }

    public String verifyMediaLink() {
        driver.findElement(Locators.LINK_MEDIA).click();
        javaWaitSec(3);
        currentUrlMedia = driver.getCurrentUrl();
        System.out.println(currentUrlMedia);
        return currentUrlMedia;

    }
    public String verifySearchLink() {
        driver.findElement(Locators.LINK_SEARCH).click();
        currentUrlSearch = driver.getCurrentUrl();
        return currentUrlSearch;
    }

}