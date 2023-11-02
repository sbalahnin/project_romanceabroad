package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BlogTests extends BaseUI {
    String nameOfArticle;
    String titleOfArticle;

    @Test
    public void testBlogLink() {
        String blogLink = mainPage.verifyBlogLink();
        System.out.println(blogLink);
        Assert.assertEquals(blogLink, Data.expectedUrlBlog);
    }

    @Test
    public void collectAllLinksOfArticles() {
        List<WebElement> linksOfArticles = blogPage.collectAllLinksOfArticles();

        for (int i = 0; i < linksOfArticles.size(); i++) {
            WebElement link = linksOfArticles.get(i);
            nameOfArticle = link.getText();
            if (nameOfArticle.contains("How it Works")) {
            }
            if (nameOfArticle.contains("Kharkov dating agency")) {
            }
            if (nameOfArticle.contains("Kiev dating agency")) {
            } else {
                link.click();
                titleOfArticle = blogPage.getAnyTitle();
                Assert.assertEquals(nameOfArticle, titleOfArticle);
                linksOfArticles = blogPage.collectAllLinksOfArticles();

            }
        }
    }
}


