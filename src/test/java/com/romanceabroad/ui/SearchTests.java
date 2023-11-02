package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class SearchTests extends BaseUI {
    String currentUrlSearch;
    public static final boolean testCase11 = true;
    public static final boolean testCase12 = true;
    public static final boolean testCase13 = true;


    @Test(priority = 2, enabled = testCase12, groups = {"firefox", "user", "admin"})
    public void testSearchPageTestCase12() {
        mainPage.verifySearchLink();
        currentUrlSearch = driver.getCurrentUrl();
        System.out.println(currentUrlSearch);
        // Assert.assertEquals(currentUrlSearch, com.romanceabroad.ui.Data.expectedUrlSearch);
        softAssert.assertEquals(currentUrlSearch, Data.expectedUrlSearch, "Url is wrong");
        searchPage.getDropDownListByIndex(Locators.DROP_DOWN_LIST_SORT_BY, 3);

    }


    @Test
    public void Loops1() {
        String actualTitle;
        String actualUrlPrettyWomen;
        String expectedUrlPrettyWomen = "https://romanceabroad.com/users/search";
        String expectedTitleHowWeWork = "Ukrainian women for marriage";
        String expectedTitlePrettyWomen = "Single Ukrainian women online";
        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println("Number of links = " + links.size());

        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            if (info.contains("WORK")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(expectedTitleHowWeWork, actualTitle);
            }
            if (info.contains("PRETTY WOMEN")) {
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWomen = driver.getCurrentUrl();
                Assert.assertEquals(expectedTitlePrettyWomen, actualTitle);
                Assert.assertEquals(actualUrlPrettyWomen, expectedUrlPrettyWomen);
                driver.findElement(Locators.IMAGES).isDisplayed();
                if (actualUrlPrettyWomen.contains("#")) {
                    System.out.println("It contains restricted #");
                    Assert.fail("It contains #");
                } else {
                    System.out.println("No special character. Url is good");

                }
            }


            driver.get(mainUrl);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }

    @Test(priority = 3, enabled = testCase11, groups = {"user", "admin"})
    public void selectRandomDropDownListOnSearchPageTestCase11() {
        mainPage.verifySearchLink();
        int sizeOfDropDownListSortBy = searchPage.getSizeDropDownList(Locators.DROP_DOWN_LIST_MAX_AGE);
        System.out.println(sizeOfDropDownListSortBy);
        for (int i = 0; i < sizeOfDropDownListSortBy; i++) {
            searchPage.selectItemDropDownRandomOption(Locators.DROP_DOWN_LIST_MAX_AGE, "Sort by");
            mainPage.javaWaitSec(3);
        }

    }

    @Test(dataProvider = "Search", dataProviderClass = DataProviders.class, priority = 1, enabled = testCase13, groups = {"user", "admin"})
    public void searchDifferentResults13(String minAge, String maxAge, String sortBy) {
        int min = Integer.parseInt(minAge);
        int max = Integer.parseInt(maxAge);

        mainPage.verifySearchLink();
        searchPage.getDropDownListByText(Locators.DROP_DOWN_LIST_MIN_AGE, minAge);
        searchPage.getDropDownListByText(Locators.DROP_DOWN_LIST_MAX_AGE, maxAge);
        searchPage.getDropDownListByText(Locators.DROP_DOWN_LIST_SORT_BY, sortBy);
        searchPage.clickSearchButton();


        List<WebElement> infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);
        for (int i = 0; i < infoAboutUser.size(); i++) {
            if (i % 2 == 0) {
                String info = infoAboutUser.get(i).getText();
                String[] splitedPhrase = info.split(",");
                String age = splitedPhrase[1];
                int ageNum = Integer.parseInt(age);
                if (min <= ageNum || ageNum <= max) {
                    System.out.println("This age is: " + ageNum + " is correct");
                }else{
                    Assert.fail("Wrong age: " + ageNum);
                }
            }
            mainPage.javaWaitSec(3);
            infoAboutUser = driver.findElements(Locators.TEXT_USER_INFO);

        }
    }

}


