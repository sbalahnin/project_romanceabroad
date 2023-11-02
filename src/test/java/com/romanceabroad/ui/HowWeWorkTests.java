package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class HowWeWorkTests extends BaseUI {
    String nameOfArticle;
    String titleOfArticle;


    @Test
    public void testHowWeWorkLink() {
        String howWeWorkLink = mainPage.verifyHowWeWorkLink();
        System.out.println(howWeWorkLink);
        Assert.assertEquals(howWeWorkLink, Data.expectedUrlHowWeWok);

    }


    @Test
    public void testArticlesAndTitles() {
        mainPage.verifyHowWeWorkLink();
        List<WebElement> linksOfArticles = howWeWorkPage.collectAllLinksOfArticles();

        for (int i = 0; i < linksOfArticles.size(); i++) {
            WebElement link = linksOfArticles.get(i);
            nameOfArticle = link.getText();
            link.click();
            titleOfArticle = howWeWorkPage.getAnyTitle();
            System.out.println(titleOfArticle);
            //Assert.assertEquals(nameOfArticle, titleOfArticle);
            linksOfArticles = howWeWorkPage.collectAllLinksOfArticles();
        }

    }

}









