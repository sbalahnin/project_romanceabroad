package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BaseActions {
    String currentMarinaUserUrl;
    String currentUrlContactUs;


    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifyDropDownList() {
        WebElement dropDownListSortBy = driver.findElement(Locators.DROP_DOWN_LIST_SORT_BY);
        getDropDownListByValue(Locators.DROP_DOWN_LIST_SORT_BY, "date_created");

    }
    public String verifyContactUsLink() {
        driver.findElement(Locators.LINK_CONTACT_US).click();
        currentUrlContactUs = driver.getCurrentUrl();
        return currentUrlContactUs;
    }

    public void clickSearchButton() {

        driver.findElement(Locators.BUTTON_SEARCH).click();
    }

    public String verifyMarinaUserUrl() {
        driver.findElement(By.xpath("//a[text()='Marina_mari_']")).click();
        currentMarinaUserUrl = driver.getCurrentUrl();
        return currentMarinaUserUrl;

    }

    public List<WebElement> collectAllLinksOfFooter() {
        List<WebElement> footerLinks = driver.findElements(Locators.FOOTER_LINKS);
        return footerLinks;
    }
}






